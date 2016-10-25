package com.zipon.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author kin
 * @version $: v 0.1 2016/10/20 Exp $$
 */
public class biz {

    public static void login(WebDriver driver){
        String testUrl="http://172.33.0.189:8080";
        driver.get(testUrl);
        WebElement usrInput = driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div/div[1]/div/form/div[2]/input"));
        usrInput.sendKeys("gmtest");
        WebElement passwdInput=driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div/div[1]/div/form/div[4]/input"));
        passwdInput.sendKeys("888888");
        WebElement loginBtn=driver.findElement(By.xpath("//*[@id=\"ng-app\"]/body/div/div[1]/div/form/div[5]/button"));
        loginBtn.click();
    }
}
