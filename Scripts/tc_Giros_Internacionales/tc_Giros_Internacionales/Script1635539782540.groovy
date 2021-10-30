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

for (def numRow = 1; numRow <= findTestData('Giros_Internacionales/Giros_Internacionales').getRowNumbers(); numRow++) {
    Mobile.tap(findTestObject('Giros_Nacionales/BTN_Menu'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/ETQ_Transferencias_Internacionales'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Nombre Completo'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Nombre Completo'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            1, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Pais'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Pais'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            2, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Ciudad'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Ciudad'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            3, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Direccion'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Direccion'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            4, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Nro. de Documento'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Nro. de Documento'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            5, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Telefono'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Telefono'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            6, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Correo_electronico'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Correo_electronico'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            7, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Numero de cuenta'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Numero de cuenta'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            8, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Codigo_IBAN'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Codigo_IBAN'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            9, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Nombre de banco'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Nombre de banco'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            10, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Giros_Internacionales1/EDT_Ciudad (1)'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Ciudad (1)'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            11, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Giros_Internacionales1/EDT_Pais (1)'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Pais (1)'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            12, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Codigo Swift'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Codigo Swift'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            13, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Codigo_ABA'), 0)

    Mobile.setText(findTestObject('Object Repository/Giros_Internacionales1/EDT_Codigo_ABA'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            14, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Importe'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Importe'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            15, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Moneda'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/CBB_Opcion'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/Pago por servicios'), 0)

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/CBB_cuenta'), 0)

    if (findTestData('Giros_Internacionales/Giros_Internacionales').getValue(19, numRow) == 'B') {
        Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/CBB_BS'), 0)
    } else {
        Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/CBB_1127700-101-004'), 0)
    }
    
    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/EDT_Nota'), 0)

    Mobile.setText(findTestObject('Giros_Internacionales1/EDT_Nota'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            16, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tap(findTestObject('Object Repository/Giros_Internacionales1/BTN_Continuar'), 0)

    Mobile.delay(10, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(356, 550)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Origen'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Origen'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            17, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)

    Mobile.tapAtPosition(211, 878)

    Mobile.clearText(findTestObject('Giros_Nacionales/EDT_Destino'), 0)

    Mobile.setText(findTestObject('Giros_Nacionales/EDT_Destino'), findTestData('Giros_Internacionales/Giros_Internacionales').getValue(
            18, numRow), 0)

    Mobile.hideKeyboard()

    Mobile.tapAtPosition(370, 1101)

    Mobile.delay(8, FailureHandling.STOP_ON_FAILURE)

    Mobile.swipe(100, 410, 100, 100)

    Mobile.tapAtPosition(378, 1315)

    Mobile.waitForElementPresent(findTestObject('Giros_Internacionales1/IMG_TC'), 50)

    Mobile.pressBack()
}

