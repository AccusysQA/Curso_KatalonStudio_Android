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

'Se hace clic en el botón Transferencias'
Mobile.tap(findTestObject('5_Registro_ACH/BTN_Transferencias'), 0)

'Se coloco un retraso de 2 segundos para pasar al siguiente paso'
Mobile.delay(5)

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getRowNumbers(); numRow++) {
    'Se selecciona la cuenta, según lo configurado en el script y el archivo excel'
    switch (findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getValue(1, numRow).toBigInteger()) {
        case 985:
            
			Mobile.delay(2)
			
            Mobile.tapAtPosition(385, 582)

            break
        case 357:
		Mobile.delay(2)
		
		Mobile.tapAtPosition(650, 557)

            break
    }
    
    'Se coloco un retraso de 2 segundos para pasar al siguiente paso'
    Mobile.delay(2)

    'Clic en el campo Importe'
    Mobile.tap(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), 0)

    'Ingresar los datos del campo Importe'
    Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getValue(
            4, numRow), 0)

    if (findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getValue(2, numRow) == 'D') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/D'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Bs'), 0)
    }
    
    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Seleccionar cuenta de origen'
    Mobile.tapAtPosition(671, 741)

    'Se selecciona la cuenta, según lo configurado en el script y el archivo excel'
    switch (findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getValue(3, numRow).toBigInteger()) {
        case 1127700101002:
            Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/1127700-101-002 (1)'), 0)

            break
        case 1127700000001:
            Mobile.tap(findTestObject('Transferencias_a_Terceros/1127700-000-001_I'), 0)

            break
        case 1025583000001:
            Mobile.tap(findTestObject('Transferencias_a_Terceros/1025583-000-001_I'), 0)

            break
        case 1025583101002:
            Mobile.tap(findTestObject('Transferencias_a_Terceros/CBB_1025583-101-002'), 0)

            break
    }
    
    'Clic en el campo Nota'
    Mobile.tapAtPosition(120, 865)

    'Ingresar los datos del Campo Nota'
    Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencia_ACH/Transferencias_ACH_Inactivas').getValue(5, numRow), 0)

    'Clic en el botón Continuar'
    Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

    if ((((Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_13001'), 1) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15022'), 1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91306'), 
        1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91521'), 1)) || Mobile.waitForElementPresent(
        findTestObject('Object Repository/Transferencias_a_Terceros/BTN_Cerrar_error'), 1)) {
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/BTN_Cerrar_error'), 0)

        Mobile.pressBack()
    } else {
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Confirmar_transferencia'), 0)

        Mobile.delay(10)

        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Cerrar'), 0)

        'Volver atrás'
        Mobile.pressBack()

        Mobile.delay(5)
    }
}

