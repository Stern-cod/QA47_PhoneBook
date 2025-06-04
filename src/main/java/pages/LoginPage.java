package pages;

import dto.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(
                new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(xpath = "//input[@placeholder='Email']")
    WebElement inputEmail;   // = driver.findElement(By.id("email"))

    @FindBy(xpath = "//input[@name='password']")
    WebElement inputPassword;

    @FindBy(css = "button[name ='login']")
    WebElement btnLoginForm;

    @FindBy(xpath = "//div[@class='login_login__3EHKB']/div")
    WebElement errorMessageLogin;


    public void typeLoginForm(User user){
        inputEmail.sendKeys(user.getUsername());
        inputPassword.sendKeys(user.getPassword());
        btnLoginForm.click();

    }

    public void closeAlert(){
        Alert alert = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public boolean isErrorMassagePresent(String message){
        return isTextElementPresent(errorMessageLogin, message);
    }





}
