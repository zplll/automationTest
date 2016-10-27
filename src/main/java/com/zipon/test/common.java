package com.zipon.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

/**
 * @author kin
 * @version $: v 0.1 2016/10/20 Exp $$
 */
public class Common {

    //浏览器设置
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

    //截图方法
    public static void snapshot(TakesScreenshot drivername, String filename)
    {
        // this method will take screen shot ,require two parameters ,one is driver name, another is file name

        String currentPath = System.getProperty("user.dir"); //get current work folder
        System.out.println(currentPath);
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        // Now you can do whatever you need to do with it, for example copy somewhere
        try {
            System.out.println("save snapshot path is:"+currentPath+"/screenshot/"+filename);
            FileUtils.copyFile(scrFile, new File(currentPath+"\\screenshot\\"+filename));
        } catch (IOException e) {

            System.out.println("Can't save screenshot");
            e.printStackTrace();
        }
        finally
        {

            System.out.println("screen shot finished");
        }
    }


    //鼠标悬浮元素方法
    public static void MouseHoverByJavaScript(WebElement targetElement, WebDriver driver)
    {

        String mouseHoverjs = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript(mouseHoverjs, targetElement);
    }
}
