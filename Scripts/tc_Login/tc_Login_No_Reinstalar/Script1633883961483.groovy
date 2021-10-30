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

'Se ejecuta la aplicacion por ID, se coloca false en la reinstalación de la misma'
Mobile.startApplication('D:\\APK\\bsol-preprod.apk', false)

'Se hace clic en el campo usuario'
Mobile.tap(findTestObject('3_Login_No_Reinstalar/EDT_Usuario'), 0)

'Se borran los datos del campo usuario, debido a que los mismos se quedan predeterminados en el campo y si no se borran da error'
Mobile.clearText(findTestObject('3_Login_No_Reinstalar/EDT_Usuario'), 0)

'Se hace clic en el campo usuario, para posicionarse en el mismo y funcione el siguiente keywords'
Mobile.tap(findTestObject('3_Login_No_Reinstalar/EDT_Usuario_Nuevo'), 0)

'Se ingresan los datos del usuario para el ingreso'
Mobile.setText(findTestObject('3_Login_No_Reinstalar/EDT_Usuario_Nuevo'), 'accusys', 0)

'Luego se hace clic en el campo contraseña'
Mobile.tap(findTestObject('3_Login_No_Reinstalar/EDT_Contrasena'), 0)

'Se ingresan los datos del contraseñá para el ingreso'
Mobile.setText(findTestObject('3_Login_No_Reinstalar/EDT_Contrasena'), 'Accusys123*', 0)

'Se cierra el teclado del teléfono para poder ingresar a la aplicación'
Mobile.hideKeyboard()

'Por último se hace clic en el botón ingresar'
Mobile.tap(findTestObject('3_Login_No_Reinstalar/BTN_Ingresar'), 0)

