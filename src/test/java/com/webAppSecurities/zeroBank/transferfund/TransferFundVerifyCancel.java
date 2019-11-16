package com.webAppSecurities.zeroBank.transferfund;

import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.testUtil;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TransferFundVerifyCancel extends testBase {

	@Test(dataProvider = "transferFundDP", dataProviderClass = DataProviders.class)
	public static void transferfundverifycancel(Hashtable<String, String> data) {

		DataUtil.checkExecutionSuite(Constants.TRANSFER_FUND_SUITENAME, "TransferFundVerifyCancel",
				data.get("RunMode"));

		try {

			testUtil.logIn(data.get("Username"), data.get("Password"));

			click("transferFundTab_XPATH");

			select("fromAccountDropDown_ID", data.get("FromAccount"));
			select("toAccountDropDown_XPATH", data.get("ToAccount"));

			type("amount_XPATH", data.get("Amount"));
			click("continueBtn_XPATH");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("cancelBtn_XPATH"))));

			click("cancelBtn_XPATH");

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty("continueBtn_XPATH"))));

			assertThat(getTextFromMessage("tfVerifyPageMessage_XPATH"), is(data.get("Message")));

		} catch (AssertionError e) {

			log.info(e);
			Assert.fail(String.valueOf(e), e);
		}

	}
}
