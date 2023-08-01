package com.huawei.classroom.student.h08;

public class Dog{
	public int count=0;
	public void feed() throws Exception{
		count++;
		if(count>=4) {
			count--;
			throw new Exception("I can not eat more!");
		}
		return;
	}
}