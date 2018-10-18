package com.test.lucene;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.springframework.stereotype.Component;


/**
 * <pre>
 * 	Lucene创建索引、全局搜索服务类
 * </pre>
 * 
 * @author nicky
 * @version 1.00.00
 * 
 *          <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期:2018年04月18日     修改内容:
 *          </pre>
 */
@Component
public class LuceneIndexer {
	
	private volatile static LuceneIndexer instance;
//	
//	private LuceneIndexer(){}
	
	/**
	 * 双检锁/双重校验锁（DCL，即 double-checked locking）
	 * @return instance
	 */
//	public static LuceneIndexer getInstance(){
//		if(instance == null){
//			synchronized (LuceneIndexer.class) {
//				if(instance == null){
//					instance = new LuceneIndexer();
//				}
//			}
//		}
//		return instance;
//	}
	
//	private static Analyzer analyzer;
//	private static Directory directory;
	private IndexWriter indexWriter;
//	private static IndexWriterConfig config;
	
	private final static String INDEX_DIR = "D:\\lucene";

	private static class SingletonHolder{  
	      private final static LuceneIndexer instance=new LuceneIndexer();  
	}  
	
	public static LuceneIndexer getInstance(){  
	      return SingletonHolder.instance;  
	}  
	
	public boolean createIndex(String indexDir) throws IOException{
		//加点测试的静态数据
		Integer ids[] = {1 , 2 , 3};
		String titles[] = {"标题1" , "标题2" , "标题3"};
		String tcontents[] = {
				"内容1内容啊哈哈哈",
				"内容2内容啊哈哈哈",
				"内容3内容啊哈哈哈"
		};

		long startTime = System.currentTimeMillis();//记录索引开始时间
		
		Analyzer analyzer = new SmartChineseAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexDir));
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		
		IndexWriter indexWriter = new IndexWriter(directory, config);

		for(int i = 0; i < ids.length;i++){
			Document doc = new Document();
			//添加字段
	        doc.add(new TextField("id", ids[i].toString(),Field.Store.YES)); //添加内容
	        doc.add(new TextField("title", titles[i], Field.Store.YES)); //添加文件名，并把这个字段存到索引文件里
	        doc.add(new TextField("tcontent", tcontents[i], Field.Store.YES)); //添加文件路径
	        indexWriter.addDocument(doc);
		}

		indexWriter.commit();
		System.out.println("共索引了"+indexWriter.numDocs()+"个文件");
		indexWriter.close();
		System.out.println("创建索引所用时间："+(System.currentTimeMillis()-startTime)+"毫秒");
		
		return true;
	}

//	private void addDocument(File file) throws IOException{
//		Document doc = new Document();
//		//添加字段
//        doc.add(new TextField("contents", new FileReader(file))); //添加内容
//        doc.add(new TextField("fileName", file.getName(), Field.Store.YES)); //添加文件名，并把这个字段存到索引文件里
//        doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES)); //添加文件路径
//
//        indexWriter.addDocument(doc);
//	}
//
//	private void closeWriter() throws IOException{
//		 if (indexWriter != null) {
//	            indexWriter.close();
//	        }
//	}
	
	public static void main(String[] args) {
		try {
			boolean r = LuceneIndexer.getInstance().createIndex(INDEX_DIR);
			if(r){
				System.out.println("索引创建成功!");
			}else{
				System.out.println("索引创建失败!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	
}
