package com.huawei.classroom.student.h12;

import java.util.*;

public class Home12 {
	public Home12() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 字符串content是一个超市的历次购物小票的合计，每次购物的明细之间用分号分割，每个商品之间用半角逗号分开
	 * 请找出   哪n(n>=1)个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 * 
	 * @param content，历次购物的明细，例如：炸鸡,可乐,啤酒;薯片,啤酒,炸鸡;啤酒,雪碧,炸鸡
	 * @param n
	 * @return 哪n个商品被同时购买的频率最高，将这n个商品名称的集合（set)返回 
	 *  不会出现并列的情况
	 */
	public Set<Set<String>> getNItems(List<String> remainItems,List<String> collectItems,int count){
		int i;
		  Set<Set<String>> result = new HashSet<>();
		  if (count == 1) {
		    for (String remainItem : remainItems) {
		      Set<String> collectItemsSet = new HashSet<>(collectItems);
		      collectItemsSet.add(remainItem);
		      result.add(collectItemsSet);
		    }
		    return result;
		  }
		  count--;
		  for (i = 0; i < remainItems.size(); i++) {
		    List<String> tempRemainItems = new ArrayList<>(remainItems);
		    List<String> tempCollectItems = new ArrayList<>(collectItems);
		    tempCollectItems.add(tempRemainItems.remove(i));
		    result.addAll(getNItems(tempRemainItems, tempCollectItems, count));
		  }
		  return result;
	}
	public Set<String> getFrequentItem(String content,int n)  {
		  int i, count, max;
		  String[] shopping;
		  List<String> items;
		  Set<String> nItemsAns;
		  Map<Set<String>, Integer> nItemsMap;
		  Set<Set<String>> nItemsSet;

		  shopping = content.split(";");
		  nItemsMap = new HashMap<>();
		  for (i = 0; i < shopping.length; i++) {
		    items = Arrays.asList(shopping[i].split(","));
		    Set<Set<String>> nItems = new HashSet<>(getNItems(items, new ArrayList<>(), n));
		    for (Set<String> nItem : nItems) {
		      count = nItemsMap.getOrDefault(nItem, 0);
		      nItemsMap.put(nItem, count + 1);
		    }
		  }

		  max = 0;
		  nItemsAns = new HashSet<>(n);
		  nItemsSet = nItemsMap.keySet();
		  for (Set<String> nItem: nItemsSet) {
		    if (max < nItemsMap.get(nItem)) {
		      max = nItemsMap.get(nItem);
		      nItemsAns = nItem;
		    }
		  }

		  return nItemsAns;
	}

	 
}
