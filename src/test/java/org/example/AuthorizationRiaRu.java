package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;


public class AuthorizationRiaRu extends BaseTest {
    WebDriver driver = DriverManager.getDriver();

    public void login() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ria.ru");

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.id("modalAuthEmailField")).sendKeys(getLog());
        driver.findElement(By.id("modalAuthPassword")).sendKeys(getPwd());
        driver.findElement(By.cssSelector("[tabindex='12']")).click();

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.id("profileLogout")).click();
    }

    public void recoverPwd() throws InterruptedException {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ria.ru");

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.cssSelector("[data-modal-open='recovery_password']")).click();
        Thread.sleep(500);
        WebElement element = driver.findElement(By.id("modalRecoveryPasswordEmail"));
        element.sendKeys(getLog());
        driver.findElement(By.xpath("//button[text()='Продолжить']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Готово']")).sendKeys(Keys.TAB, Keys.ENTER);

        driver.get("https://mail.ru");

        driver.findElement(By.xpath("(//button[text()='Войти'])[2]")).click();
        driver.findElement(By.name("username")).sendKeys(getLog());
        driver.findElement(By.xpath("//span[text()='Ввести пароль']/..")).click();
        driver.findElement(By.name("password")).sendKeys(getPwd());
        driver.findElement(By.xpath("//span[text()='Войти']/..")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@title='РИА Новости <robot@rian.ru>']/../../../..")).click();

        Thread.sleep(500);
        driver.findElement(By.xpath("//div[text()='Чтобы восстановить пароль, пожалуйста, пройдите по ссылке ниже, нажав на неё или скопировать её в адресную строку браузера: ']"));
        driver.findElement(By.cssSelector("[title='Удалить']")).click();
        driver.findElement(By.cssSelector(".ph-project__user-name")).click();
        driver.findElement(By.xpath("//div[text()='Выйти']")).click();
    }

    public void wrongAuthorization() {
        driver.get("https://ria.ru");

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.id("modalAuthEmailField")).sendKeys(getWrongLog());
        driver.findElement(By.id("modalAuthPassword")).sendKeys(getWrongPwd());
        driver.findElement(By.cssSelector("[tabindex='12']")).click();
        driver.findElement(By.xpath("//div[text()='Неправильный логин или пароль']")).click();
        driver.findElement(By.cssSelector(".modal__close use")).click();
    }

    public void wrongLogin() {
        driver.get("https://ria.ru");

        driver.findElement(By.xpath("//a[@class='header__menu-button header__menu-login']")).click();
        driver.findElement(By.id("modalAuthEmailField")).sendKeys(getWrongPwd());
        driver.findElement(By.id("modalAuthPassword")).sendKeys(getWrongPwd());
        driver.findElement(By.xpath("//div[text()='Проверьте адрес почты']"));
        driver.findElement(By.cssSelector(".modal__close use")).click();

        driver.close();
        driver.quit();
    }
}
