package org.learning;

import org.learning.service.MyCallable;
import org.learning.service.MyRunnable;
import org.learning.service.MyThread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;


/**
 * Hello world!
 */
public class App {

    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        int n = 2;
        testThread(n);
        testRunnable(n);
        testFutureTask(n);
        testFutureTaskWithPool(n);
        testFutureWithPool(n);
    }

    private static void testThread(int n) {

        for (int i = 0; i < n; ++i) {
            new MyThread(i).start();
        }
    }

    private static void testRunnable(int n) {
        for (int i = 0; i < n; ++i) {
            new Thread(new MyRunnable(i)).start();
        }
    }

    private static void testFutureTask(int n) {

        List<FutureTask> taskList = new ArrayList<FutureTask>();

        for (int i = 0; i < n; ++i) {
            MyCallable testCallable = new MyCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(testCallable);
            new Thread(futureTask).start();
            taskList.add(futureTask);
        }

        try {
            for (int i = 0; i < n; ++i) {
                LOGGER.info("testFutureTask(), i:{}, result:{}", i, taskList.get(i).get());
            }
        } catch (Exception e) {
            LOGGER.warn("testFutureTask(), exception", e);
        }
    }

    private static void testFutureTaskWithPool(int n) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<FutureTask> futureTaskList = new ArrayList<FutureTask>();

        for (int i = 0; i < n; ++i) {

            MyCallable testCallable = new MyCallable();
            FutureTask<Integer> futureTask = new FutureTask<Integer>(testCallable);
            executorService.submit(futureTask);
            futureTaskList.add(futureTask);
        }
        try {
            for (int i = 0; i < n; ++i) {
                LOGGER.info("testFutureTaskWithPool(), i:{}, result:{}", i, futureTaskList.get(i).get());
            }
        } catch (Exception e) {
            LOGGER.warn("testFutureTaskWithPool(), exception", e);
        } finally {
            executorService.shutdown();
        }
    }

    private static void testFutureWithPool(int n) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> futureList = new ArrayList<Future>();

        for (int i = 0; i < n; ++i) {

            MyCallable testCallable = new MyCallable();
            Future<Integer> future = executorService.submit(testCallable);
            futureList.add(future);
        }
        try {
            for (int i = 0; i < n; ++i) {
                LOGGER.info("testFutureWithPool(), i:{}, result:{}", i, futureList.get(i).get());
            }
        } catch (Exception e) {
            LOGGER.warn("test_testFutureWithPool(), exception", e);
        } finally {
            executorService.shutdown();
        }

    }
}