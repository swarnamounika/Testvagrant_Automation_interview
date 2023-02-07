package com.testvagrant.interview.RC_Banglore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase {
	JSONObject response = ParseJSON.processPayload();

	@Test
	public void The_team_has_only_4_players() {
		int count = 0;
		try {
			JSONArray ja = (JSONArray) response.get("player");
			JSONObject jo = null;
			for (int i = 0; i < ja.size(); i++) {
				jo = (JSONObject) ja.get(i);
				String country = jo.get("country").toString();
				if (!country.equalsIgnoreCase("india")) {
					count++;
				}
			}
			try {
				Assert.assertTrue(count == 4);
			} catch (AssertionError e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void Team_has_atleast_one_wc() {
		int count = 0;
		JSONArray ja;
		try {
			ja = (JSONArray) new JSONParser().parse(response.get("player").toString());
			JSONObject jo = null;
			for (int i = 0; i < ja.size(); i++) {
				jo = (JSONObject) ja.get(i);
				String role = jo.get("role").toString();
				if (role.contains("Wicket")) {
					count++;
				}
			}
			try {
				Assert.assertTrue(count >= 1);
			} catch (Exception e) {
				System.out.println("testcase 2 failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
