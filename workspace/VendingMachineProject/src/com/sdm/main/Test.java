package com.sdm.main;

import java.math.BigDecimal;

public class Test {

	public static void main(String[] args) {
		String str = "rahul";
		String str1 = "rahullll";
		BigDecimal bd = new BigDecimal("99999");
//		 String value = String.format("%1$-10s %2$10s", left, right);
		String print = String.format("%1$-10s %2$-10s %3$.2f", str, str1, bd);
		System.out.println(print);

	}

}
