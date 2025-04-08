import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class RegistrationTests {
    private final By ACCEPT_COOKIES_BTN = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");
    private final By REGISTRATION_BTN = By.xpath(".//strong[@class = 'user-block__title--strong']");
    private final By REGISTRATION_LINK = By.xpath(".//p[@class = 'users-session-form__signup']/a");
    private final By FIRST_NAME = By.id("user_first_name");
    private final By LAST_NAME = By.id("user_last_name");
    private final By EMAIL = By.id("user_email");
    private final By PASSWORD = By.id("user_password");
    private final By PASSWORD_CONFIRM = By.id("user_password_confirmation");
    private final By MARKETING_CHECKBOX = By.id("user_marketing_consent_1");
    private final By INFORMATION_CHECKBOX = By.id("user_marketing_consent_2");
    private final By REGISTER_BTN = By.name("commit");
    private final By ERROR_MSG = By.xpath(".//[@class ='users-session-form__error-message']");

    private final String PASSWORD_COMPLEXITY_ERROR = "parolei jāsatur vismaz viens skaitlis, mazā burti, lielā burti un īpašais simbols";
    private final String PASSWORD_MATCH_ERROR = "nesakrīt ar apstiprinājumu";

    @Test
    public void passwordInconsistencyTest() {
        //Open Browser window
        WebDriver browser = new ChromeDriver();
        browser.manage().window().maximize();
        
        //Open Home Page
        browser.get("http://1a.lv");

        //Accept cookies
  //      WebElement acceptCookiesBtn = browser.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
  //      acceptCookiesBtn.click();

  //      WebElement acceptCookiesBtn = browser.findElement(ACCEPT_COOKIES_BTN);
  //        acceptCookiesBtn.click();

        browser.findElement(ACCEPT_COOKIES_BTN).click();


        //Press Registration btn
  //     WebElement registrationBtn = browser.findElement(By.xpath(".//strong[@class = 'user-block__title--strong']"));
  //      registrationBtn.click();


  //      WebElement registrationBtn = browser.findElement(REGISTRATION_BTN);
 //       registrationBtn.click();

       browser.findElement(REGISTRATION_BTN).click();
       

        //Click registration link
 //      browser.findElement(REGISTRATION_LINK).click();
        WebElement registrationLink = browser.findElement(REGISTRATION_LINK);

        Actions actions = new Actions(browser);
        actions.scrollToElement(registrationLink);
        actions.perform();

        registrationLink.click();


        //Enter First Name
        browser.findElement(FIRST_NAME).sendKeys("Dilyara");

        //Enter Last Name
        browser.findElement(LAST_NAME).sendKeys("Tester");

        //Enter E-mail
        browser.findElement(EMAIL).sendKeys("Dilyarasavela13@gmail.com");

        //Enter Password
        browser.findElement(PASSWORD).sendKeys("qfers12345!");

        //Enter Password again with mistake
        browser.findElement(PASSWORD_CONFIRM).sendKeys("qfers12345");

        //Scroll to the Registration btn
        WebElement registationBtn = browser.findElement(REGISTER_BTN);
        actions.scrollToElement(registationBtn);
        actions.perform();



        //Select marketing check-box
        browser.findElement(MARKETING_CHECKBOX).click();

        //Select information check-box
        browser.findElement(INFORMATION_CHECKBOX).click();

        //Press Registration button
        registationBtn.click();

        //Check wrong password error message
        List<WebElement> errorMessages = browser.findElements(ERROR_MSG);
        Assertions.assertEquals(2, errorMessages.size(), "Wroug error amount!");
        Assertions.assertEquals(PASSWORD_COMPLEXITY_ERROR,errorMessages.get(0).getText(),"Error msg!");
        Assertions.assertEquals(PASSWORD_MATCH_ERROR, errorMessages.get(1).getText(),"Error msg!");

    }
}
