package com.huawei.classroom.student.h15;

public class ThreadUtil extends Thread {
	public StringBuffer str;
	public ThreadUtil(StringBuffer buf) {
		str=buf;
	}
	public void run() {
		try {
			this.sleep(200);
		}catch(Exception e) {
			e.printStackTrace();
		}
		str.append("ok");
	
	}
}
