package com.huawei.classroom.student.h11;

import java.util.*;

public class Home11 {

	public Home11() {
		// TODO Auto-generated constructor stub
	}

 
	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 * 测试的时候，商品名称可能增加新的商品，例如方便面、面包...
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @return 哪两个商品被同时购买的频率最高，将这2个商品名称返回，名称之间用逗号分隔
	 */
	 public String getFrequentItem(String content){
		 String theKey = null;
		 String[] contents = content.split(";");
		 Map<String, Integer> map = new HashMap<>();

		 for(int i=0;i<contents.length;i++) {
		     String[] single = contents[i].split(",");
		     for(int j=0;j<single.length-1;j++) {
		         for(int k=1;k<single.length;k++) {
		             String key = single[j]+","+single[k];
		             if(map.containsKey(key)) {
		                     int newVal = map.get(key) + 1;
		                     map.put(key, newVal);
		             }else {
		                 map.put(key, 0);
		             }
		         }
		     }
		 }
		 int max = 0;
		 for(String key : map.keySet()) {
		     int nowVal = map.get(key);
		     if(max<nowVal) {
		         max = nowVal;
		         theKey = key;
		     }
		 }
		 return theKey;
    }

 
}
