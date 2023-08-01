package com.huawei.classroom.student.h55;
import java.io.*;
import java.util.*;
public class PoetryAnalysis {

	/**
	 * 
	 * @param pathFilename 包含诗歌内容的源文件
	 * @param chars 需要统计的字 以半角分号分割 
	 * 统计  
	 * 
	 */
	private String readFromTxt(String filename) throws Exception {
		Reader reader = null;
		try {
			StringBuffer buf = new StringBuffer();
			char[] chars = new char[1024];
			// InputStream in=new FileInputStream(filename);

			reader = new InputStreamReader(new FileInputStream(filename), "UTF-8");
			int readed = reader.read(chars);
			while (readed != -1) {
				buf.append(chars, 0, readed);
				readed = reader.read(chars);
			}
			return buf.toString();
		} finally {
			close(reader);
		}
	}
	private void close(Closeable inout) {
		if (inout != null) {
			try {
				inout.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void analysis(String pathFilename,String chars) {
		String[] sentence;
		String txt;
		try {
			txt=readFromTxt(pathFilename);
		}catch(Exception e) {
			e.printStackTrace();
			return;
		}
		Set<Character> find=new HashSet<>();
		char[]charss=chars.toCharArray();
		for(char x:charss) 
			find.add(x);
		sentence=txt.split("，|。");
		Map<String,Integer> ans=new HashMap<>();
		for(String x:sentence) {
			for(int i=0;i<x.length();i++) {
				if(!find.contains(x.charAt(i)))
					continue;
				if(i!=0)
					ans.put(x.charAt(i-1)+""+x.charAt(i), ans.getOrDefault(x.charAt(i-1)+""+x.charAt(i), 0)+1);
				if(i+1!=x.length())
					ans.put(x.charAt(i)+""+x.charAt(i+1), ans.getOrDefault(x.charAt(i)+""+x.charAt(i+1), 0)+1);
			}
		}
		for(Map.Entry<String,Integer> entry:ans.entrySet()) {
			if(find.contains(entry.getKey().charAt(0))&&find.contains(entry.getKey().charAt(1)))
				ans.put(entry.getKey(), entry.getValue()/2);
		}
		List<Map.Entry<String, Integer>> mapList = new ArrayList<>(ans.entrySet());
		mapList.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
		for(Map.Entry<String,Integer> entry:mapList) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}
}
