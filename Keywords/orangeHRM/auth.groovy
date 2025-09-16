package orangeHRM

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows


//import orangeHRM.ActionUtils
import org.openqa.selenium.Keys as Keys
import internal.GlobalVariable

public class Auth {
	@Keyword
	def login(String username,String password ) {
		WebUI.verifyElementPresent(findTestObject('Login_Page/FORM_Login'), 10)
		// Using built-in Katalon method
		/*
		WebUI.click(findTestObject('Login_Page/FIELD_Username'))
		// TO-DO: if else mac/other
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Username'), Keys.chord(Keys.COMMAND, 'a'))
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Username'), Keys.chord(Keys.DELETE))
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Username'), username)

		WebUI.click(findTestObject('Login_Page/FIELD_Password'))
		// TO-DO: if else mac/other
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Password'), Keys.chord(Keys.COMMAND, 'a'))
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Password'), Keys.chord(Keys.DELETE))
		WebUI.sendKeys(findTestObject('Login_Page/FIELD_Password'), password)
		*/
		
		// Accessing Selenium Webdriver
		ActionUtils actionUtils = new ActionUtils()
		actionUtils.clearAndSendKeys(findTestObject('Login_Page/FIELD_Username'), username)
		actionUtils.clearAndSendKeys(findTestObject('Login_Page/FIELD_Password'), password)
		WebUI.click(findTestObject('Login_Page/BUTTON_Login'))
	}

	@Keyword
	def loginDefault() {
		login(GlobalVariable.Username, GlobalVariable.Password)
	}
}
