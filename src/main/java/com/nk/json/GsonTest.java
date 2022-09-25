package com.nk.json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class GsonTest {

	public static void main(String[] args) throws JsonSyntaxException, JsonIOException, FileNotFoundException {

//		Gson gson = new Gson();
//		Employee emp = gson.fromJson(new FileReader("sample.json"), Employee.class);
//		System.out.println("emp : "+emp);
		
		Gson gson1 = new GsonBuilder().registerTypeAdapterFactory(new CustomAdapterFactory()).create();
		Employee emp1 = gson1.fromJson(new FileReader("sample.json"), Employee.class);
		System.out.println("emp : " + emp1);

	}

}
