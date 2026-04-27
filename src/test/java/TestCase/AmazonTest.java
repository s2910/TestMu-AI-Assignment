package TestCase;

import Pages.AmazonPage;
import Pages.BaseTest;
import org.testng.annotations.Test;
import java.util.Set;

public class AmazonTest extends BaseTest {

    @Test(priority = 0)
    public void iPhoneTestCase() throws InterruptedException {
        AmazonPage amazonPage = new AmazonPage(driver);

        amazonPage.enterSearch("iPhone");
        amazonPage.clickFirstProduct();

        Set<String> windows = driver.getWindowHandles();
        for(String win : windows){
            driver.switchTo().window(win);
        }

        System.out.println("Product Price: " + amazonPage.getPrice());
        amazonPage.clickAddToCart();
    }

    @Test(priority = 1)
    public void galaxyTestCase(){
        AmazonPage amazonPage = new AmazonPage(driver);

        amazonPage.enterSearch("Galaxy");
        amazonPage.clickFirstProduct();

        Set<String> windows = driver.getWindowHandles();
        for(String win : windows){
            driver.switchTo().window(win);
        }

        System.out.println("Product Price: " + amazonPage.getPrice());
        amazonPage.clickAddToCart();
    }
}
