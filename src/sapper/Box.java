package sapper;

import java.awt.*;

public enum Box {
// Скрытые
    zero,
    num1,
    num2,
    num3,
    num4,
    num5,
    num6,
    num7,
    num8,
    bomb,

// Внешние

    opened,
    closed,
    flaged,
    bombed,
    nobomb;

    public Object image;

// Метод возвращающий следующию цифру
    Box nextNumberBox(){
        return Box.values()[this.ordinal() +1];
    }
}
