package Pages;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.sql.Driver;


public class LoginPage {


   

    public LoginPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    /// Здесь перечислены локаторы элементов
    @FindBy(xpath = "*//INPUT[following-sibling::LABEL[contains(text(), 'Логин')]]")
    public WebElement loginField;

    @FindBy(xpath = "*//INPUT[following-sibling::LABEL[contains(text(), 'Пароль')]]")
    public WebElement passField;

    @FindBy(xpath = "*//BUTTON[child::SPAN[contains(text(), 'Войти')]]")
    public WebElement loginButton;

    @FindBy(xpath = "*//BODY[1]")
     public WebElement loginButtonfalse;
      final  String buttonFalse = "*//BUTTON[@disabled]";


    @FindBy(xpath = "*//BUTTON[@class = 'style__Button-sc-1l1xsvh-0 style__IconButton-sc-1s4yozz-0 style__AppSidebarExitButton-s5n02e-0 jmMJNx']")
    public WebElement logoutButton;

    @FindBy(xpath = "*//BUTTON[contains(text(), 'Выйти')]")
    public WebElement outbuttonYES;

    @FindBy(xpath = "*//BUTTON[contains(text(), 'Выйти')]")
    public WebElement outbuttonYes;

    @FindBy(xpath = "*//BUTTON[contains(text(), 'Отмена')]")
    public WebElement outbuttonNo;

    @FindBy(xpath = "*//DIV[@class = 'style__Dropdown-sc-6o0qbs-0 fnQaUL']")
    public WebElement langButton;

    @FindBy(xpath = "*//BUTTON[@class = 'style__Button-sc-1l1xsvh-0 style__Item-sc-6o0qbs-3 iiEtLA']")
    public WebElement langButtonRu;

    @FindBy(xpath = "*//BUTTON[child::SPAN[contains(text(), 'English')]]")
    public WebElement langButtonEn;


    @FindBy(xpath = "*//SPAN[contains(text(), 'Восстановление пароля')]")
    public WebElement passRecoveryButton;

    @FindBy(xpath = "*//BODY[1]")
    public WebElement findText;




/// Тут методы к элементам
@Step("Ищем текст {Text}")
    public void findText (String Text)
    {
        findText.findElement(By.xpath("*//DIV[contains(text(), '"+ Text +"')]"));

    }
@Step("Нажимаем Восстановление пароля")
    public void passRecoveryButton () {
        passRecoveryButton.click();
    }
    @Step("Нажимаем Выбор языка")
    public void langList () {
        langButton.click();
    }
    @Step("Выбираем русский")
    public void langButtonRu () {
        langButtonRu.click();
    }
    @Step("Выбираем английский")
    public void langButtonEn () {
        langButtonEn.click();
    }
    @Step("Вводим логин")
    public void inputLogin (String login)
    {
        loginField.sendKeys(login);
    }
    @Step("Вводим пароль")
    public void inputPass (String pass)
    {
        passField.sendKeys(pass);
    }
    @Step("Нажимаем войти")
    public void clickloginButton ()
    {
        loginButton.click();
    }

    @Step("Проверяем что кнопка неактивна")
    public void loginButtonFalse ()
    {
        loginButtonfalse.findElement(By.xpath(buttonFalse));
    }

    @Step("Нажимаем выйти")
    public void clicklogoutButton ()
    {
        logoutButton.click();
    }
    @Step("Подтверждаем выход")
    public void clicklogoutButtonYes ()
    {
        outbuttonYes.click();
    }
    @Step("Не Подтверждаем выход")
    public void clicklogoutButtonNo ()
    {
        outbuttonNo.click();
    }




}
