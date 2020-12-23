package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class City
{
    public WebDriver driver;
    private WebElement chek;

    public City(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__city")
    private  WebElement city;

    @FindBy(className = "address")
    private WebElement address;

    public void clickchange()
    {
        city.click();
    }

    public String getname()
    {
        String name = city.getText();
        return new String(name.getBytes(StandardCharsets.UTF_8));
    }

    public String getaddress()
    {
        return address.getText().split(",")[0];
    }

    public void click(String city_name)
    {
        chek = driver.findElement(By.partialLinkText(city_name));
        chek.click();
    }
}
