package ru.karimov.util;

import ru.karimov.model.ICandy;
import ru.karimov.model.ICandyEater;

import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Контейнер для конфет
 */
public class CandyContainer {

    private BlockingQueue<ICandy> candyList = new LinkedBlockingQueue();
    private Map<Integer, ICandyEater> eaterMap = new ConcurrentHashMap<>();
    private ReentrantLock lock = new ReentrantLock();

    /**
     * Добавление конфеты в очередь на съедение
     */
    public void addCandy(ICandy candy) {
        candyList.add(candy);
    }

    /**
     * Съесть конфету
     * @param candy - конфета, которую хотим съесть
     * @param eater - пожиратель, который будет пытаться съесть конфету
     */
    public void tryEat(ICandy candy, ICandyEater eater) {
        try {
            lock.lock();
            if (eaterMap.containsKey(candy.getCandyFlavour()) && !eaterMap.get(candy.getCandyFlavour()).equals(eater)) {
                candyList.add(candy);
            } else if (eaterMap.containsKey(candy.getCandyFlavour()) && eaterMap.get(candy.getCandyFlavour()).equals(eater)) {
                eater.eat(candy);
                eaterMap.remove(candy.getCandyFlavour());
            } else if (!eaterMap.containsKey(candy.getCandyFlavour())) {
                eaterMap.put(candy.getCandyFlavour(), eater);
                eater.eat(candy);
                eaterMap.remove(candy.getCandyFlavour());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public BlockingQueue getCandyList() {
        return candyList;
    }
}
