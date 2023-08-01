package com.huawei.classroom.student.h08;
public class Bank{
	public int count;
	public Bank() {
		count=0;
	}
	public void save(int n) {
		count+=n;
		return;
	}
	public void get(int n)throws NoMoneyException{
		if(count>=n) {
			count-=n;
		}
		else
			throw new NoMoneyException();
		return;
	}
}