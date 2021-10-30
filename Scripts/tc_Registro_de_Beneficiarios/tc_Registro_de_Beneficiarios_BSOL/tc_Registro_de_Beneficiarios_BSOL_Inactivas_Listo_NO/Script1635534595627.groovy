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

'En caso de que en el excel exista agregar un nuevo beneficiario se ejecutara'
AgregarNuevo = true

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_Bsol_Inactivas').getRowNumbers(); numRow++) {
    'Cada vez que se agregue un nuevo beneficiario se ejecuta cumpliendo las condiciones establecidas en este script'
    if (AgregarNuevo) {
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_Anadir_beneficiario'), 0)

        Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
    }
    
    'Hace clic en el campo Número de cuenta'
    Mobile.tapAtPosition(50, 491)

    'Borra los datos del campo Número de cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_Cta'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Número de cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_Cta'), findTestData('Registro_Beneficiario/Registro_Bsol_Inactivas').getValue(1, numRow), 
        0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Hace clic en el campo Propietario de la cuenta'
    Mobile.tapAtPosition(47, 604)

    'Borra los datos del campo Propietario de la cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Propietario de la cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario'), findTestData('Registro_Beneficiario/Registro_Bsol_Inactivas').getValue(2, numRow), 
        0)

    'Se cierra el teclado del teléfono para luego hacer clic en el check de la opción favoritos'
    Mobile.hideKeyboard()

    'Clic en el check "Favoritos"'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/CHK_Favorito'), 0)

    'Clic en el botón continuar para registrar el beneficiario'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Continuar'), 0)

    'Se agregaron 2 segundo de retraso para esperar que se agregue el beneficiario'
    Mobile.delay(2)

    'Si existen, algunos de los errores (13001, 15022, 91306, 91521 o 15000) hace clic en el siguiente paso\r\n\r\nEn caso de que no se cumpla esta condición se cumple la siguiente condición " Else"'
    if ((((Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_13001'), 1) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15022'), 1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91306'), 
        1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91521'), 1)) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15000'), 1)) {
        'Si existe algún error del paso anterior, se despliega una ventana con un mensaje, este paso hace clic en el botón cerrar'
        Mobile.tapAtPosition(539, 1215)

        'Se hace clic en este paso en esta opción, para que cuando se ejecute según el archivo de excel, haga clic en el check favoritos y cumplir con el caso'
        Mobile.tap(findTestObject('4_Registro_Banco_Sol/CHK_Favorito'), 0)

        AgregarNuevo = false

           } else {
        'En caso de que no exista errores en el registro en este paso se hace clic en el botón Añadir'
        Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Anadir_Beneficiario'), 0)

        'Se coloco un retraso de 10 segundo para esperar que llegue el código de la transacción'
        Mobile.delay(10)

        'Se hace clic en la flecha de regresar para volver a la pantalla del menú Transferencias'
        Mobile.tapAtPosition(42, 120)

        'Se coloco un retraso de 5 segundo para agregar un nuevo beneficiario, esto según el archivo excel '
        Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

        'Se agrega el nuevo beneficiario, esto es según el archivo de excel'
        AgregarNuevo = true
    }
}

'Se queda en pantalla del menú Transferencias'
Mobile.tapAtPosition(42, 120)

