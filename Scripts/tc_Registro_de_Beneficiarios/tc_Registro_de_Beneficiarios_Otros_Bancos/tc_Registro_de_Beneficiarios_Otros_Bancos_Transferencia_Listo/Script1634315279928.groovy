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

'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
Mobile.delay(2)

AgregarNuevo = true

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_ACH').getRowNumbers(); numRow++) {
    if (AgregarNuevo) {
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_Anadir_beneficiario'), 0)
    }
    
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
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/Item_Tigo_Money'), 0)
    }
    
    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
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
    
    Mobile.tapAtPosition(120, 570)
    //Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

  
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

    'Clic en el campo Número de cuenta '
    Mobile.tapAtPosition(120, 760)

    'Ingresar los datos en el campo Número de cuenta '
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

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
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
        Mobile.tap(findTestObject('Object Repository/Transferncias_entre_cuentas/BTN_Error'), 0)

        'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        AgregarNuevo = false //   Mobile.pressBack()
        //  case 'B':
        //  Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Bs'), 0)
        //   break
    } else {
        'Clic en el botón Añadir Beneficiario'
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_anadir_beneficiario (1)'), 0)

        'Clic en el botón cerrar'
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_Cerrar'), 0)

        'Se coloco 5 segundos de retraso para que se ejecute el siguiente paso'
        Mobile.delay(5)

        'Esperar 10 segundos hasta que el objeto este presente'
        Mobile.waitForElementPresent(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), 
            10)

        'Clic en el campo Importe'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), 0)

        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        'Ingresar los datos en campo Importe'
        Mobile.setText(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), findTestData('Registro_Beneficiario/Registro_ACH').getValue(
                7, numRow), 0)

        'Se cierra el teclado del teléfono para pasar al siguiente campo'
        Mobile.hideKeyboard()

        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        switch (findTestData('Registro_Beneficiario/Registro_ACH').getValue(8, numRow).trim()) {
            case 'S':
                'Seleccionar la opción según el archivo excel\r\n\r\n1. Si en el excel se visualiza la opción S, seleccionará Bolivianos \r\n2. Si en el excel se visualiza la opción D, seleccionará Dólares'
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Dlrs'), 0)

                break
        }
        
        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        'Clic en el campo Cuenta'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/CBO_Seleccionar_Cuenta'), 0)

        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        switch (findTestData('Registro_Beneficiario/Registro_ACH').getValue(9, numRow).toBigInteger()) {
            case 1127700000003:
                'Seleccionar el número de cuenta según el archivo excel '
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/ITM_1127700000003'), 0)

                break
            case 1127700101002:
                'Seleccionar el número de cuenta según el archivo excel '
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/ITM_1127700101002'), 0)

                break
        }
        
        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        'Clic en el campo Nota'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Nota_Opc'), 0)

        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        'Ingresar los datos del campo Nota'
        Mobile.setText(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Nota_Opc'), findTestData(
                'Registro_Beneficiario/Registro_ACH').getValue(10, numRow), 0)

        'Se cierra el teclado del teléfono para pasar al siguiente campo'
        Mobile.hideKeyboard()

        'Clic en el botón Continuar'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Continuar'), 0)

        'Se coloco 1 segundo de retraso para que se ejecute el siguiente paso'
        Mobile.delay(1)

        'Clic en el botón Transferir'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Transferir'), 0)

        'Esperar 10 segundos hasta que se visualice el objeto'
        Mobile.waitForElementPresent(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/IMG_Exitoso'), 
            50)

        AgregarNuevo = true

        'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
        Mobile.delay(2)

        'Volver atrás'
        Mobile.pressBack()
    }
}

'Se queda en pantalla del menú Transferencias'
Mobile.tapAtPosition(42, 120)

