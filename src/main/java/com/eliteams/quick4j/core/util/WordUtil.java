package com.eliteams.quick4j.core.util;

import org.wltea.analyzer.IKSegmentation;
import org.wltea.analyzer.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分词工具、以及词出现次数统计.
 * User: Administrator
 * Date: 15-3-6
 * Time: 上午11:03
 * To change this template use File | Settings | File Templates.
 */
public class WordUtil {
    /**
     * 分词器
     * @param text
     * @return
     */
    public static List<String> segString(String text){
        String t = text;
        List<String> wordList = new ArrayList();
        IKSegmentation ikSeg = new IKSegmentation(new StringReader(t) ,false);
        try {
            Lexeme l = null;
            while( (l = ikSeg.next()) != null){
                wordList.add(l.getLexemeText());
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return wordList;
    }

    /**
     * 计算一个list中，word的重复次数
     * @param stringList
     * @return
     */
   public static Map<String, Integer> wordCount(List<String> stringList){
       Map<String, Integer> map = new HashMap();
       for (String temp : stringList) {
           Integer count = map.get(temp);
           map.put(temp, (count == null) ? 1 : count + 10);
       }
       return map;
   }

   public static void main(String[] orgs){
       String text = "途径回来了吧啊哦哦哦哦哦";
       List<String> stringList = segString(text);
       Map<String, Integer> map = wordCount(stringList);

       for (Map.Entry entry : map.entrySet()) {
           System.out.println("Key-value : " + entry.getKey() + "- "
                   + entry.getValue());
       }
   }
}
