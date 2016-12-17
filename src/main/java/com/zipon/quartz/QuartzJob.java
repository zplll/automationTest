package com.zipon.quartz;

import com.zipon.test.Common;

import java.io.IOException;

/**
 * Created by zipon on 2016/11/6.
 */
public class QuartzJob {




        public void work()
        {
            Common common = new Common();
            String currentUrl = common.getCurrentUrl();
            System.out.println(currentUrl);
            System.out.println("开始Quartz的任务调度！！！");
            try {
                Runtime.getRuntime().exec("python " +currentUrl+"\\doubanMovie.py");
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("执行任务成功");
        }
        public static void main(String[] args){
            new QuartzJob().work();
        }
    }

