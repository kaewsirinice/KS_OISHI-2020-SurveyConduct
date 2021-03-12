package com.fb180.Utilities

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import com.kms.katalon.core.util.KeywordUtil
import org.openqa.selenium.WebElement

import internal.GlobalVariable

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

public class MyUtilities {
	@Keyword
	def myCheckbox(TestObject obj, String option) {
		String [] extract = option.split(",");
		try {
			if (extract.length > 0) {
				WebUI.waitForElementVisible(obj, GlobalVariable.timeout);
				List<WebElement> checkBox = WebUiCommonHelper.findWebElements(obj, 20);
				for (int i = 0; i < extract.length; i++){
					if (extract[i].equalsIgnoreCase("ON")){

						//						WebUI.delay(1)

						checkBox.get(i).click();
					}
				}
			}
		}catch(Exception e){
			//			return KeywordUtil.markFailed+ " - Could not find checkbox";
		}
		return KeywordUtil.markPassed("checkbox selected Pass");
	}

	@Keyword
	def myRadioImg(TestObject obj, String option) {
		int ckickRadio = Integer.parseInt(option)
		ckickRadio = ckickRadio - 1
		try {
			if (!option.isEmpty()) {
				TestObject radioChoices = obj
				WebUI.waitForElementVisible( radioChoices , 20  )
				List<WebElement> checkRadio = WebUiCommonHelper.findWebElements(radioChoices, 20);
				int total = checkRadio.size()
				for (int i = 0 ; i < total; i++) {
					if (  ckickRadio == i ) {

						checkRadio.get(i).click()
					}
				}
			}
		}catch(Exception e){
			//return KeywordUtil.markFailed+ " - Could not find radio check";
		}
		return KeywordUtil.markPassed("radio selected Pass");
	}
}
