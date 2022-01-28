package main.java.ru.karimov;

import main.java.ru.karimov.model.Candy;
import main.java.ru.karimov.model.CandyEater;
import main.java.ru.karimov.service.CandyService;
import main.java.ru.karimov.model.ICandyEater;

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
