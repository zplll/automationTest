package com.zipon.test;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author kin
 * @version $: v 0.1 2016/9/29 Exp $$
 */
public class seleniumTest01 {
    public static void main(String[] args){
        PropertyConfigurator.configure("F:\\2project\\automationTest\\src\\log.properties");
       System.setProperty("webdriver.chrome.driver", "C:\\Users\\kin\\Documents\\Tencent Files\\1418641603\\FileRecv\\chromeDriver.exe");
        //System.out.println(System.getProperty("webdriver.chrome.driver"));
//        FirefoxProfile fp = new FirefoxProfile();
//        fp.setPreference("browser.startup.homepage", "about:blank");
//        fp.setPreference("startup.homepage_welcome_url", "about:blank");
//        fp.setPreference("startup.homepage_welcome_url.additional", "about:blank");
        Logger logger= Logger.getLogger("com.zipon.test.seleniumTest01");
        logger.debug("打开浏览器！！！！");
        WebDriver driver=new ChromeDriver();
        logger.debug("打开成功");
        driver.get("http://www.baidu.com");
        driver.navigate().to("https://www.douban.com");
        driver.close();
        logger.debug("结束");
    }
}
