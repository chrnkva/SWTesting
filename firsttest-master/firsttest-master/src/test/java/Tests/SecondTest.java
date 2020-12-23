package Tests;

import Pages.LoginPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import Properties.ConfProperties;
import Pages.City;
import java.util.concurrent.TimeUnit;

public class SecondTest {
    public static LoginPage loginPage;
    public static City city;
    public static WebDriver driver;

    @BeforeClass
    public static void setup()
    {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
        city = new City(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("logging"));
    }

    @Test
    public void SecondTest() throws InterruptedException
    {
        city.clickchange();
        city.click(ConfProperties.getProperty("city"));
        String c = city.getname();
        Assert.assertEquals(ConfProperties.getProperty("city"), c);

        loginPage.clickLoginBtnFir();

        loginPage.login(ConfProperties.getProperty("login"));
        loginPage.password(ConfProperties.getProperty("password"));

        Thread.sleep(5000);

        loginPage.clickLoginBtnSec();
        loginPage.usermenu();
        loginPage.myprofile();

        String cityInAddress = city.getaddress();
        Assert.assertEquals(c, cityInAddress);
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
