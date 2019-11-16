package com.webAppSecurities.zeroBank.transferfund;

import java.util.Hashtable;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.testBase;

import utilities.DataProviders;
import utilities.DataUtil;
import utilities.Constants;
import utilities.testUtil;

public class TransferFundNumericValueChk extends testBase {

	@Test(dataProvider = "transferFundDP", dataProviderClass = DataProviders.class)
	public static void transferfundnumericvaluechk(Hashtable<String, String> data) throws AssertionError {

		DataUtil.checkExecutionSuite(Constants.TRANSFER_FUND_SUITENAME, "TransferFundNumericValueChk",
				data.get("RunMode"));

		try {

			testUtil.logIn(data.get("Username"), data.get("Password"));

			click("transferFundTab_XPATH");

			select("fromAccountDropDown_ID", data.get("FromAccount"));
			select("toAccountDropDown_XPATH", data.get("ToAccount"));

			type("amount_XPATH", data.get("Amount"));
			click("continueBtn_XPATH");

			if (wait.until(ExpectedConditions.alertIsPresent()) != null)
				Assert.assertTrue(true);

		} catch (AssertionError e) {

			log.info(e);
			Assert.fail(String.valueOf(e), e);
		}
	}
}
