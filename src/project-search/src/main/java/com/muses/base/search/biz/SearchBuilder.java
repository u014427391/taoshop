package com.muses.base.search.biz;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.highlight.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Paths;


/**
 * <pre>
 * 	Lucene全局搜索服务类
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
public class SearchBuilder {

    public static void doSearch(String indexDir , String queryStr) throws IOException, ParseException, InvalidTokenOffsetsException {
        Directory directory = FSDirectory.open(Paths.get(indexDir));
        DirectoryReader reader = DirectoryReader.open(directory);
        IndexSearcher searcher = new IndexSearcher(reader);
        Analyzer analyzer = new SmartChineseAnalyzer();
        QueryParser parser = new QueryParser("tcontent",analyzer);
        Query query = parser.parse(queryStr);

        long startTime = System.currentTimeMillis();
        TopDocs docs = searcher.search(query,10);

        System.out.println("查找"+queryStr+"所用时间："+(System.currentTimeMillis()-startTime));
        System.out.println("查询到"+docs.totalHits+"条记录");

        //加入高亮显示的
        SimpleHTMLFormatter simpleHTMLFormatter = new SimpleHTMLFormatter("<b><font color=red>","</font></b>");
        QueryScorer scorer = new QueryScorer(query);//计算查询结果最高的得分
        Fragmenter fragmenter = new SimpleSpanFragmenter(scorer);//根据得分算出一个片段
        Highlighter highlighter = new Highlighter(simpleHTMLFormatter,scorer);
        highlighter.setTextFragmenter(fragmenter);//设置显示高亮的片段

        //遍历查询结果
        for(ScoreDoc scoreDoc : docs.scoreDocs){
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println(doc.get("title"));
            System.out.println(doc.get("tcontent"));
            String tcontent = doc.get("tcontent");
            if(tcontent != null){
                TokenStream tokenStream =  analyzer.tokenStream("tcontent", new StringReader(tcontent));
                String summary = highlighter.getBestFragment(tokenStream, tcontent);
                System.out.println(summary);
            }
        }
        reader.close();
    }

    public static void main(String[] args){
        String indexDir = "D:\\lucene";
        String q = "内容1"; //查询这个字符串
        try {
            doSearch(indexDir, q);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
