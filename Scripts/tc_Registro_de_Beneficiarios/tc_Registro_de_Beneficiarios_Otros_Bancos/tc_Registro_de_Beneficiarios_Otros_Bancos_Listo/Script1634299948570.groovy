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

'Se agrega el caso de Login No reinstalar la aplicación'
WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)

'Se hace clic en el botón Transferencias'
Mobile.tap(findTestObject('5_Registro_ACH/BTN_Transferencias'), 0)

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_ACH').getRowNumbers(); numRow++) {
    'Clic en el botón Añadir'
    Mobile.tap(findTestObject('5_Registro_ACH/BTN_Anadir_beneficiario'), 0)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el combo "Banco"'
    Mobile.tapAtPosition(655, 342)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Se simula deslizar verticalmente para obtener los demas campos '
    Mobile.swipe(145, 1200, 145, 800)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    if (findTestData('Registro_Beneficiario/Registro_ACH').getValue(1, numRow).trim() == 'Cooperativa Asuncion Ltda') {
        'Selección del Banco en el combo correspondiente, según el archivo de excel'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/ITM_Cooperativa_Asuncion'), 0)
    } else {
        'Selección del Banco en el combo correspondiente, según el archivo de excel'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/Item_Tigo_Money'), 0)
    }
    
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el combo "Tipo de Cuenta"'
    Mobile.tapAtPosition(120, 480)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    if (findTestData('Registro_Beneficiario/Registro_ACH').getValue(2, numRow) == 'Corriente') {
        'Selecciona el tipo de cuenta, según el archivo de excel'
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_Cuenta_Corriente_o_Ahorros_L'), 0)
    } else {
        'Selecciona el tipo de cuenta, según el archivo de excel'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/CBB_Prestamos'), 0)
    }
    
    //Mobile.tapAtPosition(120, 570)
    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el combo "Sucursal de la cuenta"'
    Mobile.tapAtPosition(120, 638)

    //Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
    if (findTestData('Registro_Beneficiario/Registro_ACH').getValue(3, numRow) == 'Tarija') {
        'Selecciona la "Sucursal de la cuenta", según el archivo de excel '
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_Tarija'), 0)
    } else {
        'Selecciona la "Sucursal de la cuenta", según el archivo de excel '
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_La_Paz'), 0)
    }
    
    Mobile.tapAtPosition(120, 726)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el campo Número de cuenta'
    Mobile.tapAtPosition(120, 760)

    'Ingresar los datos en el campo Número de cuenta'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Numero_de_cuenta'), findTestData('Registro_Beneficiario/Registro_ACH').getValue(4, numRow), 
        0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Nombre del beneficiario'
    Mobile.tapAtPosition(475, 886)

    'Ingresar los datos en el campo Nombre del beneficiario'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Nombre_del_beneficiario'), findTestData('Registro_Beneficiario/Registro_ACH').getValue(5, 
            numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Se coloco 3 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    if (findTestData('Registro_Beneficiario/Registro_ACH').getValue(6, numRow) == 'B') {
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_B-1'), 0)
    } else {
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/BTN_D'), 0)
    }
    
    //Mobile.tap(findTestObject('5_Registro_ACH/BTN_B'), 0)
    'Clic en el check "Favoritos"'
    Mobile.tap(findTestObject('5_Registro_ACH/CHK_Favoritos'), 0)

    'Clic en el botón "Continuar"'
    Mobile.tap(findTestObject('5_Registro_ACH/BTN_Continuar'), 0)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    if (Mobile.waitForElementPresent(findTestObject('Object Repository/4_Registro_Banco_Sol/MSG_15000'), 10)) {
        'Clic aceptando el mensaje de error'
        Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

        'Volver atrás'
        Mobile.pressBack()
    } else {
        'Clic en el botón Añadir Beneficiarios'
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_anadir_beneficiario (1)'), 0)

        'Clic en el boton "Cerrar"'
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_Cerrar'), 0)

        'Volver atrás'
        Mobile.pressBack()
    }
}

'Se queda en pantalla del menú Transferencias'
Mobile.tapAtPosition(42, 120)

