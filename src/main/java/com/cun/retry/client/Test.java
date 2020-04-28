package com.cun.retry.client;

import com.cun.retry.service.RemoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Test {

    private static final int RETRY_TIMES = 3;

    private static final Logger logger = LoggerFactory.getLogger(Test.class);

    public static void main(String[] args) {

        int retryCount = 0;
        while (retryCount < RETRY_TIMES) {
            try {
                RemoteService.execute();
                break; // 能执行到这行，说明执行没有异常
            } catch (Exception e) {
                retryCount++;
                logger.info("【远程服务调用失败，重试中】");
            }
        }
        if (retryCount >= RETRY_TIMES){
            logger.info("【无法调用远程服务】");
        }
        logger.info(String.format("【重试次数：%s >>> 最终执行是否成功：%s】", retryCount, retryCount < RETRY_TIMES));
    }

}
