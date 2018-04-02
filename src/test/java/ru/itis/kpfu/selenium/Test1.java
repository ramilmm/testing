package ru.itis.kpfu.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Test1 {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.katalon.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void test1() throws Exception {
        driver.get("https://chipolla.ru/");
        driver.findElement(By.linkText("Вход")).click();
        driver.findElement(By.id("input-email")).click();
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys("makhmutov-ramil@inbox.ru");
        driver.findElement(By.id("input-password")).click();
        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys("123321a");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//a[@id='block1-anchor']/div/div/img")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('95', this);\"])[2]")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('91', this);\"])[2]")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('242', this);\"])[2]")).click();
        driver.findElement(By.xpath("(//a[@id='block1-anchor'])[3]")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('202', this);\"])[2]")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('200', this);\"])[2]")).click();
        driver.findElement(By.xpath("(//a[@id='block1-anchor']/div/div/img)[11]")).click();
        driver.findElement(By.xpath("(//button[@onclick=\"cart.add('213', this);\"])[2]")).click();
        driver.findElement(By.xpath("//img")).click();
        driver.findElement(By.linkText("Кабинет")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div[1]/a[1]")).click();
        driver.findElement(By.id("name")).clear();
        driver.findElement(By.id("name")).sendKeys("Vasya");
        driver.findElement(By.id("street")).click();
        driver.findElement(By.id("street")).clear();
        driver.findElement(By.id("street")).sendKeys("Pupkina ulitsa");
        driver.findElement(By.id("house")).click();
        driver.findElement(By.id("house")).clear();
        driver.findElement(By.id("house")).sendKeys("32");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[3]/div[1]/a[2]")).click();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
