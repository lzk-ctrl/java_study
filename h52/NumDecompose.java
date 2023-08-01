package com.huawei.classroom.student.h52;

import java.util.*;

public class NumDecompose {
	/**
	 * 将num进行质因数分解，将分解到的质因数放到Set里面返回
	 */
	public Set<Integer> decompose(int num) {
		Set<Integer> ans=new HashSet();
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				ans.add(i);
				if(i!=Math.sqrt(num))
			    ans.add(num/i);
			}
		}
		return ans;
		
	}
}
