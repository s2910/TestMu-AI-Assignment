package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonPage {
    WebDriver driver;

    public AmazonPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterSearch(String product){
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchBox.sendKeys(product);
        searchBox.submit();
    }

    public void clickFirstProduct(){
        WebElement firstProduct = driver.findElement(
                By.xpath("(//a[@class='a-link-normal s-line-clamp-2 puis-line-clamp-3-for-col-4-and-8 s-link-style a-text-normal'])[1]")
        );

        firstProduct.click();


    }

    public String getPrice(){
        String price = driver.findElement(By.cssSelector("span[class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay apex-pricetopay-value'] span[class='a-price-whole']")).getText();
        return price;
    }

    public void clickAddToCart(){
        WebElement addToCart = driver.findElement(By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//div[@id='addToCart_feature_div']//div//input[@id='add-to-cart-button']"));
        addToCart.click();
    }
}
