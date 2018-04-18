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
	
	private final static String DATA_DIR = "D:\\lucene\\data";
	
	private static class SingletonHolder{  
	      private final static LuceneIndexer instance=new LuceneIndexer();  
	}  
	
	public static LuceneIndexer getInstance(){  
	      return SingletonHolder.instance;  
	}  
	
	public static boolean createIndex(String indexDir , String dataDir) throws IOException{
		long startTime = System.currentTimeMillis();//记录索引开始时间
		
		Analyzer analyzer = new SmartChineseAnalyzer();
		Directory directory = FSDirectory.open(Paths.get(indexDir));
		IndexWriterConfig config = new IndexWriterConfig(analyzer);
		
		IndexWriter indexWriter = new IndexWriter(directory, config);
		
		File[] files = new File(dataDir).listFiles();
		for(File file : files){
			Document doc = new Document();
			//添加字段
	        doc.add(new TextField("contents", new FileReader(file))); //添加内容
	        doc.add(new TextField("fileName", file.getName(), Field.Store.YES)); //添加文件名，并把这个字段存到索引文件里
	        doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES)); //添加文件路径
	       
	        indexWriter.addDocument(doc);
		}
		
		
		
		System.out.println("共索引了"+indexWriter.numDocs()+"个文件");
		
		indexWriter.commit();
		indexWriter.close();
		System.out.println("创建索引所用时间："+(System.currentTimeMillis()-startTime));
		
		return true;
	}
	
	
	
	private void addDocument(File file) throws IOException{
		Document doc = new Document();
		//添加字段
        doc.add(new TextField("contents", new FileReader(file))); //添加内容
        doc.add(new TextField("fileName", file.getName(), Field.Store.YES)); //添加文件名，并把这个字段存到索引文件里
        doc.add(new TextField("fullPath", file.getCanonicalPath(), Field.Store.YES)); //添加文件路径
       
        indexWriter.addDocument(doc);
	}
	
	private void closeWriter() throws IOException{
		 if (indexWriter != null) {
	            indexWriter.close();
	        }
	}
	
	public static void main(String[] args) {
		try {
			boolean r = LuceneIndexer.getInstance().createIndex(INDEX_DIR,DATA_DIR);
			if(r){
				System.out.println("创建成功!");
			}else{
				System.out.println("创建失败!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	
}
