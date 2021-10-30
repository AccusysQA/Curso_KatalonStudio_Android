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

'En caso de que en el excel exista agregar un nuevo beneficiario se ejecutará'
AgregarNuevo = true

'Se repite el ciclo según lo configurado en el script y el archivo excel'
for (def numRow = 1; numRow <= findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getRowNumbers(); numRow++) {
    'Cada vez que se agregue un nuevo beneficiario se ejecuta cumpliendo las condiciones establecidas en este script'
    if (AgregarNuevo) {
        'Clic en el botón Añadir beneficiario'
        Mobile.tap(findTestObject('5_Registro_ACH/BTN_Anadir_beneficiario'), 0)

        'Clic en el check Favoritos'
        Mobile.tap(findTestObject('4_Registro_Banco_Sol/CHK_Favorito'), 0)
    }
    
    'Se colocó un retraso de 2 segundos para que cuando se agregue cada unos de los beneficiarios establecidos en el script consigan el campo correcto y no falle la prueba'
    Mobile.delay(3)

    'Hace clic en el campo Número de cuenta'
    Mobile.tapAtPosition(50, 491)

    'Borra los datos del campo Número de cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_Cta'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Número de cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Numero_Cta'), findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(1, numRow), 
        0)

    'Se cierra el teclado del teléfono para pasar al siguiente campo'
    Mobile.hideKeyboard()

    'Hace clic en el campo Propietario de la cuenta'
    Mobile.tapAtPosition(47, 604)

    'Borra los datos del campo Propietario de la cuenta, para ejecutar varios registros'
    Mobile.clearText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario'), 0)

    'Ingresa los datos, según el archivo excel configurado, en el campo Propietario de la cuenta'
    Mobile.setText(findTestObject('4_Registro_Banco_Sol/EDT_Propietario'), findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(2, numRow), 
        0)

    'Se cierra el teclado del teléfono '
    Mobile.hideKeyboard()

    'Clic en el botón continuar para registrar el beneficiario'
    Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Continuar'), 0)

    Mobile.delay(2)

    'Si existen, algunos de los errores (13001, 15022, 91306, 91521 o 15000) hace clic en el siguiente paso\r\n\r\nEn caso de que no se cumpla esta condición se cumple la siguiente condición " Else"'
    if ((((Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_13001'), 1) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15022'), 1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91306'), 
        1)) || Mobile.waitForElementPresent(findTestObject('4_Registro_Banco_Sol/MSG_91521'), 1)) || Mobile.waitForElementPresent(
        findTestObject('4_Registro_Banco_Sol/MSG_15000'), 1)) {
        'Si existe algún error del paso anterior, se despliega una ventana con un mensaje, este paso hace clic en el botón cerrar'
        Mobile.tapAtPosition(539, 1215)

        'Se retrasa un segundo para luego ejecutar el siguiente paso'
        Mobile.delay(1)

        AgregarNuevo = false
    } else {
        'En caso de que no exista errores en el registro en este paso se hace clic en el botón Añadir'
        Mobile.tap(findTestObject('4_Registro_Banco_Sol/BTN_Anadir_Beneficiario'), 0)

        'Se colocó un retraso de 10 segundos para esperar que aparezca el siguiente campo'
        Mobile.delay(10)

        'Este paso espera 50 segundos hasta que aparezca el objeto configurado'
        Mobile.waitForElementPresent(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), 
            50)

        'Se clic en el campo importe'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), 0)

        'Se espera un segundo para realizar el siguiente paso'
        Mobile.delay(1)

        'Se ingresan los datos del importe según el archivo excel'
        Mobile.setText(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Importe'), findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(
                4, numRow), 0)

        'Luego se oculta el teclado'
        Mobile.hideKeyboard()

        'Se retrasa un segundo para luego ejecutar el siguiente paso'
        Mobile.delay(1)

        'Se colocaron dos casos\r\n\r\n1. Si en el archivo de excel en la columna configurada obtiene el dato B (Selecciona la moneda Bolivianos)\r\n2. Si en el archivo de excel en la columna configurada obtiene el dato S (Selecciona la moneda Dólares)'
        switch (findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(5, numRow).trim()) {
            case 'B':
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Bs'), 0)

                break
            case 'S':
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Dlrs'), 0)

                break
        }
        
        'Se coloco un retraso de un segundo para cumplir con el siguiente paso'
        Mobile.delay(1)

        'Luego hace clic en el campo seleccionar cuenta'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/CBO_Seleccionar_Cuenta'), 0)

        'Se coloco un retraso de un segundo para seleccionar la opción correcta según lo indicado en el switch y en lo establecido en el archivo excel'
        Mobile.delay(1)

        'En esta condición va a seleccionar la cuenta establecida en el archivo excel según cada condición'
        switch (findTestData('Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(6, numRow).toBigInteger()) {
            case 1127700000003:
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/ITM_1127700000003'), 0)

                break
            case 1127700101002:
                Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/ITM_1127700101002'), 0)

                break
        }
        
        'Se retrasa un segundo para luego ejecutar el siguiente paso'
        Mobile.delay(1)

        'Se hace clic en campo Nota'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Nota_Opc'), 0)

        'Se retrasa un segundo para luego ejecutar el siguiente paso'
        Mobile.delay(1)

        'Se ingresa el dato en el campo Nota según el archivo excel configurado'
        Mobile.setText(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/TXT_Nota_Opc'), findTestData(
                'Registro_Beneficiario/Registro_Bsol_Transferencias').getValue(7, numRow), 0)

        'Se cierra el teclado'
        Mobile.hideKeyboard()

        'Luego se hace clic en continuar'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Continuar'), 0)

        'Se retrasa un segundo para luego ejecutar el siguiente paso'
        Mobile.delay(1)

        'Clic en botón transferir'
        Mobile.tap(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/BTN_Transferir'), 0)

        'Espera a que se visualice este objeto'
        Mobile.waitForElementPresent(findTestObject('Object Repository/4_Registro_Banco_Sol/Segundo Paso/IMG_Exitoso'), 
            50)

        AgregarNuevo = true

        'Se retrasa dos segundos para luego ejecutar el siguiente paso'
        Mobile.delay(2)

        'Se presiona atrás'
        Mobile.pressBack()
    }
}

'Se queda en pantalla del menú Transferencias'
Mobile.tapAtPosition(42, 120)

