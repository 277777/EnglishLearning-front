package com.ELfront.Tools;


import java.io.StringReader;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import com.ELfront.Constant.ConClass;
import com.ELfront.po.Word.EnglishWord;


public class JinshanParseUtil {

    /**
     * 判断一段字符串是否是纯英文
     * */
    public static boolean isEnglish(String content){

        if(content == null){                    //获取内容为空则返回false
            return false;
        }
        content = content.replace(" ","");      //去掉内容中的空格

        return content.matches("^[a-zA-Z]*");   //判断是否是全英文，是则返回true，反之返回false

    }
    /**
     * 英译汉时使用。查词
     * 使用pull方式解析金山词霸返回的XML数据。
     * */
    public static void parseJinshanEnglishToChineseXMLWithPull(String result) {

        try {

            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlPullParser = factory.newPullParser();
            xmlPullParser.setInput(new StringReader(result));
            int eventType = xmlPullParser.getEventType();

            String queryText = "";      //查询文本
            String voiceText = "";      //发音信息
            String voiceUrlText = "";   //发音地址信息
            String meanText = "";       //基本释义信息
            String exampleText = "";    //例句信息
            String cnexampleText = "";    //例句信息

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //开始解析
                    case XmlPullParser.START_TAG: {
                        switch (nodeName) {
                            case "key":
                                queryText += xmlPullParser.nextText();
                                break;
                            case "ps":
                                voiceText += xmlPullParser.nextText() + "|";
                                break;
                            case "pron":
                                voiceUrlText += xmlPullParser.nextText() + "|";
                                break;
                            case "pos":
                                meanText += xmlPullParser.nextText() + "  ";
                                break;
                            case "acceptation":
                                meanText += xmlPullParser.nextText();
                                break;
                            case "orig":
                                exampleText += xmlPullParser.nextText() ;
                                exampleText = exampleText.substring(0,exampleText.length()-1) + "|";
                                break;
                            case "trans":
                                cnexampleText += xmlPullParser.nextText() + "|";
                                break;
                            default:
                                break;
                        }
                    }
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }

            String[] voiceArray = voiceText.split("\\|");
            String[] voiceUrlArray = voiceUrlText.split("\\|");
            String[] en = exampleText.split("\\|");
            String[] cn = cnexampleText.split("\\|");

            meanText = meanText.substring(0,meanText.length()-1);
            exampleText = exampleText.substring(1,exampleText.length());

//            editor.clear();
//
            System.out.println("queryText:   "+queryText);
            System.out.println("voiceEnText:   "+"["+voiceArray[0]+"]");
            System.out.println("voiceEnUrlText:   "+voiceUrlArray[0]);
            System.out.println("voiceAmText:   "+"["+voiceArray[1]+"]");
            System.out.println("voiceAmUrlText:   "+voiceUrlArray[1]);
            System.out.println("meanText:   "+meanText);
//            System.out.println("meanText:   "+meanText);
//            System.out.println("exampleText:   "+exampleText);
            for(int i=0;i<en.length;i++) {
            	System.out.println(en[i]);
            	System.out.println(cn[i]);
            }
            EnglishWord englishWord = new EnglishWord();
            englishWord.setQueryText(queryText);
            englishWord.setVoiceEnText(voiceArray[0]);
            englishWord.setVoiceEnUrlText(voiceUrlArray[0]);
            englishWord.setVoiceAmText(voiceArray[1]);
            englishWord.setVoiceAmUrlText(voiceUrlArray[1]);
            englishWord.setMeanText(meanText);
            englishWord.setExampleText(en);
            englishWord.setCnexampleText(cn);
            ConClass.setEnglishWord(englishWord);
            
//
//            editor.apply();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}