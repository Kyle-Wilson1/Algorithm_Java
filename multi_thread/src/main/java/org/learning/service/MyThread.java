/**
 * Meituan.com Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package org.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>继续类</p>
 *
 * @version MyThread.class 1.0 2018-11-13 下午3:00
 * @since 1.0
 **/
public class MyThread extends Thread {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyThread.class);

    private int cnt;

    public MyThread(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public void run() {
        LOGGER.info("name:{}, number:{}, start.", Thread.currentThread().getName(), this.cnt);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.warn("interrupted.", e);
        }
        LOGGER.info("name:{}, number:{}, end.", Thread.currentThread().getName(), this.cnt);
    }

}