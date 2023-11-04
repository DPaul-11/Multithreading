package Multithreading;
import java.util.*;
class Odd extends Thread{
    Odd(){
        System.out.println("I am Odd");
    }
    @Override
    public void run()
    {
        synchronized (Constants.lock)
        {
            for(int i=1;i<=10;i++)
            {
                if(i%2!=0)
                System.out.println("Thread_1 :"+i);
            }
        }
    }

}
class Even extends Thread{
    Even(){
        System.out.println("I am Even");
    }
    @Override
    public void run()
    {
        synchronized (Constants.lock)
        {
            for(int i=1;i<=10;i++)
            {
                if(i%2==0)
                    System.out.println("Thread_2 :"+i);
            }
        }
    }

}

public class Evenodd {
    public static void main(String[] args) throws InterruptedException{
        Odd t1=new Odd();
        Even t2=new Even();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }
}
