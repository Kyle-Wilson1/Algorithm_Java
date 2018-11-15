/**
 * Meituan.com Inc.
 * Copyright (c) 2010-2018 All Rights Reserved.
 */
package org.learning.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * <p>futuretask</p>
 *
 * @version MyCallable.class 1.0 2018-11-14 下午3:11
 * @since 1.0
 **/
public class MyCallable implements Callable<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyCallable.class);

    private int cnt;

    public MyCallable() {
    }

    public MyCallable(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public Integer call() {
        LOGGER.info("name:{}, number:{}, start.", Thread.currentThread().getName(), this.cnt);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            LOGGER.warn("interrupted.", e);
        }
        LOGGER.info("name:{}, number:{}, end.", Thread.currentThread().getName(), this.cnt);
        return ++cnt;
    }
}