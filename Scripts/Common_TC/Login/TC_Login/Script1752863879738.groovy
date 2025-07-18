import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser(GlobalVariable.base_url)
WebUI.callTestCase(findTestCase('Test Cases/Common_TC/Utils_TC/utils_maximize_window'), null, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementPresent(findTestObject('Login_Page/FORM_Login'), 10)

WebUI.sendKeys(findTestObject('Login_Page/FIELD_Username'), username)

WebUI.sendKeys(findTestObject('Login_Page/FIELD_Password'), password)

WebUI.click(findTestObject('Login_Page/BUTTON_Login'))

if (expected_result == 'success') {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Header_Page/DROPDOWN_UserDropdown'), 2, FailureHandling.STOP_ON_FAILURE)
	WebUI.comment("✅ Login successful")
} else if (expected_result == 'failed') {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Err_Login/Text_Required'), 2, FailureHandling.STOP_ON_FAILURE)
	WebUI.comment("❌ Login failed")
} else if (expected_result == 'invalid') {
	WebUI.verifyElementPresent(findTestObject('Object Repository/Err_Login/Err_Invalid_Credentials'), 2, FailureHandling.STOP_ON_FAILURE)
} else {
	WebUI.comment("⚠️ Unexpected expected_result value: " + expected_result)
}

