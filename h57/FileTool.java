package com.huawei.classroom.student.h57;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTool {

	/*
	 * 统计一个目录下所有文件大小的加和
	 */
	public long recursiveCalcFileSize(String homeDir) {
		return readdirectory(new File(homeDir));
	}
	public long readdirectory(File file) {
		File[] files=file.listFiles();
		int sum=0;
		for(int i=0;i<files.length;i++) {
			if(files[i].isDirectory())
				sum+=readdirectory(files[i]);
			else {
				
				long x=calculate(files[i].getAbsolutePath());
				sum+=x;
			}
		}
		return sum;
	}
	public long calculate(String fsrc) {
		InputStream in = null;
		long sum=0;
		try {
			in = new FileInputStream(fsrc);
			byte[] buf = new byte[4096];
			int len = in.read(buf);
			while (len != -1) {
				sum+=len;
				len = in.read(buf);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			close(in);
		}
		return sum;
		
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
