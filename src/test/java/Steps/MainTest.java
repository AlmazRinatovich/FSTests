package Steps;

import Pages.LoginPage;
import Pages.MainPage;
import Pages.Methods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class MainTest {
    public static WebDriver driver;
    public static LoginPage loginPage;
    public static MainPage mainPage;



    @Before

    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "src/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://admin-42-2.stageoffice.ru/");
        File screenshot = ((TakesScreenshot) driver).
                getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();


    }
    @After
    public  void Setup1() {
        driver.quit();}

    @Test
    public void Test1()  {
        loginPage.inputLogin("Autotest@42-2.stageoffice.ru");
        loginPage.inputPass("q1w2e3r4");
        loginPage.clickloginButton();
        Methods.waitSpiner();
     //   Methods.findText("sfg");
        mainPage.createNewuserFind();
       //mainPage.mainUserListFind();
       //mainPage.companyButtonClick();

    }



}
