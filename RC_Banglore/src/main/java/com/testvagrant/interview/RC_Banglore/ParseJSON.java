package com.testvagrant.interview.RC_Banglore;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ParseJSON {
	public static JSONObject processPayload() {
		JSONObject jobj = null;
		try {
			String response = System.getProperty("user.dir") + "\\Payload\\RCBPlayers.json";
			JSONParser jp = new JSONParser();
			Object obj = jp.parse(new FileReader(response));
			jobj = (JSONObject) obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobj;
	}
}
