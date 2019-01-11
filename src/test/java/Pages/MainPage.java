package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Steps.LoginTest.driver;
import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class MainPage {


    public MainPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }


  @FindBy(xpath = mainUserList1)
  public WebElement mainUserList;
  final String mainUserList1 = "*//A[@href = '/users']/DIV[@class = 'style__AppMenuItem-sc-81kaah-0 FGwSJ' and @data-selected=\"true\"]";



/// *//A[@href = '/users']/DIV[child::SPAN[contains(text(), 'Пользователи')] and @data-selected="true"]   *//DIV[@class = 'style__MainArea-sc-1yyxyca-1 hXdHlo']
//*//A[@href = '/users']/DIV[@class = 'style__AppMenuItem-sc-81kaah-0 FGwSJ' and @data-selected="true"]

  @FindBy(xpath = "*//DIV[@class = 'style__Spinner-sc-1c5ophd-0 kZUfLr']")
  public WebElement Spiner;
  final String Spiner1 = "*//DIV[@class = 'style__Spinner-sc-1c5ophd-0 kZUfLr']";

  @FindBy(xpath = "*//A[@href = '/users']")
    public WebElement usersButton;

    @FindBy(xpath = newusersButton1)
    public WebElement createNewuser;
    final String newusersButton1 = "*//BUTTON[@class = 'style__Button-sc-1l1xsvh-0 style__LinkButton-w99fwn-0 style__IconLinkButton-sc-10y2iar-0 style__AddIconLinkButton-trgtjn-0 kBANsq']";


    @FindBy(xpath = "*//A[@href = '/groups']")
    public WebElement groupsButton;

    @FindBy(xpath = "*//A[@href = '/domains']")
    public WebElement domainsButton;

    @FindBy(xpath = "*//A[@href = '/file-recovery']")
    public WebElement filerecoveryButton;

    @FindBy(xpath = "*//A[@href = '/company']")
    public WebElement companyButton;







   public void waitSpiner()
   {
       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(Spiner1)));
   }

    public void mainUserListFind()
   {
       mainUserList.findElement(By.xpath(mainUserList1));

   }


    public void usersButtoncClick ()
    {
        usersButton.click();

    }

    public void createNewuserFind()
    {
        createNewuser.findElement(By.xpath(newusersButton1));

    }

    public void createNewuserClick()
    {
        createNewuser.click();

    }

    public void groupsButtonClick ()
    {
        groupsButton.click();

    }
    public void domainsButtonClick ()
    {
        domainsButton.click();

    }
    public void filerecoveryButtonClick ()
    {
        filerecoveryButton.click();

    }
    public void companyButtonClick ()
    {
        companyButton.click();

    }









}
