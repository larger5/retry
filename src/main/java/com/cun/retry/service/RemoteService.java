package com.cun.retry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class RemoteService {

    private static final Logger logger = LoggerFactory.getLogger(RemoteService.class);

    public static int execute() {
        logger.info("【远程服务执行中】");
        int num = new Random().nextInt(1);
        return 10 / num;
    }

}
