package com.jianzhang.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description: (这里用一句话描述这个类的作用)  
 * @author Jian Jang
 * @version 1.0 2017年11月30日
*/
public class TestCase {
public static void main(String[] args) {
	Calendar calendar = Calendar.getInstance();
	calendar.setTimeInMillis(1512039540000l);
	SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(sdFormat.format(calendar.getTime()));
	
}
}
