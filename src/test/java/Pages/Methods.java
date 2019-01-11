package Pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.qatools.properties.Resource;

import static Steps.MainTest.driver;

public class Methods {


    public static void waitSpiner()
    {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        final String Spiner1 = "*//DIV[@class = 'style__Spinner-sc-1c5ophd-0 kZUfLr']";
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Spiner1)));
    }



    @Step("Проверяем что кнопка неактивна")
    public static void loginButtonFalse ()
    {
        driver.findElement(By.xpath("*//BUTTON[@disabled]"));
    }

    public  void findText(String Text)
    {
        driver.findElement(By.xpath("*//DIV[contains(text(), '"+ Text +"')]"));

    }


}
