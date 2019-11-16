package com.webAppSecurities.zeroBank.payBills;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.testUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddNewPayeeVerifyPage extends testBase {

	@Test(dataProvider = "payBillsDP", dataProviderClass = DataProviders.class)
	public static void addnewpayeeverifypage(Hashtable<String, String> data) throws AssertionError, Exception {

		DataUtil.checkExecutionSuite(Constants.PAY_BILLS_SUITENAME, "AddNewPayeeVerifyPage", data.get("RunMode"));

		try {

			testUtil.logIn(data.get("Username"), data.get("Password"));

			click("payBillsTab_XPATH");
			click("addPayeeTab_XPATH");

			assertThat(getTextFromMessage("payeeName_XPATH"), is(data.get("Message")));

		} catch (AssertionError e) {

			log.info(e);
			Assert.fail(String.valueOf(e), e);
		}

	}
}
