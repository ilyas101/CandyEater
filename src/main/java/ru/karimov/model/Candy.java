package main.java.ru.karimov.model;

import java.util.Random;

public class Candy implements ICandy {

    private Flavour flavour;

    public Candy() {
        flavour = Flavour.values()[new Random().nextInt(Flavour.size() - 1)];
    }

    public Candy(int i) {
        flavour = Flavour.TYPE0;
    }

    @Override
    public int getCandyFlavour() {
        return flavour.getId();
    }
}
