package ru.LitecartLocalhost;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogScript {
    private WebDriver driver;
    private WebDriverWait wait;
    private int appMenu;
    private int docs;
    private String pageName;

    @Test
    public void liteCart() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.manage().window().maximize();
        driver.get("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("remember_me")).click();
        driver.findElement(By.name("login")).click();

       appMenu = driver.findElements(By.cssSelector("ul#box-apps-menu li#app-")).size();

         for (int i = 1; i <= appMenu; i++) {

            WebElement element = refresh(i);
            pageName = element.findElement(By.xpath(".//span[@class='name']")).getText();
            element.click();
            element = refresh(i);
            docs = element.findElements(By.xpath("./ul[@class='docs']/li[@id]")).size();

            if (docs > 0) {
                for (int x = 1; x <= docs; x++) {
                    element = refresh(i);
                    WebElement element1 = element.findElement(By.xpath("./ul[@class='docs']/li[@id][" + x + "]"));
                    pageName = element1.findElement(By.xpath(".//span[@class='name']")).getText();
                    element1.click();
                }
            } else {
            }
        }
    }
    private WebElement refresh(int i) {
        WebElement element = driver.findElement(By.id("box-apps-menu"));
        WebElement element1 = element.findElement(By.xpath("./li[@id='app-'][" + i + "]"));
        return element1;
    }
}

