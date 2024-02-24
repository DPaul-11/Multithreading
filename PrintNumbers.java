package Multithreading;

import java.util.*;

class Thread_Ten extends Thread
{
    Thread_Ten()
    {
        System.out.println("I am in Thread 10");
    }
    @Override
    public void run()
    {
        synchronized (Constants.lock)
        {
            for(int i=1;i<=10;i++)
            {

                System.out.println(i);
            }
        }
    }
}
class Thread_Twenty extends Thread
{
    Thread_Twenty()
    {
        System.out.println("I am in Thread 20");
    }
    @Override
    public void run()
    {
        synchronized (Constants.lock) {
            for (int i = 11; i <= 20; i++) {

                System.out.println(i);

            }
        }
    }

}

public class PrintNumbers
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread_Ten t1=new Thread_Ten();
        Thread_Twenty t2=new Thread_Twenty();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
