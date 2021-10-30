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

for (def numRow = 1; numRow <= findTestData('Giros_Nacionales/Giros_Nacional').getRowNumbers(); numRow++) {
    Mobile.tap(findTestObject('Giros_Nacionales/BTN_Menu'), 0)

    Mobile.tap(findTestObject('Giros_Nacionales/ETQ_Giros Nacionales'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Nombres'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Nombres_Selected'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(
            1, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Apellido'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Apellido_Selected'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(
            2, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Apellido_2'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Apellido_2_Selected'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(
            3, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/CBO_Departamento'), 0)

    if (findTestData('Giros_Nacionales/Giros_Nacionales').getValue(4, numRow) == 'Chuquisaca') {
        Mobile.tap(findTestObject('Giros_Nacionales/CHUQUISACA'), 0)
    } else {
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/CBB_La_Paz'), 0)
    }
    
    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_NumeroCelular'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_NumeroCelular_Selected'), findTestData(
            'Giros_Nacionales/Giros_Nacional').getValue(5, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/CBO_TipoDocumento'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/CBO_TipoDocumento_Item_Nacional'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_NroDocumento'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_NroDocumento_Selected'), findTestData(
            'Giros_Nacionales/Giros_Nacional').getValue(7, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_ComplementoCI'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_ComplementoCI_Selected'), findTestData(
            'Giros_Nacionales/Giros_Nacional').getValue(8, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/CBO_DptoEmision'), 0)

    if (findTestData('Giros_Nacionales/Giros_Nacional').getValue(9, numRow) == 'CH') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/CBB_CH'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/CBB_LP'), 0)
    }
    
    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_ImporteGiro'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_ImporteGiro_Selected'), findTestData(
            'Giros_Nacionales/Giros_Nacional').getValue(10, numRow), 0)

    Mobile.hideKeyboard()

    //Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/BTN_MonedaBS'), 0)
    if (findTestData('Giros_Nacionales/Giros_Nacional').getValue(11, numRow) == 'B') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Bs'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/D'), 0)
    }
    
    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/CBO_CtaOrigen'), 0)

    if (findTestData('Giros_Nacionales/Giros_Nacional').getValue(12, numRow) == '1127700000003') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/1127700-000-003'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/1127700-101-004'), 0)
    }
    
    Mobile.swipe(366, 1209, 366, 1100)

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Nota'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/Nacional/TXT_Nota_Selected'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(
            13, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.delay(5)

    Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/Nacional/BTN_Continuar'), 0)

    Mobile.delay(9, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(356, 550)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Origen'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Origen'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(14, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(211, 878)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Destino'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Destino'), findTestData('Giros_Nacionales/Giros_Nacional').getValue(15, numRow), 
        0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(366, 1120)

    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(341, 981)

    Mobile.waitForElementPresent(findTestObject('Object Repository/Giros_Nacionales/IMG_Pago_Completado'), 50)

    Mobile.pressBack()
}

