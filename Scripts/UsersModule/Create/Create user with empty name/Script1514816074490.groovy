import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.callTestCase(findTestCase('UsersModule/Enter Users Module'), [:], FailureHandling.STOP_ON_FAILURE)

WebUiBuiltInKeywords.delay(GlobalVariable.Delay)

'Добавляем нового пользователя'
WebUI.click(findTestObject('GIAP-DC/UserModule/AddUser'))

WebUiBuiltInKeywords.delay(GlobalVariable.Delay)

'Проверяем заголовок окна'
WebUI.verifyTextPresent('Добавление пользователя', false)

'Закрываем окно'
WebUI.click(findTestObject('GIAP-DC/UserModule/CancelButton'))

WebUiBuiltInKeywords.delay(GlobalVariable.Delay)

'Добавлям нового пользователя без имени'
WebUI.click(findTestObject('GIAP-DC/UserModule/AddUser'))

'Нажимаем кнопку Добавить'
WebUI.click(findTestObject('GIAP-DC/UserModule/Add'))

'Проверяем наличие ошибки'
WebUI.verifyElementPresent(findTestObject('GIAP-DC/UserModule/Error'), 5)

WebUI.closeBrowser()

