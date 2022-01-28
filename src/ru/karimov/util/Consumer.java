package ru.karimov.util;

import ru.karimov.model.ICandy;
import ru.karimov.model.ICandyEater;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Класс имплементрует в себе отдельный поток, в кот. пожиратель будет вытаскивать конфеты из очереди и пытаться их съесть
 */
public class Consumer implements Runnable {
    private CandyContainer candyContainer;
    private ICandyEater iCandyEater;

    /**
     * @param candyContainer - контейнер, содержащий очередь конфет на съедение
     * @param iCandyEater - пожиратель конфет, который будет есть конфеты
     */
    public Consumer(CandyContainer candyContainer, ICandyEater iCandyEater) {
        this.candyContainer = candyContainer;
        this.iCandyEater = iCandyEater;
    }

    public void run() {
        try {
            while (true) {
                BlockingQueue<ICandy> candyList = candyContainer.getCandyList();
                ICandy data = candyList.take();
                candyContainer.tryEat(data, iCandyEater);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Consumed  objects");
    }
}
