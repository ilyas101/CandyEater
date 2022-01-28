package main.java.ru.karimov.service;

import main.java.ru.karimov.util.CandyContainer;
import main.java.ru.karimov.util.Consumer;
import main.java.ru.karimov.model.ICandy;
import main.java.ru.karimov.model.ICandyEater;

import java.util.*;
import java.util.concurrent.*;

public class CandyService extends CandyServiceBase {

    private List<ICandyEater> candyEaterList;
    private CandyContainer candyContainer = new CandyContainer();

    public CandyService(ICandyEater[] candyEaters) {
        super(candyEaters);
        candyEaterList = new ArrayList<>(Arrays.asList(candyEaters));
    }

    @Override
    public void addCandy(ICandy candy) {
        candyContainer.addCandy(candy);
    }

    public void eat() {
        ExecutorService exec = Executors.newFixedThreadPool(candyEaterList.size());

        for (ICandyEater eater : candyEaterList) {
            exec.submit(new Consumer(candyContainer, eater));
        }
        exec.shutdown();
    }
}
