package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{

    //elementos
    public String ProductTitleSelector = "//h1[text()='<name>']";
    public By ProductQuantityInputSelector = By.id("input-quantity");
    public By AddButtonSelector = By.id("button-cart");
    public By addSearchProductLocator = By.name("search");
    public By clickOnSearchProductLocator = By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img");
    public By ProductPriceLocator = By.xpath("(//h2)[2]");
    public By AlertSuccess = By.cssSelector(".alert-success");

    public ProductPage(WebDriver _driver){
        super(_driver);
    }

    public boolean isTitleDisplayed(String name){
        return driver.findElement(By.xpath(ProductTitleSelector.replace("<name>", name))).isDisplayed();
    }

    public void SetQuantity(int quantity){
        driver.findElement(ProductQuantityInputSelector).clear();
        driver.findElement(ProductQuantityInputSelector).sendKeys("" + quantity);
    }

    public void clickAddButton(){
        driver.findElement(AddButtonSelector).click();
    }

    public boolean isAlertSuccessDisplayed(){
        return driver.findElement(AlertSuccess).isDisplayed();
    }

    public void addSearchProduct (String _item) {
        driver.findElement(addSearchProductLocator).sendKeys(_item,Keys.ENTER);
    }
    public void clickOnProductSearched(){
        driver.findElement(clickOnSearchProductLocator).click();
    }

    public String getProductPrice (){
        return driver.findElement(ProductPriceLocator).getText();
    }
}