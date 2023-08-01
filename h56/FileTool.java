/**
 * 
 */
package com.huawei.classroom.student.h56;

import java.io.*;
import java.util.*;

/**
 * @author Administrator
 *
 */
public class FileTool {
	public static int CHUNK_SIZE = 4096;
	/**
	 * 将homeDir 目录下（包括子目录）所有的文本文件（扩展名为.txt，扩展名不是.txt的文件不要动，扩展名区分大小写) 文件中，orgStr替换为 targetStr
	 * 所有文本文件均为UTF-8编码
	 * 例如将某个目录中所有文本文件中的 南开大学 替换为 天津大学
	 * @param homeDir
	 * @param orgStr
	 * @param targetStr
	 */
	public FileTool() {
	}
	public void readdirectory(File file,String orgStr,String targetStr) {
		File[] files=file.listFiles();
		for(int i=0;i<files.length;i++) {
			if(files[i].isDirectory())
				readdirectory(files[i],orgStr,targetStr);
			else if(files[i].getName().endsWith(".txt")) {
				try {
					String s=readFile2(files[i].getAbsolutePath());
					s=s.replaceAll(orgStr,targetStr);
					writeFile(files[i].getAbsolutePath(),s);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return;
	}
	public void replaceTxtFileContent(String homeDir,String orgStr,String targetStr) {
		readdirectory(new File(homeDir),orgStr,targetStr);
		
	}
	public String readFile2(String fsrc) throws IOException {
		try (Reader reader = new FileReader(fsrc);) {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[CHUNK_SIZE];
			int readed = reader.read(chars);
			// 从一个流里面读取内容的经典写法
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		}
	}
	public void writeFile(String fileName, String content) throws IOException {
		try (OutputStream out = new FileOutputStream(fileName, false)) {
			out.write(content.getBytes());
			out.flush();
		}

	}
	public void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
