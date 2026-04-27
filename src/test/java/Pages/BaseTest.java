package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {

    public WebDriver driver;
    Properties pro;

    @BeforeMethod
    public void setup() {
        pro = new Properties();
        try {
            FileInputStream fis = new FileInputStream("./Configurations/config.properties");
            pro.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }

        driver = new ChromeDriver();
        driver.get(pro.getProperty("testUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
