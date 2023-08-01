package com.huawei.classroom.student.h15;
import java.util.*;

public class PrimeUtil {
	public PrimeUtil() {
	}
	public List<Long> getPrimeList(long start,long end,int threadCount) {
		List<Long> ans =new ArrayList<>();
		PrimeThread[] threads = new PrimeThread[threadCount];
		for (int i = 0; i < threads.length; i++) {
			long threadStart = start + (end - start) / threadCount * i;
			long threadEnd = start + (end - start) / threadCount * (i + 1);
			threads[i] = new PrimeThread(threadStart, threadEnd);
			threads[i].start();
		}
		for (int i = 0; i < threads.length; i++) {
			try {
				threads[i].join();
				ans.addAll(threads[i].getans());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return ans;
	}
}
