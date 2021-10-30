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

'Se agregó el caso de Login No reinstalar la aplicación'
WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)

'Se hace clic en el botón Transferencias'
Mobile.tap(findTestObject('5_Registro_ACH/BTN_Transferencias'), 0)

'Se coloco un retraso de 2 segundos para pasar al siguiente paso'
Mobile.delay(2)

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getRowNumbers(); numRow++) {
    'Se coloco un retraso de 5 segundos para pasar al siguiente paso'
    Mobile.delay(5)

    'Se selecciona la cuenta, según lo configurado en el script y el archivo excel'
    switch (findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getValue(1, numRow).toBigInteger()) {
        case 1819492000001:
		for (def index : (0..4)) {
			Mobile.swipe(600, 550, 400, 550)
		}
		
		Mobile.delay(2)
		
		Mobile.tapAtPosition(625, 594)
		break
        case 1399388101002:
		    for (def index : (0..2)) {
	Mobile.swipe(600, 550, 400, 550)
}
    Mobile.delay(2)
    Mobile.tapAtPosition(464, 584)


            break
    }
    
    'Se coloco un retraso de 2 segundos para pasar al siguiente paso'
    Mobile.delay(2)

    'Clic en el campo Importe'
    Mobile.tap(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), 0)

    'Borrar los datos del campo Importe'
    Mobile.clearText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), 0)

    //Mobile.tapAtPosition(120, 507)
    'Ingresar los datos del campo Importe'
    Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getValue(
            4, numRow), 0)

    if (findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getValue(2, numRow) == 'B') {
        'Clic en el botón de Moneda Bolivianos, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/Bs'), 0)
    } else {
        'Clic en el botón de Moneda Dólares, según lo configurado en el Script'
        Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/D'), 0)
    }
    
    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Seleccionar cuenta de origen'
    Mobile.tapAtPosition(671, 817)

    'Se coloco un retraso de 2 segundos para pasar al siguiente paso'
    Mobile.delay(2)

    'Se selecciona la cuenta, según lo configurado en el script y el archivo excel'
    switch (findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getValue(3, numRow).toBigInteger()) {
        case 1127700000001:
            Mobile.tap(findTestObject('Transferencias_a_Terceros/1127700-000-001'), 0)

            break
        case 1127700101002:
            Mobile.tap(findTestObject('Object Repository/Transferencias_a_Terceros/1127700-101-002'), 0)

            break
    }
    
    'Clic en el campo Nota'
    Mobile.tapAtPosition(120, 937)

    'Borrar los datos del Campo Nota'
    Mobile.clearText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), 0)

    'Ingresar los datos del Campo Nota'
    Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_Terceros_BSOL/Transferencia_terceros_Bsol').getValue(
            5, numRow), 0)

    'Clic en el botón Continuar'
    Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

    respuesta = false
     while (respuesta == false) {
    if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 1)) {
        respuesta = true
     } else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 
          1)) {
   respuesta = true
     }
    }
     if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 1)) {
       Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)
         Mobile.pressBack()
    } else {
    'Clic en el botón Confirmar'
    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

    'Clic en el botón Cerrar'
    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 0)

    'Volver atrás'
    Mobile.pressBack() }
}

