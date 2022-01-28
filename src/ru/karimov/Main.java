package ru.karimov;

import ru.karimov.model.Candy;
import ru.karimov.model.CandyEater;
import ru.karimov.service.CandyService;
import ru.karimov.model.ICandyEater;

public class Main {

    public static void main(String[] args)  throws Exception {
        ICandyEater[] candyEaters = {
                new CandyEater(),
                new CandyEater(),

        };
        CandyService candyService = new CandyService(candyEaters);

        candyService.addCandy(new Candy(1));
        candyService.eat();

        Thread.sleep(3000);
        candyService.addCandy(new Candy(1));
        Thread.sleep(3000);

        candyService.addCandy(new Candy(1));
        candyService.addCandy(new Candy(1));
        candyService.addCandy(new Candy(1));
        candyService.addCandy(new Candy(1));
        candyService.addCandy(new Candy(1));
        candyService.addCandy(new Candy(1));
    }
}
