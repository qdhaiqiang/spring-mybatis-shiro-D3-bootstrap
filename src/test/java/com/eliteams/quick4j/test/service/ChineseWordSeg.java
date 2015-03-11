package com.eliteams.quick4j.test.service;

import org.junit.Test;
import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;
import org.wltea.analyzer.lucene.IKAnalyzer;
import org.wltea.analyzer.lucene.IKTokenizer;

import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 15-3-6
 * Time: 上午9:28
 * To change this template use File | Settings | File Templates.
 */
public class ChineseWordSeg {
    @Test
    public void test_Ansj_seg(){
        String t = "好好规划后";
        IKSegmentation ikSeg = new IKSegmentation(new StringReader(t) ,false);
        try {
            Lexeme l = null;
            while( (l = ikSeg.next()) != null){
                System.out.println(l.getLexemeText());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
