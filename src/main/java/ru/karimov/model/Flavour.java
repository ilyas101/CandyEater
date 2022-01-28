package main.java.ru.karimov.model;

/**
 * Вкусы конфет
 */
public enum Flavour {
    TYPE0(0),
    TYPE1(1),
    TYPE2(2),
    TYPE3(3);

    int id;

    Flavour(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static int size() {
        return Flavour.values().length;
    }
}
