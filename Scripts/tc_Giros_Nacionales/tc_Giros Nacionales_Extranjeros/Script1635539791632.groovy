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

for (def numRow = 1; numRow <= findTestData('Giros_Nacionales/Giros_Nacionales').getRowNumbers(); numRow++) {
Mobile.tap(findTestObject('Giros_Nacionales/BTN_Menu'), 0)

Mobile.tap(findTestObject('Giros_Nacionales/ETQ_Giros Nacionales'), 0)

    Mobile.tapAtPosition(70, 452)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Nombres'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Nombres'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(1, numRow), 
        0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(490, 569)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Apellido paterno'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Apellido paterno'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(2, 
            numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(248, 687)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Apellido maternocasada'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Apellido maternocasada'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(
            3, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(672, 829)

    if (findTestData('Giros_Nacionales/Giros_Nacionales').getValue(4, numRow) == 'Chuquisaca') {
        Mobile.tap(findTestObject('Giros_Nacionales/CHUQUISACA'), 0)
    } else {
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/CBB_La_Paz'), 0)
    }
    
    Mobile.tapAtPosition(491, 969)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Nro.celular_del_Beneficiario'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Nro.celular_del_Beneficiario'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(
            5, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(662, 986)

    Mobile.tap(findTestObject('Giros_Nacionales/CBB_Extranjero'), 0)

    //Mobile.swipe(100, 410, 100, 100)
    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

    //Mobile.tapAtPosition(346, 627)
    Mobile.tapAtPosition(110, 1174)

    Mobile.clearText(findTestObject('Giros_Nacionales/TXT_Nro_Doc_Attributes'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/TXT_Nro_Doc_Attributes'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(
            7, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.swipe(100, 410, 100, 100)

    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(185, 570)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Importe'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Importe'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(10, numRow), 
        0)

    if (findTestData('Giros_Nacionales/Giros_Nacionales').getValue(11, numRow) == 'B') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Bs'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/D'), 0)
    }
    
    Mobile.tapAtPosition(671, 820)

    if (findTestData('Giros_Nacionales/Giros_Nacionales').getValue(12, numRow) == '1127700000003') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/1127700-000-003'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/1127700-101-004'), 0)
    }
    
    Mobile.tap(findTestObject('Giros_Nacionales/CheckBox'), 0)

    Mobile.tapAtPosition(120, 1149)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Nota'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Nota'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(13, numRow), 0)

    Mobile.tap(findTestObject('Giros_Nacionales/BTN_Continuar'), 0)

    Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(356, 550)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Origen'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Origen'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(14, numRow), 
        0)

    Mobile.hideKeyboard()

    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(211, 878)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Destino'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Destino'), findTestData('Giros_Nacionales/Giros_Nacionales').getValue(15, numRow), 
        0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(368, 1103)

    Mobile.delay(15, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(296, 1038)

	Mobile.waitForElementPresent(findTestObject('Object Repository/Giros_Nacionales/IMG_Pago_Completado'), 50)
	
    Mobile.pressBack()
}

