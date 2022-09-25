package com.nk.memoryleaks;

public class MemoryLeakWithSubString {
	
	public static void main(String[] args) {
		String str = "JohnDoe";
		String substring = str.substring(4);
		System.out.println("substring : "+substring);
		
		
		String subString1 = str.substring(5, 7);
		System.out.println("substring1 : "+subString1);
		
	}

}
