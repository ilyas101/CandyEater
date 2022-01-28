package main.java.ru.karimov.service;

import main.java.ru.karimov.model.ICandy;
import main.java.ru.karimov.model.ICandyEater;

/**
 * ������ ��������� ������, ������� ����������
 */
public abstract class CandyServiceBase {
    /**
     * ������ �������� ��� ������������� ������ ��������� ����������� ������
     *
     * @param candyEaters
     */
    public CandyServiceBase(ICandyEater[] candyEaters) {
    }

    /**
     * �������� ������� �� ��������
     *
     * @param candy
     */
    public abstract void addCandy(ICandy candy);
}
