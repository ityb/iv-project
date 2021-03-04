package com.ityb.iv.productorAndConsumer;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProducterAndConsumer{

    static ReentrantLock lock=new ReentrantLock();
    static Condition fullCondition=lock.newCondition();
    static Condition emptyCondition=lock.newCondition();

    static  int num=30;


    static Queue<Integer> queue=new ArrayDeque<>(num);


    static int e=0;

    public static void productor () throws InterruptedException {
        lock.lock();
        try {
            while (queue.size()>=num){
                System.out.println("已经满了");
                fullCondition.await();
            }
            System.out.println("线程="+Thread.currentThread().getName()+"正在生产"+e);
            queue.add(e++);
            emptyCondition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void consumer() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()){
                emptyCondition.await();
            }
            Integer poll = queue.poll();
            System.out.println("线程="+Thread.currentThread().getName()+"正在消费"+poll);
            fullCondition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws Exception {
        for (int i=0;i<num;i++){
            new Thread(()->{
                try {
                    Thread.sleep(2000);
                    productor();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            },i+"").start();
        }

        for (int i=0;i<num;i++){
            new Thread(()->{
                try {
                    consumer();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            },i+"").start();
        }
        Thread.sleep(Integer.MAX_VALUE);
    }


}
