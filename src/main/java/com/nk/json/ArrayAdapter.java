package com.nk.json;

import java.io.IOException;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class ArrayAdapter extends TypeAdapter<Location[]> {
	
	protected TypeAdapter<Location[]> defaultAdapter;
	
	public ArrayAdapter(TypeAdapter<Location[]> defaultAdapter) {
		this.defaultAdapter = defaultAdapter;
	}

	public Location[] read(JsonReader reader) throws IOException {
		System.out.println("- custom adapter---"+reader.toString());
		Location[] locs = {new Location()};
		JsonToken token1 = reader.peek();
		System.out.println("-----start-----"+token1);
		if (token1 == JsonToken.BEGIN_ARRAY) {
//			reader.skipValue();
			System.out.println("default adapter : "+defaultAdapter);
			reader.skipValue();
			return defaultAdapter.read(reader);
//			locs[0] = defaultAdapter.read(reader)[0];
//			System.out.println("locs : "+locs[0].toString());
//			return locs;
		}
		System.out.println("---------out--------");

		return defaultAdapter.read(reader);
	}

	@Override
	public void write(JsonWriter out, Location[] value) throws IOException {
		// TODO Auto-generated method stub

	}

}
