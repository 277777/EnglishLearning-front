package com.ELfront.Tools;

import java.io.ByteArrayOutputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List;  
import java.util.Map;  
  
import com.google.gson.Gson;  
import com.google.gson.JsonSyntaxException;  
import com.google.gson.reflect.TypeToken;  
  

public class GsonTools {  
  
    /**TODO 转换为json字符串 
     * @param src  要转换成json格式的 对象 
     * @return 
     */  
    public static String createJsonString(Object src) {  
        Gson gson = new Gson();  
        String jsonString = gson.toJson(src);  
        return jsonString;  
    }  
  
  
    /**TODO 转换为指定的 对象 
     * @param jsonString 
     * @param type 指定对象的类型 ，即 T.class 
     * @return 
     */  
    public static <T> T getObject(String jsonString, Class<T> type) {  
        T t = null;  
        try {  
            Gson gson = new Gson();  
            t = gson.fromJson(jsonString, type);  
        } catch (JsonSyntaxException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return t;  
    }  
  
    /**得到 一个List<T>集合 
     * @param jsonString 
     * @param type  T的类型 
     * @return 
     */  
    public static <T> List<T> getList(String jsonString, Class<T> type) {  
        List<T> list = new ArrayList<T>();  
        Gson gson = new Gson();  
        list = gson.fromJson(jsonString, new TypeToken<List<T>>() {  
        }.getType());  
        return list;  
  
    }  
  
    /**TODO 得到一个List<T> 的集合 
     * @param jsonString json字符串 
     * @param type  数组的类型 ，即T[].class 
     * @return 
     */  
    public static <T> List<T> StringTolist(String jsonString, Class<T[]> type) {  
        T[] list = null;  
        try {  
            Gson gson = new Gson();  
            list = gson.fromJson(jsonString, type);  
        } catch (JsonSyntaxException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
  
        return Arrays.asList(list);  
  
    }  
    /**把json字符串转换为 String 集合 
     * @param jsonString 
     * @return 
     */  
    public static List<String> getStrings(String jsonString) {  
        List<String> list = new ArrayList<String>();  
        Gson gson = new Gson();  
        new TypeToken<List<String>>(){}.getType();  
        list = gson.fromJson(jsonString, new TypeToken<List<String>>() {  
        }.getType());  
        return list;  
  
    }  
  
    /**TODO 将json数据解析为Map<String,Object>集合 
     * @param jsonString  
     * @return 
     */  
    public static List<Map<String, Object>> getMaps(String jsonString) {  
  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        Gson gson = new Gson();  
        list = gson.fromJson(jsonString,  
                new TypeToken<List<Map<String, Object>>>() {  
                }.getType());  
  
        return list;  
  
    } 
    
    /** 
     * 将输入流转换为byte[] 
     *  
     * @param is 
     * @return 
     */  
    public static byte[] IsToByte(InputStream is) {  
  
        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
        byte buffer[] = new byte[1024];  
        int len = 0;  
        try {  
            while ((len = is.read(buffer)) != -1) {  
                bos.write(buffer, 0, len);  
  
            }  
  
        } catch (IOException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
            return null;  
        } finally {  
            try {  
                bos.flush();  
                bos.close();  
                is.close();  
            } catch (IOException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
  
        }  
  
        return bos.toByteArray();  
    }  
    
    public static <T> T getObjectData(String jsonString, Class<T> type) {  
    	  
        T t = null;  
        try {  
            Gson gson = new Gson();  
            t = gson.fromJson(jsonString, type);  
        } catch (JsonSyntaxException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
        return t;
    }
    
}
  
      