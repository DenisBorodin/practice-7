package ru.LitecartLocalhost;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
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

        ArrayList<String> list = new ArrayList<>();
        List<WebElement> appMenu = driver.findElements(By.id("box-apps-menu"));
        List<WebElement> elements = appMenu.get(0).findElements(By.id("app-"));

        for (WebElement element : elements) {
            list.add(element.getText());
        }
        for (int i = 0; i < elements.size(); i++) {
            driver.findElement((By.linkText(list.get(i)))).click();

                ArrayList<String> listSecond = new ArrayList<>();
                List<WebElement> smallElements = driver.findElements(By.xpath("//ul[@class='docs']/li"));

                if (smallElements.size() > 0) {
                    for (WebElement element1 : smallElements) {
                        listSecond.add(element1.getText());
                    }

                    for (int x = 0; x < listSecond.size(); x++) {
                        driver.findElement(By.linkText(listSecond.get(x))).click();
                    }
                }
            }
            driver.quit();
            driver = null;
        }
    }

