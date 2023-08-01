package com.huawei.classroom.student.h10;
/**
 * 把你作业的代码写到这个类里面
 * 不可以修改类的名字、包名、和固有的几个方法名以及方法的可见性
 * 可以增加其他方法、属性、类
 * 可以引用jdk的类
 * 不要引用jdk1.8以外第三方的包
 * 
 * @author cjy
 *
 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home10 {
	public Home10() {
	} 
	/**
	 * 将一个字符串中字符按出现频率的高到低排序返回，如果两个字符出现的频率一样，则将最先出现的字符排在前面
	 * 例如：orderChar(“abcdefg”)返回 “abcdefg” 
	 * orderChar(“abcdefgg”)返回 “gabcdef”
	 * orderChar(“abcdefgge”)返回 “egabcdf”
	 * orderChar(“天津大学软件学院”)返回 “学天津大软件院”
	 * @param content
	 * @return
	 */
	public String orderChar(String content) {
		if (content == null || content.length() == 0) {
            return "";
        }
        // 使用 HashMap 统计每个字符出现的次数
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }
        // 将统计结果存放到一个 List 中，并根据字符出现的次数降序排列。
        List<Map.Entry<Character, Integer>> charCountList = new ArrayList<>(charCountMap.entrySet());
        charCountList.sort(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o2.getValue().equals(o1.getValue())) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        // 将 List 中的字符按顺序拼接成一个字符串并返回。
        StringBuilder resultBuilder = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : charCountList) {
            if (entry.getValue() > 0) {
                resultBuilder.append(entry.getKey());
                entry.setValue(entry.getValue() - 1);
            }
        }
        return resultBuilder.toString();
    }
		
}
