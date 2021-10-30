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

WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('5_Registro_ACH/BTN_Transferencias'), 0)

for (def numRow = 1; numRow <= findTestData('Transferencias_entre_cuentas/T_Inactivas').getRowNumbers(); numRow++) {
    //System.out.println(findTestData('Transferencias').getValue(1, numRow))
    switch (findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(1, numRow).toBigInteger()) {
        case 1127700101002:
            Mobile.delay(2)

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/CBB_Selecciona_la_cuenta_destino'), 0)

            Mobile.delay(2)

            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/1127700101002'), 0)

            Mobile.delay(1)

            Mobile.tapAtPosition(120, 507)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    4, numRow), 0)

            if (findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(2, numRow) == 'B') {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Bolivares_N'), 0)
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Dolares_N'), 0)
            }
            
            Mobile.tapAtPosition(120, 752)

            Mobile.delay(2)

            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/1025583-000-001_1'), 0)

            //switch (findTestData('T_Inactivas').getValue(3, numRow).toBigInteger()) {
            //    case 1025583000001:
            //       break
            //}
            Mobile.tapAtPosition(120, 895)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    5, numRow), 0)

            Mobile.hideKeyboard()

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

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
                0)) {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

                Mobile.pressBack()
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

                Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 
                    50)

                Mobile.pressBack()
            }
            
            //Mobile.pressBack()
            break
        case 1025583101002:
            Mobile.delay(2)

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/CBB_Selecciona_la_cuenta_destino'), 0)

            Mobile.delay(2)

            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/CBB_1025583-101-002_US_BLOQUEADA'), 
                0)

            Mobile.delay(1)

            Mobile.tapAtPosition(120, 507)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    4, numRow), 0)

            if (findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(2, numRow) == 'B') {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Bolivares_N'), 0)
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Dolares_N'), 0)
            }
            
            Mobile.tapAtPosition(120, 752)

            Mobile.delay(2)

            switch (findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(3, numRow).toBigInteger()) {
                case 1127700000001:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-1127700000001'), 0)

                    break
                case 1025583000001:
                    Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/1025583-000-001_def'), 0)

                    break
            }
            
            Mobile.tapAtPosition(120, 895)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    5, numRow), 0)

            Mobile.hideKeyboard()

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

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
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

                Mobile.pressBack()
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

                Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 
                    50)

                Mobile.pressBack()
            }
            
            //Mobile.pressBack()
            break
        case 1127700000001:
            Mobile.delay(2)

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/CBB_Selecciona_la_cuenta_destino'), 0)

            Mobile.delay(2)

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/D-1127700000001-2'), 0)

            Mobile.delay(1)

            Mobile.tapAtPosition(120, 507)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Importe_transferencia1'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    4, numRow), 0)

            if (findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(2, numRow) == 'B') {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Bolivares_N'), 0)
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Dolares_N'), 0)
            }
            
            Mobile.tapAtPosition(120, 752)

            Mobile.delay(2)

            Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/D-884187101002'), 0)

            Mobile.tapAtPosition(120, 895)

            Mobile.setText(findTestObject('Transferncias_entre_cuentas/EDT_Nota'), findTestData('Transferencias_entre_cuentas/T_Inactivas').getValue(
                    5, numRow), 0)

            Mobile.hideKeyboard()

            Mobile.tap(findTestObject('Transferncias_entre_cuentas/BTN_Continuar'), 0)

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
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

                Mobile.pressBack()
            } else {
                Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Confirma'), 0)

                Mobile.waitForElementPresent(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Cerrar_Completado'), 
                    50)

                Mobile.pressBack()
            }
            
            //Mobile.pressBack()
            break
    }
}

