package com.dexter.tong.chapter15;

import java.util.concurrent.Semaphore;

public class Question05 {
    /***
     * 15.5
     * Suppose we have the following code:
     * public class Foo {
     *  public Foo() { ... }
     *  public void first() { ... }
     *  public void second() { ... }
     *  public void third() { ... }
     * }
     * The same instance of Foo will be passed to three different threads. ThreadA will call first,
     * threadB will call second, and threadC will call third. Design a mechanism to ensure that
     * first is called before second and second is called before third.
     */

    public void run() {

        Foo foo = new Foo();
        Semaphore semaphore = new Semaphore(0);

        ThreadA threadA = new ThreadA(foo, semaphore);
        ThreadB threadB = new ThreadB(foo, semaphore);
        ThreadC threadC = new ThreadC(foo, semaphore);

        // Start all the threads, then release a permit
        threadC.start();
        threadB.start();
        threadA.start();
        semaphore.release(1);
        try {
            threadA.join();
            threadB.join();
            threadC.join();
        } catch (InterruptedException e) {
        }
    }

    class Foo {

        public void first() {
            System.out.println("Foo.first() called");
        }

        public void second() {
            System.out.println("Foo.second() called");
        }

        public void third() {
            System.out.println("Foo.third() called");
        }
    }

    class ThreadA extends Thread {

        private Foo foo;
        Semaphore semaphore;

        public ThreadA(Foo foo, Semaphore semaphore) {
            this.foo = foo;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                semaphore.acquire(1);
            } catch (InterruptedException e) {
            }
            foo.first();
            semaphore.release(2);
        }
    }

    class ThreadB extends Thread {

        private Foo foo;
        Semaphore semaphore;

        public ThreadB(Foo foo, Semaphore semaphore) {
            this.foo = foo;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                semaphore.acquire(2);
            } catch (InterruptedException e) {

            }
            foo.second();
            semaphore.release(3);
        }
    }

    class ThreadC extends Thread {

        private Foo foo;
        Semaphore semaphore;

        public ThreadC(Foo foo, Semaphore semaphore) {
            this.foo = foo;
            this.semaphore = semaphore;
        }

        public void run() {
            try {
                semaphore.acquire(3);
            } catch (InterruptedException e) {

            }
            foo.third();
        }
    }
}
