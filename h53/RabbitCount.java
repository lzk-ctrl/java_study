/**
 * 
 */
package com.huawei.classroom.student.h53;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


/**
 * @author Administrator
 *
 */
public class RabbitCount {

	/**
	 * 1对兔子出生以后经过180天可以生出一窝（2对）兔子，以后每隔90天繁殖一次生出一窝（2对）兔子
	 * 每对兔子的寿命是700天 
	 * @param startCount 第0天 开始的时候初生的兔子对数
	 * @param months 经过的天份数
	 * @return 目前系统中存活的兔子的对数
	 * 
	 */
	
	public int getLivingRabbit(int startCount,int days) {
		int[] born =new int[201];
		int[] dead =new int[201];
		for(int i=0;i<=days/10;i++) {
			if(i==0)
				born[i]=1;
			for(int j=2;j<=7&&j*9+i<=days/10;j++) {
				born[j*9+i]+=born[i]*2;
			}
			if(i+71<=days/10)
			dead[i+71]=born[i];
		}
		int sum=0;
		for(int i=0;i<days/10;i++) {
			sum+=born[i];
			sum-=dead[i];
		}
		sum*=startCount;
		return sum;
	}
}
