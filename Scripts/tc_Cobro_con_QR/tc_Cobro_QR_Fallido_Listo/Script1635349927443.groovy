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

for (def index : (0..2)) {
	switch(index.toString()) {
		case '0':
		WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Cobros_QR/BTN_Pagos_QR'), 0)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		for (def numRow = 1; numRow <= 1; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR/Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
		   
		
			Mobile.pressBack()
		}
		
		break
		case '1':
		
		
		for (def numRow = 2; numRow <= 2; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR/Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
			if (Mobile.waitForElementPresent(findTestObject('Object Repository/Cobros_QR/MSG_Formato_Invalido'), 1)) {
			
				Mobile.tap(findTestObject('Object Repository/Cobros_QR/MSG_Formato_Invalido'), 0)
		
				Mobile.pressBack()
			}
		}
		
		break
		case '2':
		
				
		for (def numRow = 3; numRow <= 3; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR/Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tapAtPosition(674, 582)
		
			Mobile.tap(findTestObject('Object Repository/Cobros_QR/CBB_884187-000-001'), 0)
		
			Mobile.tapAtPosition(113, 702)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Nota'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Nota'), findTestData('Cobro_QR/Cobro_QR_Mensajes').getValue(4, numRow), 0)
			
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
			Mobile.hideKeyboard()
		
			if (Mobile.waitForElementPresent(findTestObject('Object Repository/Cobros_QR/MSG_Sin_Informacion'), 1)) {
				Mobile.tap(findTestObject('Object Repository/Cobros_QR/MSG_Sin_Informacion'), 0)
			}
			
			Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.pressBack()
		}
	
		break
	}
}
