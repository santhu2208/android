package com.yyb.socket.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class DownUtil {
	private static URL url =null;
	/*
	 * 从http地址  获取输入流
	 */
	public static InputStream getIuputStream(String urlStr){
		try {
			url = new URL(urlStr);
			return url.openConnection().getInputStream();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	} 
	/*
	 * down text file
	 */
	public static String downFile(String urlStr){
		StringBuffer sBuffer = new StringBuffer();
		InputStream is = getIuputStream(urlStr);
		BufferedReader br =null;
		String line =null;
		try {
			  br= new BufferedReader(new InputStreamReader(is, "utf-8"));
			
			while((line=br.readLine())!=null){
				sBuffer.append(line);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sBuffer.toString();
	}
	/**
	 * download other file
	 * -1 失败  0 成功  1 文件已存在
	 */
	public static int downFile(String urlStr,String path,String name){
		InputStream is=null;
		try{
			if(FileUtil.isFileExist(path+File.separator+name)){
				return 1;
			}
			is = getIuputStream(urlStr);
			File file = FileUtil.down2SD(path,name,is);
			if(file ==null){
				return -1;
			}
		}catch (Exception e) {
			e.printStackTrace();
			return -1;
		}finally{
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return 0;
	}
}
