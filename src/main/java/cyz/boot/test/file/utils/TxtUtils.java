package cyz.boot.test.file.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import cyz.boot.test.common.utils.LoggerUtil;

public class TxtUtils {
	public static String readToString(String fileName) {  
        String encoding = "UTF-8";  
        File file = new File(fileName);  
        Long filelength = file.length();  
        byte[] filecontent = new byte[filelength.intValue()];  
        try {  
            FileInputStream in = new FileInputStream(file);  
            in.read(filecontent);  
            in.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
        try {  
            return new String(filecontent, encoding);  
        } catch (UnsupportedEncodingException e) {  
        	LoggerUtil.error("The OS does not support " + encoding);
            e.printStackTrace();  
            return null;  
        }  
    }
	
	public static void saveAsFileWriter(String savePath,String content) {  
		 FileWriter fwriter = null;  
		 try {  
		  fwriter = new FileWriter(savePath);  
		  fwriter.write(content);  
		 } catch (IOException ex) {  
		  ex.printStackTrace();  
		 } finally {  
		  try {  
		   fwriter.flush();  
		   fwriter.close();  
		  } catch (IOException ex) {  
		   ex.printStackTrace();  
		  }  
		 }  
	} 
	
//	public static void main(String[] args) {
//		TxtUtils.saveAsFileWriter("D:\\333.txt", "aaaaaaa你好");
//		LoggerUtil.info("read file content:{}", TxtUtils.readToString("D:\\333.txt"));
//	}
	
}
