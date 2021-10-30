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
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getRowNumbers(); numRow++) {
    'Se hace clic en botón Añadir Beneficiario'
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

    if (findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(1, numRow).trim() == 'Cooperativa Asuncion Ltda') {
        'Selección del Banco según archivo de excel '
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/ITM_Cooperativa_Asuncion'), 0)
    } else {
        'Selección del Banco según archivo de excel '
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/Item_Tigo_Money'), 0)
    }
    
    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el combo "Tipo de Cuenta"'
    Mobile.tapAtPosition(120, 480)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    if (findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(2, numRow) == 'Corriente') {
        'Selección del Tipo de Cuenta, según el archivo excel '
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_Cuenta_Corriente_o_Ahorros_L'), 0)
    } else {
        'Selección del Tipo de Cuenta, según el archivo excel '
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/CBB_Prestamos'), 0)
    }
    
    //Mobile.tapAtPosition(120, 570)
    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el combo "Sucursal de la Cuenta"'
    Mobile.tapAtPosition(120, 638)

    if (findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(3, numRow) == 'Tarija') {
        'Selección de Sucursal, según el archivo excel '
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_Tarija'), 0)
    } else {
        'Selección de Sucursal, según el archivo excel '
        Mobile.tap(findTestObject('5_Registro_ACH/CBB_La_Paz'), 0)
    }
    
    Mobile.tapAtPosition(120, 726)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    'Clic en el campo Número de cuenta'
    Mobile.tapAtPosition(120, 760)

    'Ingresar datos en el campo Número de cuenta'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Numero_de_cuenta'), findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(
            4, numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Nombre del Beneficiario'
    Mobile.tapAtPosition(475, 886)

    'Ingresar datos en el Nombre del Beneficiario'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Nombre_del_beneficiario'), findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(
            5, numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Se coloco 3 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    if (findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(6, numRow) == 'B') {
        'Clic en botón de la moneda, según el archivo excel '
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_B-1'), 0)
    } else {
        'Clic en botón de la moneda, según el archivo excel '
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/BTN_D'), 0)
    }
    
    'Clic en el check Favoritos'
    Mobile.tap(findTestObject('5_Registro_ACH/CHK_Favoritos'), 0)

    'Clic en Información Adicional'
    Mobile.checkElement(findTestObject('5_Registro_ACH/BTN_Informacion_Adicional_ACH'), 0)

    'Se simula deslizar verticalmente para obtener los demas campos '
    Mobile.swipe(120, 1250, 120, 1000)

    'Clic en el campo Alias'
    Mobile.tapAtPosition(65, 657)

    'Borrar los datos del Campo Alias'
    Mobile.clearText(findTestObject('5_Registro_ACH/EDT_Alias_IA'), 0, FailureHandling.STOP_ON_FAILURE)

    'Ingresar los datos del Campo Alias'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Alias_IA'), findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(
            7, numRow), 0)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    'Clic en el combo seleccionar Tipo de documento'
    Mobile.tapAtPosition(669, 793)

    if (findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(8, numRow) == 'Carnet') {
        'Seleccionar Tipo de documento'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/CBB_CARNET DE IDENTIDAD'), 0)
    } else {
        'Seleccionar Tipo de documento'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/CBB_EMPRESA_EXTRANJERA'), 0)
    }
    
    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    'Se simula deslizar verticalmente para obtener los demas campos '
    Mobile.swipe(145, 1200, 145, 1000)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    'Clic en número de documento'
    Mobile.tapAtPosition(120, 780)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    //TECLADO ALFANUMERICO ***** N O - B O R R A R *****
    String[] valores = findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(9, numRow).split('')

    'Se repite el ciclo según lo configurado en el script y el archivo excel'
    for (def index : (0..valores.length - 1)) {
        switch (valores[index]) {
            case '1':
                Mobile.tapAtPosition(45, 950)

                break
            case '2':
                Mobile.tapAtPosition(115, 950)

                break
            case '3':
                Mobile.tapAtPosition(185, 950)

                break
            case '4':
                Mobile.tapAtPosition(255, 950)

                break
            case '5':
                Mobile.tapAtPosition(325, 950)

                break
            case '6':
                Mobile.tapAtPosition(395, 950)

                break
            case '7':
                Mobile.tapAtPosition(465, 950)

                break
            case '8':
                Mobile.tapAtPosition(535, 950)

                break
            case '9':
                Mobile.tapAtPosition(605, 950)

                break
            case '0':
                Mobile.tapAtPosition(675, 950)

                break
            case 'q':
                Mobile.tapAtPosition(45, 1050)

                break
            case 'w':
                Mobile.tapAtPosition(115, 1050)

                break
            case 'e':
                Mobile.tapAtPosition(185, 1050)

                break
            case 'r':
                Mobile.tapAtPosition(255, 1050)

                break
            case 't':
                Mobile.tapAtPosition(325, 1050)

                break
            case 'y':
                Mobile.tapAtPosition(395, 1050)

                break
            case 'u':
                Mobile.tapAtPosition(465, 1050)

                break
            case 'i':
                Mobile.tapAtPosition(535, 1050)

                break
            case 'o':
                Mobile.tapAtPosition(605, 1050)

                break
            case 'p':
                Mobile.tapAtPosition(675, 1050)

                break
            case 'a':
                Mobile.tapAtPosition(45, 1150)

                break
            case 's':
                Mobile.tapAtPosition(115, 1150)

                break
            case 'd':
                Mobile.tapAtPosition(185, 1150)

                break
            case 'f':
                Mobile.tapAtPosition(255, 1150)

                break
            case 'g':
                Mobile.tapAtPosition(325, 1150)

                break
            case 'h':
                Mobile.tapAtPosition(395, 1150)

                break
            case 'j':
                Mobile.tapAtPosition(465, 1150)

                break
            case 'k':
                Mobile.tapAtPosition(535, 1150)

                break
            case 'l':
                Mobile.tapAtPosition(605, 1150)

                break
            case 'ñ':
                Mobile.tapAtPosition(675, 1150)

                break
            case 'z':
                Mobile.tapAtPosition(150, 1250)

                break
            case 'x':
                Mobile.tapAtPosition(220, 1250)

                break
            case 'c':
                Mobile.tapAtPosition(290, 1250)

                break
            case 'v':
                Mobile.tapAtPosition(360, 1250)

                break
            case 'b':
                Mobile.tapAtPosition(430, 1250)

                break
            case 'n':
                Mobile.tapAtPosition(500, 1250)

                break
            case 'm':
                Mobile.tapAtPosition(570, 1250)

                break
            case ',':
                Mobile.tapAtPosition(150, 1350)

                break
            case ' ':
                Mobile.tapAtPosition(360, 1350)

                break
            case '.':
                Mobile.tapAtPosition(570, 1350)

                break
        }
    }
    
    //FIN CODIGO TECLADO ALFANUMERICO ***** N O - B O R R A R *****
    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    'Clic en el campo Número de celular'
    Mobile.tapAtPosition(120, 904)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    'Ingresar los datos en el campo Número de celular'
    Mobile.setText(findTestObject('Object Repository/5_Registro_ACH/EDT_Nro.celular_(Opcional)1'), findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(
            10, numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Email'
    Mobile.tapAtPosition(400, 1060)

    'Ingresar los datos en el campo Email '
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Email1'), findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(11, 
            numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Clic en el campo Nota'
    Mobile.tapAtPosition(120, 1180)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    //TECLADO ALFANUMERICO ***** N O - B O R R A R *****
    String[] notaopc = findTestData('Registro_Beneficiario/Registro_ACH_Mas_Informacion').getValue(12, numRow).toLowerCase().split('')

    'Se repite el ciclo según lo configurado en el script y el archivo excel en el campo Nota'
    for (def index : (0..notaopc.length - 1)) {
        switch (notaopc[index]) {
            case '1':
                Mobile.tapAtPosition(45, 950)

                break
            case '2':
                Mobile.tapAtPosition(115, 950)

                break
            case '3':
                Mobile.tapAtPosition(185, 950)

                break
            case '4':
                Mobile.tapAtPosition(255, 950)

                break
            case '5':
                Mobile.tapAtPosition(325, 950)

                break
            case '6':
                Mobile.tapAtPosition(395, 950)

                break
            case '7':
                Mobile.tapAtPosition(465, 950)

                break
            case '8':
                Mobile.tapAtPosition(535, 950)

                break
            case '9':
                Mobile.tapAtPosition(605, 950)

                break
            case '0':
                Mobile.tapAtPosition(675, 950)

                break
            case 'q':
                Mobile.tapAtPosition(45, 1050)

                break
            case 'w':
                Mobile.tapAtPosition(115, 1050)

                break
            case 'e':
                Mobile.tapAtPosition(185, 1050)

                break
            case 'r':
                Mobile.tapAtPosition(255, 1050)

                break
            case 't':
                Mobile.tapAtPosition(325, 1050)

                break
            case 'y':
                Mobile.tapAtPosition(395, 1050)

                break
            case 'u':
                Mobile.tapAtPosition(465, 1050)

                break
            case 'i':
                Mobile.tapAtPosition(535, 1050)

                break
            case 'o':
                Mobile.tapAtPosition(605, 1050)

                break
            case 'p':
                Mobile.tapAtPosition(675, 1050)

                break
            case 'a':
                Mobile.tapAtPosition(45, 1150)

                break
            case 's':
                Mobile.tapAtPosition(115, 1150)

                break
            case 'd':
                Mobile.tapAtPosition(185, 1150)

                break
            case 'f':
                Mobile.tapAtPosition(255, 1150)

                break
            case 'g':
                Mobile.tapAtPosition(325, 1150)

                break
            case 'h':
                Mobile.tapAtPosition(395, 1150)

                break
            case 'j':
                Mobile.tapAtPosition(465, 1150)

                break
            case 'k':
                Mobile.tapAtPosition(535, 1150)

                break
            case 'l':
                Mobile.tapAtPosition(605, 1150)

                break
            case 'ñ':
                Mobile.tapAtPosition(675, 1150)

                break
            case 'z':
                Mobile.tapAtPosition(150, 1250)

                break
            case 'x':
                Mobile.tapAtPosition(220, 1250)

                break
            case 'c':
                Mobile.tapAtPosition(290, 1250)

                break
            case 'v':
                Mobile.tapAtPosition(360, 1250)

                break
            case 'b':
                Mobile.tapAtPosition(430, 1250)

                break
            case 'n':
                Mobile.tapAtPosition(500, 1250)

                break
            case 'm':
                Mobile.tapAtPosition(570, 1250)

                break
            case ',':
                Mobile.tapAtPosition(150, 1350)

                break
            case ' ':
                Mobile.tapAtPosition(360, 1350)

                break
            case '.':
                Mobile.tapAtPosition(570, 1350)

                break
        }
    }
    
    //FIN CODIGO TECLADO ALFANUMERICO ***** N O - B O R R A R *****
    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    Mobile.tapAtPosition(120, 1380)

    'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
    Mobile.delay(2)

    if (Mobile.waitForElementPresent(findTestObject('Object Repository/5_Registro_ACH/BTN_Cerrar (1)'), 2)) {
        'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
        Mobile.delay(2)

        'Clic en el botón Cerrar'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/BTN_Cerrar (1)'), 0)

        'Se cierra el teclado del teléfono para pasar al siguiente campo'
        Mobile.hideKeyboard()

        'Se coloco 2 segundos de retraso para que se ejecute el siguiente paso'
        Mobile.delay(2)

        'Volver atrás'
        Mobile.pressBack()
    } else {
        'Clic en el Botón Añadir Beneficiario'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/BTN_Aadir_Beneficiario'), 0)

        'Esperar 20 segundos hasta que el botón cerrar este presente'
        Mobile.waitForElementPresent(findTestObject('Object Repository/5_Registro_ACH/BTN_Cerrar (1)'), 20)

        'Clic en el botón Cerrar'
        Mobile.tap(findTestObject('Object Repository/5_Registro_ACH/BTN_Cerrar (1)'), 0)

        'Volver atrás'
        Mobile.pressBack()
    }
}

