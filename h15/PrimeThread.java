package com.huawei.classroom.student.h15;
import java.util.*;
public class PrimeThread extends Thread {
	private List<Long> ans;
	private long start;
	private long end;
	public PrimeThread(long start,long end) {
		ans=new ArrayList<>();
		this.end=end;
		this.start=start;
	}
	public List<Long> getans(){
		return ans;
	}
	public void run() {
		for(long i=start;i<end;i++) {
			if(i==0l||i==1l)
				continue;
			if(isPrime(i))
				ans.add(i);
		}
	}
	public boolean isPrime(long a) {
		for(long i=2l;i<=Math.sqrt(a);i++) {
			if(a%i==0)
				return false;
		}
		return true;	
	}
	
}
