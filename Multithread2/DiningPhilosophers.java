package Multithread2;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    public static void main(String[] args) {
        int N = 5;  // Số triết gia
        Semaphore[] chopsticks = new Semaphore[N];

        for (int i = 0; i < N; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        Philosopher[] philosophers = new Philosopher[N];
        for (int i = 0; i < N; i++) {
            philosophers[i] = new Philosopher(i, chopsticks[i], chopsticks[(i + 1) % N]);
            philosophers[i].start();
        }
    }
}