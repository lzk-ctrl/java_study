package com.huawei.classroom.student.h08;
public class LoginUtil{
	public String id;
	public String pw;
	public boolean login(String a,String b)throws InvalidUserException{
		if(a.equals("a")&&b.equals("a"))
			return true;
		else {
			throw new InvalidUserException();
		}
	}
}