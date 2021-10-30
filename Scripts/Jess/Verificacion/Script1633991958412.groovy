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

Mobile.startExistingApplication('tsmbo.bancosolapk.presentacion.preprod', FailureHandling.STOP_ON_FAILURE)

Mobile.tap(findTestObject('Object Repository/Cobros_QR/CheckBox1'), 0)

Mobile.delay(100)

//Mobile.tap(findTestObject('Object Repository/Giros_Nacionales/TXT_Nro_Doc_Attributes'), 0)
//Mobile.setText(findTestObject('Object Repository/Giros_Nacionales/TXT_Nro_Doc_Attributes'), '123456', 0)

for (def index : (0..2)) {
	switch(index.toString()) {
		case '0':
		WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Cobros_QR/BTN_Pagos_QR'), 0)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		for (def numRow = 1; numRow <= 1; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
		   
		
			Mobile.pressBack()
		}
		Mobile.closeApplication()
		break
		case '1':
		WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Cobros_QR/BTN_Pagos_QR'), 0)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		for (def numRow = 2; numRow <= 2; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
			if (Mobile.waitForElementPresent(findTestObject('Object Repository/Cobros_QR/MSG_Formato_Invalido'), 1)) {
			
				Mobile.tap(findTestObject('Object Repository/Cobros_QR/MSG_Formato_Invalido'), 0)
		
				Mobile.pressBack()
			}
		}
		Mobile.closeApplication()
		break
		case '2':
		WebUI.callTestCase(findTestCase('tc_Login/tc_Login_No_Reinstalar'), [:], FailureHandling.STOP_ON_FAILURE)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		Mobile.tap(findTestObject('Cobros_QR/BTN_Pagos_QR'), 0)
		
		Mobile.delay(3, FailureHandling.STOP_ON_FAILURE)
		
		for (def numRow = 3; numRow <= 3; numRow++) {
			Mobile.tapAtPosition(416, 305)
		
			Mobile.delay(5, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.tapAtPosition(430, 322)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Importe'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Importe'), findTestData('Cobro_QR_Mensajes').getValue(1, numRow), 0)
		
			Mobile.hideKeyboard()
			
			Mobile.tapAtPosition(674, 582)
		
			Mobile.tap(findTestObject('Object Repository/Cobros_QR/CBB_884187-000-001'), 0)
		
			Mobile.tapAtPosition(113, 702)
		
			Mobile.clearText(findTestObject('Cobros_QR/EDT_Nota'), 0)
		
			Mobile.setText(findTestObject('Cobros_QR/EDT_Nota'), findTestData('Cobro_QR_Mensajes').getValue(4, numRow), 0)
		
			Mobile.tap(findTestObject('Cobros_QR/BTN_Continuar'), 0)
		
			Mobile.hideKeyboard()
		
			if (Mobile.waitForElementPresent(findTestObject('Object Repository/Cobros_QR/MSG_Sin_Informacion'), 1)) {
				Mobile.tap(findTestObject('Object Repository/Cobros_QR/MSG_Sin_Informacion'), 0)
			}
			
			Mobile.delay(2, FailureHandling.STOP_ON_FAILURE)
		
			Mobile.pressBack()
		}
		Mobile.closeApplication()
		break
	}
}

Mobile.delay(1000)

//Mobile.tapAtPosition(120, 885)


//FECHA

String[] fechaActual = new Date().format('dd/MM/yyyy').toString().split('/')

String[] fechaRegistro = '24/11/2021'.split('/')

if ((fechaRegistro[2]).toInteger() == (fechaActual[2]).toInteger()) {
    //SI EL MES DE LA FECHA DEL REGISTRO ES IGUAL AL MES ACTUAL
    if ((fechaRegistro[1]).toInteger() == (fechaActual[1]).toInteger()) {
        if ((fechaActual[0]).toInteger() == 1) {
            //SWIPE PARA IR AL PRIMER MES
            for (def index : (0..4)) {
                Mobile.swipe(360, 1130, 360, 1300)
            }
            
            Mobile.swipe(360, 1308, 360, 1250) //SWIPE PARA IR AL PRIMER MES
        } else {
            for (def index : (0..4)) {
                Mobile.swipe(360, 1130, 360, 1300)
            }
        }
        
        //SI EL DIA ACTUAL ES MAYOR AL DIA DEL REGISTRO
        if ((fechaActual[0]).toInteger() > (fechaRegistro[0]).toInteger()) {
            //SI LA RESTA DEL DIA ACTUAL MENOS EL DIA DEL REGISTRO ES = A 1
            //ESTÁ PERMITIDO DE LO CONTRARIO NO LO PERMITE EL BANCO
            if (((fechaActual[0]).toInteger() - (fechaRegistro[0]).toInteger()) == 1) {
                //SWIPE PARA IR AL PRIMER DIA
                for (def index : (0..6)) {
                    Mobile.swipe(120, 1130, 120, 1300)
                }
            }
            //DE LO CONTRARIO SI EL DIA ACTUAL ES MENOR AL DIA DEL REGISTRO
            //SWIPE PARA IR AL PRIMER DIA
        } else {
            for (def index : (0..6)) {
                Mobile.swipe(120, 1130, 120, 1300)
            }
            
            for (def index : (0..(fechaRegistro[0]).toInteger() - (fechaActual[0]).toInteger())) {
                Mobile.swipe(120, 1308, 120, 1250)
            }
        }
    }
    
    //SI EL MES DEL REGISTRO ES MENOR AL MES ACTUAL
    if ((fechaRegistro[1]).toInteger() < (fechaActual[1]).toInteger()) {
        if ((((fechaActual[0]).toInteger() == 28) || ((fechaActual[0]).toInteger() == 30)) || ((fechaActual[0]).toInteger() == 
        31)) {
            //SWIPE PARA IR AL PRIMER MES
            for (def index : (0..4)) {
                Mobile.swipe(360, 1130, 360, 1300)
            }
        }
    }
    
    //SI EL MES ES MAYOR AL MES ACTUAL
    if ((fechaRegistro[1]).toInteger() > (fechaActual[1]).toInteger()) {
        //SWIPE PARA IR AL PRIMER MES
        for (def index : (0..4)) {
            Mobile.swipe(360, 1130, 360, 1300)
        }
        
        for (def index : (1..(fechaRegistro[1]).toInteger() - (fechaActual[1]).toInteger())) {
            Mobile.swipe(360, 1308, 360, 1250)
        }
        
        //SWIPE PARA IR AL PRIMER DIA
        for (def index : (0..6)) {
            Mobile.swipe(120, 1130, 120, 1300)
        }
        
        for (def index : (1..(fechaRegistro[0]).toInteger() - 1)) {
            Mobile.swipe(120, 1308, 120, 1250)
        }
    }
    
    Mobile.tapAtPosition(635, 1025)
}

if ((fechaRegistro[2]).toInteger() > (fechaActual[2]).toInteger()) {
    //SWIPE AL AÑO DEL REGISTRO
    for (def index : (0..4)) {
        Mobile.swipe(600, 1130, 600, 1300)
    }
    
    for (def index : (1..(fechaRegistro[2]).toInteger() - (fechaActual[2]).toInteger())) {
        Mobile.swipe(600, 1308, 600, 1250)
    }
    
    //SWIPE AL MES DEL REGISTRO
    for (def index : (0..4)) {
        Mobile.swipe(360, 1130, 360, 1300)
    }
    
    for (def index : (1..(fechaRegistro[1]).toInteger() - 1)) {
        Mobile.swipe(360, 1308, 360, 1250)
    }
    
    //SWIPE AL DIA DEL REGISTRO
    for (def index : (0..6)) {
        Mobile.swipe(120, 1130, 120, 1300)
    }
    
    for (def index : (1..(fechaRegistro[0]).toInteger() - 1)) {
        Mobile.swipe(120, 1308, 120, 1250)
    }
    
    Mobile.tapAtPosition(635, 1025)
}

//FECHA

