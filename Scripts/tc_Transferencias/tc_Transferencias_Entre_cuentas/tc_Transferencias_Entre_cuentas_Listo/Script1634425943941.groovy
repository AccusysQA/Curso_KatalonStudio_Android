import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.mobile.keyword.internal.MobileAbstractKeyword as MobileAbstractKeyword
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Se agregó el caso de Login No reinstalar la aplicación'
WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)

'Se hace clic en el botón Transferencias'
Mobile.tap(findTestObject('5_Registro_ACH/BTN_Transferencias'), 0)

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Transferencias_entre_cuentas/Transferencias').getRowNumbers(); numRow++) {
    //System.out.println(findTestData('Transferencias').getValue(1, numRow))
    switch (findTestData('Transferencias_entre_cuentas/Transferencias').getValue(1, numRow).toBigInteger()) {
        case 1127700101002:
            Mobile.delay(2)

            'Se selecciona la cuenta según el archivo excel'
            Mobile.tap(findTestObject('Transferncias_entre_cuentas/CBB_Selecciona_la_cuenta_destino'), 0)

            'Se retrasa 2 segundos para que se ejecute el siguiente paso'
            Mobile.delay(2)

            'Clic en la cuenta según el archivo excel'
            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/1127700101002'), 0)

            'Se retrasa 1 segundo para que se ejecute el siguiente paso'
            Mobile.delay(1)

            'Clic en el campo Importe'
            Mobile.tapAtPosition(120, 507)

            'Ingresar los datos en el campo Importe'
            Mobile.setText(findTestObject('Object Repository/Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_entre_cuentas/Transferencias').getValue(
                    4, numRow), 0)
			
            if (findTestData('Transferencias_entre_cuentas/Transferencias').getValue(2, numRow) == 'B') {
                'Seleccionar el botón Bolivianos, según el archivo excel'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Bolivares_N'), 0)
            } else {
                'Seleccionar el botón dólares, según el archivo excel'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Dolares_N'), 0)
            }
            
            Mobile.tapAtPosition(120, 752)

            'Se retrasa 2 segundos para que se ejecute el siguiente paso'
            Mobile.delay(2)

            'Se selecciona la cuenta según el archivo excel'
            switch (findTestData('Transferencias_entre_cuentas/Transferencias').getValue(3, numRow).toBigInteger()) {
                case 1127700000001:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700000001-2'), 0)

                    break
                case 1127700000003:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700000003-2'), 0)

                    break
                case 1127700101002:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700101002'), 0)

                    break
                case 1127700101004:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700101004'), 0)

                    break
                case 884187101002:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-884187101002'), 0)

                    break
            }
            
            'Clic en el campo Nota'
            Mobile.tapAtPosition(120, 895)

            'Ingresar los datos en el campo Nota'
            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_entre_cuentas/Transferencias').getValue(
                    5, numRow), 0)

            'Se cierra el teclado del teléfono para pasar al siguiente campo'
            Mobile.hideKeyboard()

            'Clic en el botón Continuar'
            Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

            'Se retrasa 5 segundos para que se ejecute el siguiente paso'
            Mobile.delay(5)

            respuesta = false

            while (respuesta == false) {
                if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 
                    1)) {
                    respuesta = true
                } else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 
                    1)) {
                    respuesta = true
                }
            }
            
            if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 
                1)) {
                'Clic en el Botón al aparecer un error'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

                'Volver atrás'
                Mobile.pressBack()
            } else {
                'Clic en el botón Confirmar'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

                'Clic en el botón Cerrar'
                Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 
                    50)

                'Volver atrás'
                Mobile.pressBack()
            }
           
            break
        case 1127700000001:
            Mobile.delay(2)

            'Seleccionar la cuenta según el archivo excel'
            Mobile.tap(findTestObject('Transferncias_entre_cuentas/CBB_Selecciona_la_cuenta_destino'), 0)

            'Se retrasa 2 segundos para que se ejecute el siguiente paso'
            Mobile.delay(2)

            'Seleccionar la cuenta según el archivo excel'
            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/1127700000001'), 0)

            'Se retrasa 1 segundo para que se ejecute el siguiente paso'
            Mobile.delay(1)

            'Clic en el campo Importe'
            Mobile.tapAtPosition(120, 507)

            'Ingresar los datos en el campo Importe'
            Mobile.setText(findTestObject('Object Repository/Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_entre_cuentas/Transferencias').getValue(
                    4, numRow), 0)

            if (findTestData('Transferencias_entre_cuentas/Transferencias').getValue(2, numRow) == 'B') {
                'Seleccionar Bolivianos según el archivo excel'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Bolivares_N'), 0)
            } else {
                'Seleccionar Dólares según el archivo excel'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Dolares_N'), 0)
            }
            
            Mobile.tapAtPosition(120, 752)

            'Se retrasa 2 segundos para que se ejecute el siguiente paso'
            Mobile.delay(2)

            switch (findTestData('Transferencias_entre_cuentas/Transferencias').getValue(3, numRow).toBigInteger()) {
                case 1127700000001:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700000001'), 0)

                    break
                case 1127700000003:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700000003'), 0)

                    break
                case 1127700101002:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700101002'), 0)

                    break
                case 1127700101004:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700101004'), 0)

                    break
                case 884187101002:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-884187101002'), 0)

                    break
            }
            
            'Clic en el campo Nota'
            Mobile.tapAtPosition(120, 895)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_entre_cuentas/Transferencias').getValue(
                    5, numRow), 0)

            'Se cierra el teclado del teléfono para pasar al siguiente campo'
            Mobile.hideKeyboard()

            'Clic en el campo Continuar'
            Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

            'Se retrasa 5 segundos para que se ejecute el siguiente paso'
            Mobile.delay(5)

            respuesta = false

            while (respuesta == false) {
                if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 
                    1)) {
                    respuesta = true
                } else if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 
                    1)) {
                    respuesta = true
                }
            }
            
            if (Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 
                1)) {
                'Clic en el botón en caso de que exista un error'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

                Mobile.pressBack()
            } else {
                'Clic en el botón Confirmar'
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

                'Clic en el botón Cerrar'
                Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 
                    50)

                'Volver atrás'
                Mobile.pressBack()
            }
            
            //Mobile.pressBack()
            break
    }
}

'Volver a la pantalla de transferencias'
Mobile.tapAtPosition(42, 120)

