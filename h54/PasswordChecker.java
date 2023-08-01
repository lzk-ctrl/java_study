/**
 * 
 */
package com.huawei.classroom.student.h54;
import java.util.*; 

/**
 * @author Administrator
 *
 */
public class PasswordChecker {
	/**
	 * 判断一个口令是否是一个复杂度合法的口令，复杂度合法的口令有如下要求：
	 * 1  长度>=8
	 * 2 最少包含一个数字
	 * 3 最少包含一个小写英文字母
	 * 4 虽少包含一个大写英文字母
	 * 5 最少包含一个特殊字符 特殊字符定义为   ~!@#$%^&*()_+
	 * 
	 *   
	 */
	public boolean isValidPassword(String password){
		boolean[] flag=new boolean[5];
		if(password.length()<8)
			return false;
		Set<Character> special=new HashSet<>();
		String sp=new String(" ~!@#$%^&*()_+");
		for(char x:sp.toCharArray()) {
			special.add(x);
		}
		for(int i=0;i<password.length();i++) {
			if(password.charAt(i)>='0'&&password.charAt(i)<='9') 
				flag[1]=true;
			if(password.charAt(i)>='a'&&password.charAt(i)<='z')
				flag[2]=true;
			if(password.charAt(i)>='A'&&password.charAt(i)<='Z')
				flag[3]=true;
			if(special.contains(password.charAt(i)))
				flag[4]=true;
		}
		if(flag[1]==true&&flag[2]==true&&flag[3]==true&&flag[4]==true)
		    return true;
		return false;
	}
}
