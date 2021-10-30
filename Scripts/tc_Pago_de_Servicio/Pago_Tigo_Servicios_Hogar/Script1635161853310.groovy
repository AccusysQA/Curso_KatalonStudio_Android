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

WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.delay(2)

Mobile.tap(findTestObject('Pago_Servicio/BTN_Pago2'), 0)

Mobile.delay(4, FailureHandling.STOP_ON_FAILURE)

Mobile.tapAtPosition(175, 312)


Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

for (def numRow = 1; numRow <= findTestData('Pago de servicio Tigo Servicios Hogar').getRowNumbers(); numRow++) {

Mobile.tapAtPosition(671, 331)

Mobile.tap(findTestObject('Pago_Servicio/CBB_TIGO SERVICIOS HOGAR'), 0)

Mobile.tapAtPosition(659, 483)

Mobile.tap(findTestObject('Pago_Servicio/CBB_Todos'), 0)

Mobile.tapAtPosition(649, 662)

Mobile.tap(findTestObject('Pago_Servicio/CBB_Post_Pago'), 0)

Mobile.tapAtPosition(161, 755)

Mobile.setText(findTestObject('Pago_Servicio/EDT_Codigo'), findTestData('Pago de servicio Tigo Servicios Hogar').getValue(
            1, numRow), 0)

Mobile.hideKeyboard()

Mobile.tap(findTestObject('Pago_Servicio/BTN_Buscar'), 0)

Mobile.delay(5)

Mobile.tapAtPosition(674, 553)

Mobile.tap(findTestObject('Pago_Servicio/BTN_Continuar'), 0)

}