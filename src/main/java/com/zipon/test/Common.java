package com.zipon.test;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

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

    //根据key读取value
    public static String readValueFromProperties(String filePath,String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(filePath));
            props.load(in);
            String value = props.getProperty (key);
            System.out.println(key+value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //读取properties的全部信息
    public static void readProperties(String filePath) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream (new FileInputStream(filePath));
            props.load(in);
            Enumeration en = props.propertyNames();
            while (en.hasMoreElements()) {
                String key = (String) en.nextElement();
                String Property = props.getProperty (key);
                System.out.println(key+Property);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //写入properties信息
    public static void writeProperties(String filePath,String parameterName,String parameterValue) {
        Properties prop = new Properties();
        try {
            InputStream fis = new FileInputStream(filePath);
            //从输入流中读取属性列表（键和元素对）
            prop.load(fis);
            //调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
            //强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
            OutputStream fos = new FileOutputStream(filePath);
            prop.setProperty(parameterName, parameterValue);
            //以适合使用 load 方法加载到 Properties 表中的格式，
            //将此 Properties 表中的属性列表（键和元素对）写入输出流
            prop.store(fos, "Update '" + parameterName + "' value");
        } catch (IOException e) {
            System.err.println("Visit "+filePath+" for updating "+parameterName+" value error");
        }
    }
}
