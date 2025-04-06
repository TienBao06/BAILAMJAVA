package Multithread2;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {
    private int id;
    private Semaphore leftChopstick, rightChopstick;

    public Philosopher(int id, Semaphore leftChopstick, Semaphore rightChopstick) {
        this.id = id;
        this.leftChopstick = leftChopstick;
        this.rightChopstick = rightChopstick;
    }

    private void think() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang suy nghĩ...");
        Thread.sleep(1000);
    }

    private void eat() throws InterruptedException {
        System.out.println("Triết gia " + id + " đang ăn 🍜...");
        Thread.sleep(1000);
    }

    @Override
    public void run() {
        try {
            while (true) {
                think();
                // Để tránh deadlock, triết gia chẵn lấy đũa trái trước, triết gia lẻ lấy đũa phải trước
                if (id % 2 == 0) {
                    leftChopstick.acquire();
                    rightChopstick.acquire();
                } else {
                    rightChopstick.acquire();
                    leftChopstick.acquire();
                }

                eat();

                leftChopstick.release();
                rightChopstick.release();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}