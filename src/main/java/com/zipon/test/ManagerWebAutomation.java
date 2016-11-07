package com.zipon.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author kin
 * @version $: v 0.1 2016/9/30 Exp $$
 */
public class ManagerWebAutomation {

    private static WebDriver driver;
    private static  Logger logger;

    @BeforeMethod
    public void beforeMethod(){
        //设置浏览器
         driver = Common.driverConf("chrome");
        //打日志
        PropertyConfigurator.configure("src/log.properties");
        logger=Logger.getLogger(ManagerWebAutomation.class);
    }


    @Test
    public  void loginTest() throws InterruptedException {
       //登陆
        logger.info("开始执行登陆用例");
        Biz.login(driver);
        logger.info("登陆成功");
        Thread.sleep(3000);
        Common.snapshot((TakesScreenshot) driver,"login.png");

    }

//    @Test
//    public void test(){
//        String currentPath = System.getProperty("user.dir"); //get current work folder
//        System.out.println(currentPath);
//    }

    @Test//(dependsOnMethods={"loginTest"})
    public void reportTest(){
        //登陆
        logger.info("开始执行登陆用例");
        Biz.login(driver);
        logger.info("登陆成功");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //悬浮报表nav
        WebElement reportNav=driver.findElement(By.linkText("报表"));
        Common.MouseHoverByJavaScript(reportNav,driver);
        Common.snapshot((TakesScreenshot) driver,"reportTest.png");
    }

    @AfterMethod
    public void afterMethod(){
        driver.close();
    }
}
