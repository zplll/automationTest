package com.zipon.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author kin
 * @version $: v 0.1 2016/9/30 Exp $$
 */
public class ManagerWebAutomation {

    public static WebDriver driverConf(String browser){
        WebDriver driver = null;
        if(browser.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\kin\\Documents\\Tencent Files\\1418641603\\FileRecv\\chromeDriver.exe");
            driver=new ChromeDriver();
        }else if (browser.equals("firefox")){
            driver = new FirefoxDriver();

        }
        return driver;
    }

    public static void login(WebDriver driver){

        driver.get("http://172.33.5.216:8080/ykhq");
        WebElement usrInput = driver.findElement(By.id("name"));
        usrInput.sendKeys("admin");
        WebElement passwdInput=driver.findElement(By.id("pwd"));
        passwdInput.sendKeys("emd2015");
        WebElement loginBtn=driver.findElement(By.className("login-btn"));
        loginBtn.click();

    }
    public static void main(String[] args) {
        //设置浏览器
        WebDriver driver = ManagerWebAutomation.driverConf("firefox");
        //打日志
        PropertyConfigurator.configure("F:\\2project\\automationTest\\src\\log.properties");
        Logger logger=Logger.getLogger(ManagerWebAutomation.class);
        //登陆
        ManagerWebAutomation.login(driver);
        //退出
        driver.close();

    }
}
