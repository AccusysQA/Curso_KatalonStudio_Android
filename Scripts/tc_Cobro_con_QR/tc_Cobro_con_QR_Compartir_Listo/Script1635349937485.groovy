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

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Cobros_QR/BTN_Pagos_QR'), 0)

Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

for (def numRow = 1; numRow <= findTestData('Cobro_QR/Cobros_QR').getRowNumbers(); numRow++) {
    Mobile.tapAtPosition(416, 305)

    Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(430, 322)

    Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)

    Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR/Cobros_QR').getValue(1, numRow), 0)

    if (findTestData('Cobro_QR/Cobros_QR').getValue(2, numRow) == 'D') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Cobros_QR/BTN_D'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Cobros_QR/BTN_B'), 0)
    }
    
    Mobile.tapAtPosition(674, 582)

    switch (findTestData('Cobro_QR/Cobros_QR').getValue(3, numRow).toBigInteger()) {
        case 884187000001:
            Mobile.tap(findTestObject('Object Repository/Cobros_QR/884187-000-001'), 0)

            break
        case 1127700101002:
            Mobile.tap(findTestObject('Object Repository/Cobros_QR/1127700-101-002'), 0)

            break
    }
    
    Mobile.tapAtPosition(113, 702)

    Mobile.clearText(findTestObject('Cobros_QR/EDT_Nota'), 0)

    Mobile.setText(findTestObject('Cobros_QR/EDT_Nota'), findTestData('Cobro_QR/Cobros_QR').getValue(4, numRow), 0)

    Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)

    Mobile.tap(findTestObject('Cobros_QR/BTN_Confirmar'), 0)

    if ((((Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_13001'), 1) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15022'), 1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91306'), 
        1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91521'), 1)) || Mobile.waitForElementPresent(
        findTestObject('Object Repository/Transferencias_a_Terceros/BTN_Cerrar_error'), 1)) {
        Mobile.tap(findTestObject('Object Repository/Cobros_QR/ERROR_10080'), 0)

        Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

        Mobile.pressBack()

        Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

        Mobile.pressBack()
    } else {
        Mobile.tap(findTestObject('Cobros_QR/BTN_Compartir'), 0)

        Mobile.pressBack()

        Mobile.tap(findTestObject('Cobros_QR/Cerrar'), 0)
    }
}

Mobile.pressBack()

