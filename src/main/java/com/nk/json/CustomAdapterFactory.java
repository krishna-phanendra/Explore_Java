package com.nk.json;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;

public class CustomAdapterFactory implements TypeAdapterFactory {

	@Override
	public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
		System.out.println("custom factory........" +type.getRawType().getSimpleName()+"---"+ type.getRawType().isArray());
		System.out.println("Location.class.getComponentType() : "+Location.class.getClass());
		if (type.getRawType().getSimpleName().equals("Location[]")) {
			System.out.println("22222");
			TypeAdapter<Location[]> delegateAdapter = (TypeAdapter<Location[]>) gson.getDelegateAdapter(this, type);
			return (TypeAdapter<T>) new ArrayAdapter(delegateAdapter);
		}
		System.out.println("333333333");
		return null;
	}

}
