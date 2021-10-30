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

Mobile.startApplication('D:\\Users\\MGIAccusys\\Documents\\Respaldo\\Documents\\Banco Sol\\Automatización\\bsol-preprod.apk', 
    false)

'Este caso no se puede automatizar, debido a que el fin de los mismos es evitar que bots intenten romper la seguridad y hackear la información de los clientes, es importante resaltar que Katalon Studio funciona similarmente a un robot'
Mobile.tap(findTestObject('2_Olvido_contraseña/EDT_Olvide_Contrasena'), 0)

Mobile.tap(findTestObject('2_Olvido_contraseña/EDT_Nombre_de_usuario'), 0)

Mobile.hideKeyboard()

Mobile.setText(findTestObject('2_Olvido_contraseña/EDT_Nombre_de_usuario'), 'accusys', 0)

Mobile.tap(findTestObject('2_Olvido_contraseña/BTN_Continuar'), 0)

