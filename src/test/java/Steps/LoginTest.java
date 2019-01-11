
package Steps;



import Pages.MainPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.*;

import org.junit.rules.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.allure.annotations.Attachment;


import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public  class LoginTest {
 public static WebDriver driver;
 public static Pages.LoginPage loginPage;
 public static MainPage mainPage;




 @Before

         public  void Setup() {
  System.setProperty("webdriver.chrome.driver", "src/Chromedriver/chromedriver.exe");
  driver = new ChromeDriver();
  loginPage = new Pages.LoginPage(driver);
  mainPage = new MainPage(driver);


  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  driver.get("https://admin-42-2.stageoffice.ru/");
  File screenshot = ((TakesScreenshot) driver).
          getScreenshotAs(OutputType.FILE);
  String path = "./target/screenshots/" + screenshot.getName();


 }
      @After
      public  void Setup1() {
      driver.quit();
       }




 @Epic("Авторизация")
 @Feature("Позитивные тесты")
 @Story(value = "Авторизация по E-mail")
 @Description(value = "Тест проверяет авторизацию, копирайты, выход из приложения")
 @Test
 public void AutEmail()  {
  loginPage.inputLogin("Autotest@42-2.stageoffice.ru");
  loginPage.inputPass("q1w2e3r4");
  Date date = new  Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy");
  WebElement element = driver.findElement(By.xpath("*//SPAN[node() = '© ООО «Новые Облачные Технологии», 2013–']"));
  WebElement element2 = driver.findElement(By.xpath("*//SPAN[node() = '"+ format.format(date) +"']"));
  loginPage.clickloginButton();
  //mainPage.waitSpiner();
  WebElement element1 =driver.findElement(By.xpath("*//A[@href = '/users']/DIV[@class = 'style__AppMenuItem-sc-81kaah-0 FGwSJ' and @data-selected=\"true\"]"));
 // mainPage.mainUserListFind();
  loginPage.clicklogoutButton();
  loginPage.clickloginButton();
  loginPage.clicklogoutButtonNo();
  loginPage.clicklogoutButton();
 loginPage.findText("Выход из приложения");
 loginPage.findText("Вы действительно хотите выйти из приложения?");
  loginPage.clicklogoutButtonYes();
 }

 @Epic("Авторизация")
 @Feature("Позитивные тесты")
 @Story(value = "Страница авторизации")
 @Description(value = "Тест проверяет страницу авторизации на английском и русском языке")
 @Test
 public void Lang() {
  loginPage.inputLogin("Autotest@42-2.stageoffice.ru");
  loginPage.inputPass("q1w2e3r4");
  Date date = new Date();
  SimpleDateFormat format = new SimpleDateFormat("yyyy");
  WebElement element = driver.findElement(By.xpath("*//SPAN[node() = '© ООО «Новые Облачные Технологии», 2013–']"));
  WebElement element2 = driver.findElement(By.xpath("*//SPAN[node() = '" + format.format(date) + "']"));
  WebElement element5 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Восстановление пароля')]"));
  WebElement element6 = driver.findElement(By.xpath("*//LABEL[contains(text(), 'Логин или E-mail')]"));
  WebElement element7 = driver.findElement(By.xpath("*//LABEL[contains(text(), 'Пароль')]"));
  WebElement element11 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Войти')]"));

  WebElement element13 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Восстановление пароля')]"));
  loginPage.langList();
  loginPage.langButtonEn();
  WebElement element3 = driver.findElement(By.xpath("*//SPAN[node() = '© New Cloud Technologies Ltd., 2013–']"));
  WebElement element4 = driver.findElement(By.xpath("*//SPAN[node() = '" + format.format(date) + "']"));
  WebElement element8 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Password recovery')]"));
  WebElement element9 = driver.findElement(By.xpath("*//LABEL[contains(text(), 'Login or Email')]"));
  WebElement element10 = driver.findElement(By.xpath("*//LABEL[contains(text(), 'Password')]"));
  WebElement element12 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Sign in')]"));
  WebElement element14 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Password recovery')]"));

 }

 @Epic("Авторизация")
 @Feature("Позитивные тесты")
 @Story(value = "Кнопка Восстановление пароля")
 @Test
 public void PassRecovery()  {
  loginPage.inputLogin("Autotest");
  loginPage.inputPass("q1w2e3r4!");
  loginPage.passRecoveryButton();
  WebElement element13 = driver.findElement(By.xpath("*//SPAN[contains(text(), 'Восстановление пароля')]"));

 }


 @Epic("Авторизация")
 @Feature("Негативные тесты")
 @Story(value = "Авторизация только по логину (Не E-mail)")
 @Test
 public void AutLogin()  {
  loginPage.inputLogin("Autotest");
  loginPage.inputPass("q1w2e3r4!");
  loginPage.clickloginButton();
  loginPage.clickloginButton();
  loginPage.findText("Неправильно введен логин или пароль!");
// loginPage.clicklogoutButton();
// loginPage.clicklogoutButtonYes();

 }


 @Epic("Авторизация")
 @Feature("Негативные тесты")
 @Story(value = "Авторизация с неправильным логином")
 @Test
 public void invalidLogin()  {
  loginPage.inputLogin("1123");
  loginPage.inputPass("q1w2e3r4");
  loginPage.clickloginButton();
  loginPage.clickloginButton();
  loginPage.findText("Неправильно введен логин или пароль!");
 }


 @Epic("Авторизация")
 @Feature("Негативные тесты")
 @Story(value = "Авторизация с неправильным паролем")
 @Test
 public void invalidPass()  {
  loginPage.inputLogin("Autotest@42-2.stageoffice.ru");
  loginPage.inputPass("1lls;dkflsd;");
  loginPage.clickloginButton();
  loginPage.clickloginButton();
  loginPage.findText("Неправильно введен логин или пароль!");
 // Methods.findText("Неправильно введен логин или пароль!"); нужно доделать обращается к методу статик и падает с ошибкой

 }


 @Epic("Авторизация")
 @Feature("Негативные тесты")
 @Story(value = "Авторизация без логина")
 @Test
 public void NotLogin()
 {
  loginPage.inputPass("1234_5678!");
  WebElement element = driver.findElement(By.xpath("*//BUTTON[@disabled]"));
  loginPage.loginButtonFalse();

 }



 @Epic("Авторизация")
 @Feature("Негативные тесты")
 @Story(value = "Авторизация без пароля")
 @Test
 public void NotPass()  {
  loginPage.inputLogin("Autotest@42-2.stageoffice.ru");
  loginPage.loginButtonFalse();
 // WebElement element = driver.findElement(By.xpath("*//BUTTON[@disabled]"));
 }

}



