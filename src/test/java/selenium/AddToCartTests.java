package selenium;

import PageObjects.BaseClass;
import dataProviders.SearchProvider;
import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import pojo.Products;

public class AddToCartTests extends BaseClass {
    @Description("Validate that add to cart is working")
    @Test
    public void Test_Add_To_Cart_Functionality(){
        int quantity = 5;
        String imageURL = "macbook_1-47x47.jpg";
        String name = homePage().selectFirstProductAndGetName();
        Assert.assertTrue(productPage().isTitleDisplayed(name));
        productPage().SetQuantity(quantity);
        productPage().clickAddButton();
        Assert.assertTrue(productPage().isAlertSuccessDisplayed());
        headerPage().clickOnCartButton();
        try {
            Thread.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(shoppingCartPage().isProductRowDisplayed(name), "Title was not displayed");
        Assert.assertEquals(shoppingCartPage().getProductRowQuantity(), quantity, "Quantity is not matching");
        Assert.assertTrue(shoppingCartPage().getProductImageURL().contains(imageURL), "Image is not the one expected");
    }

    @Description("Validate several items added to the cart")
    @Test
    public void Test_Several_Items_Added_To_The_Cart(){
        homePage().selectProductByName("MacBook");
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        homePage().GoTo();
        homePage().selectProductByName("iPhone");
        productPage().SetQuantity(5);
        productPage().clickAddButton();
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(), 2, "Expected to get 2 rows");
    }

    //Caso de prueba 2 ---> Agregar una orden de compras utilizando la búsqueda para encontrar el producto.
    @Test
    public void Test_Added_To_The_Cart(@Optional("macbook air") String searchCriteria, @Optional("1") String expectedResult){
        homePage();
        productPage().addSearchProduct(searchCriteria);
        productPage().clickOnProductSearched();
        productPage().SetQuantity(2);
        productPage().clickAddButton();
        productPage().SetQuantity(2);
        headerPage().clickOnCartButton();
        Assert.assertEquals(shoppingCartPage().getAmountOfShoppingCartRows(),1);
    }

//Caso de prueba 3 ---> Verificar el precio de un producto en las distintas monedas.

    @Test(dataProvider = "getUsersDataFromJson", dataProviderClass = SearchProvider.class)
    public void Test_Validate_ProductPrice(Products testData) {
        productPage().addSearchProduct(testData.getProduct());
        productPage().clickOnProductSearched();

        headerPage().goToEuroCurrency();
        Assert.assertEquals(testData.getEuroPrice(), Double.parseDouble(productPage().getProductPrice().replace("€","")));

        headerPage().goToPoundSterlingCurrency();
        Assert.assertEquals(testData.getPoundSterlingPrice(), Double.parseDouble(productPage().getProductPrice().replace("£","")));

        headerPage().goToDollarCurrency();
        Assert.assertEquals(testData.getDollarsPrice(), Double.parseDouble(productPage().getProductPrice().replace("$","")));
    }
}