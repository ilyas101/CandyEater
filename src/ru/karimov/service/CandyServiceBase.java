package ru.karimov.service;

import ru.karimov.model.ICandy;
import ru.karimov.model.ICandyEater;

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
