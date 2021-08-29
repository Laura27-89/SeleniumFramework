package PageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;


public class Utils {
    public static String generateRandomEmail(){
        String random= RandomStringUtils.randomAlphabetic( 0);
        String dupEmail = random + "@creativa.com";
        System.out.println(dupEmail);
        return dupEmail;
    }
}
