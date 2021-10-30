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

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getRowNumbers(); numRow++) {
    // Mobile.tapAtPosition(635, 140)
    'Clic en Añadir Beneficiario'
    Mobile.tap(findTestObject('5_Registro_ACH/BTN_Anadir_beneficiario'), 0)

    'Se colocó un retraso de 3 segundos para que cuando se agregue cada unos de los beneficiarios establecidos en el script consigan el campo correcto y no falle la prueba'
    Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)

    'Hace clic en el campo Número de cuenta'
    Mobile.tapAtPosition(50, 491)

    'Borra los datos del campo Número de cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_de_cuenta'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Número de cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_de_cuenta'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            1, numRow), 0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Hace clic en el campo Propietario de la cuenta'
    Mobile.tapAtPosition(47, 604)

    'Borra los datos del campo Propietario de la cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario_de_la_cuenta'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Propietario de la cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario_de_la_cuenta'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            2, numRow), 0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el check "Favoritos"'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/CHK_Favorito'), 0)

    'Clic en el botón Mas información'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Informacion_Adicional'), 0)

    'Clic en el campo Alias'
    Mobile.tapAtPosition(47, 654)

    'Borrar los datos del campo Alias'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Alias'), 0)

    'Ingresar los datos del campo Alias'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Alias'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            4, numRow), 0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el campo Número de Celular'
    Mobile.tapAtPosition(48, 791)

    'Se borran los datos del campo Número de Celular'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Nro.celular'), 0)

    'Se Ingresan los datos del campo Número de Celular'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Nro.celular'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            5, numRow), 0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el campo Email'
    Mobile.tapAtPosition(120, 880)

    'Borrar los datos del campo Email'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_E-mail'), 0)

    'Ingresar los datos del campo Email'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_E-mail'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            6, numRow), 0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el campo Nota'
    Mobile.tapAtPosition(120, 990)

    'Borrar los datos del campo Nota'
    Mobile.clearText(findTestObject('5_Registro_ACH/EDT_Nota_predeterminada'), 0)

    'Ingresar los datos del campo Nota'
    Mobile.setText(findTestObject('5_Registro_ACH/EDT_Nota_predeterminada'), findTestData('Registro_Beneficiario/Registro_Bsol_Mas_Informacion').getValue(
            7, numRow), 0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el botón Continuar'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Continuar'), 0)

    'Clic en el botón Añadir Beneficiarios'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Anadir_Beneficiario'), 0)

    '10 segundos de espera para que no de error por el código de registro'
    Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

    'Volver a la pantalla de Transferencia para agregar el beneficiario'
    Mobile.tapAtPosition(42, 120)
}

'Menú para salir'
Mobile.tapAtPosition(664, 105)

'5 segundos de espera para que se muestre la información'
Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Clic en la opción salir del menú'
Mobile.tapAtPosition(406, 998)

