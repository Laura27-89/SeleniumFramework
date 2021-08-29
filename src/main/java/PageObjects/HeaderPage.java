package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderPage extends BasePage{

    //Elementos
    private By myAccountLinkLocator = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a/span[1]");
    private By loginButtonLocator = By.linkText("Login");
    private By registerButtonLocator = By.linkText("Register");
    private By shoppingCartLocator = By.linkText("Shopping Cart");
    private By yourStoreButtonLocator = By.linkText("Your Store");

    //Seccion de Verificar el precio de un producto en las distintas monedas.

    private By CurrencyButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/button/span");
    private By EuroButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[1]/button");
    private By PoundSterlingButtonLocator =  By.xpath("//*[@id=\"form-currency\"]/div/ul/li[2]/button");
    private By DollarButtonLocator = By.xpath("//*[@id=\"form-currency\"]/div/ul/li[3]/button");

    public HeaderPage(WebDriver _driver){
        super(_driver);
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccountLinkLocator).click();
    }
    public void clickOnLoginButton(){
        driver.findElement(loginButtonLocator).click();
    }
    public void clickOnRegisterButton(){
        driver.findElement(registerButtonLocator).click();
    }
    public void clickOnCartButton(){
        driver.findElement(shoppingCartLocator).click();
    }

    public void clickOnYourStoreButton() {driver.findElement(yourStoreButtonLocator).click();}
    public void clickOnCurrencyButton() {driver.findElement(CurrencyButtonLocator).click();}
    public void clickOnEuroButton() {driver.findElement(EuroButtonLocator).click();}
    public void clickOnPoundSSterlingButton() {driver.findElement(PoundSterlingButtonLocator).click();}
    public void clickOnDollarButton() {driver.findElement(DollarButtonLocator).click();}

    public void goToEuroCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnEuroButton();
    }

    public void goToPoundSterlingCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnPoundSSterlingButton();
    }

    public void goToDollarCurrency(){
        HeaderPage headerPage = new HeaderPage(driver);
        headerPage.clickOnCurrencyButton();
        headerPage.clickOnDollarButton();
    }

}