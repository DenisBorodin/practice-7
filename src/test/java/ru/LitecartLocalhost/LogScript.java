package ru.LitecartLocalhost;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LogScript {
    private WebDriver driver;
    private WebDriverWait wait;

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
        List<WebElement> appMenu = driver.findElements(By.id("box-apps-menu"));
        List<WebElement> elements = appMenu.get(0).findElements(By.id("app-"));

        for (int i = 0; i < elements.size(); i++) {
            appMenu = driver.findElements(By.id("box-apps-menu"));
            elements = appMenu.get(0).findElements(By.id("app-"));
            elements.get(i).click();
        }
        driver.quit();
        driver = null;
    }
}
