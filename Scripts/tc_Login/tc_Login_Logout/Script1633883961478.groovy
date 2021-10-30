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

'Ingresa a la aplicación '
Mobile.startApplication('D:\\Users\\MGIAccusys\\Documents\\Respaldo\\Documents\\Banco Sol\\Automatización\\bsol-preprod.apk', 
    true)

'Clic en Continuar (Localización)'
Mobile.tapAtPosition(555, 1310)

'Clic en campo usuario'
Mobile.tap(findTestObject('1_Login/EDT_Usuario'), 0)

'Ingresa el usuario'
Mobile.setText(findTestObject('1_Login/EDT_Usuario'), 'accusys', 0)

'Oculta el teclado del teléfono'
Mobile.hideKeyboard()

'Clic en campo contraseña'
Mobile.tap(findTestObject('1_Login/EDT_Contrasena'), 0)

'Ingresa contraseña'
Mobile.setText(findTestObject('1_Login/EDT_Contrasena'), 'Accusys123*', 0)

'Oculta el teclado del teléfono'
Mobile.hideKeyboard()

'Clic en check de aceptar términos y condiciones'
Mobile.tap(findTestObject('1_Login/CHK_Aceptar_terminos_y_condiciones'), 0)

'Clic en botón ingresar'
Mobile.tap(findTestObject('1_Login/BTN_Ingresar'), 0)

'Clic en Ahora no '
Mobile.tap(findTestObject('1_Login/OPT_ahora_no'), 0)

'5 segundos de espera para que se muestre la ventana'
Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Menú para salir'
Mobile.tapAtPosition(990, 166)

'5 segundos de espera para que se muestre la información'
Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)

'Clic en la opción salir del menú'
Mobile.tapAtPosition(382, 1682)

