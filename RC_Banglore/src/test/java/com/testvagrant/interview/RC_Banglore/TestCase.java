package com.testvagrant.interview.RC_Banglore;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class TestCase {
	JSONObject response = ParseJSON.processPayload();
	ExtentReports erep = ReportGeneration.extentReportGenerator();
	ExtentTest etest = null;

	@Test
	public void The_team_has_only_4_players() {
		etest = erep.createTest("To test RCB team has exactly 4 foreign players");
		etest.info(response.toString());
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
			etest.info("foreign players count is " + count);
			try {
				Assert.assertTrue(count == 4);
				etest.info("Testcase is passed as RCB has " + count + " foreign players");
			} catch (AssertionError e) {
				e.getMessage();
				etest.fail("Testcase failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		erep.flush();
	}

	@Test
	public void Team_has_atleast_one_wc() {
		etest = erep.createTest("To test RCB team has atleast 1 Wicket-Keeper");
		etest.info(response.toString());
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
			etest.info("Wicket-Keeper count is " + count);
			try {
				Assert.assertTrue(count >= 1);
				etest.info("Testcase is passed as RCB has " + count + " Wicket-Keeper");
			} catch (Exception e) {
				e.getMessage();
				etest.fail("Testcase failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		erep.flush();
	}
}
