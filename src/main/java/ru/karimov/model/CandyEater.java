package main.java.ru.karimov.model;

public class CandyEater implements ICandyEater {

    @Override
    public void eat(ICandy candy) throws Exception {
        System.out.println("Thread [" + Thread.currentThread().getName() + "], start eating = [" + candy + "], flavour:  " + candy.getCandyFlavour());
        Thread.sleep(3000);
        System.out.println("Thread [" + Thread.currentThread().getName() + "], candy eaten = [" + candy + "], flavour:  " + candy.getCandyFlavour());
    }
}
