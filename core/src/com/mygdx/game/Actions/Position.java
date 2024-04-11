package com.mygdx.game.Actions;

import java.util.ArrayList;
import java.util.List;

public class Position {
    public int posX;
    public int posY;
    private static int width;
    private static int height;
    static {
        width = 10;
        height = 10;
    }

    public Position(int x, int y) {
        posX = x;
        posY = y;
    }

    public void setXY(int x, int y) {
        posX = x;
        posY = y;
    }

    public int getX() {
        return posX;
    }

    public int getY() {
        return posY;
    }
    public static void setWidth(int width) {
        Position.width = width;
    }

    public static void setHeight(int height) {
        Position.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }


    public void increment(int dx, int dy)
    {
        posX += dx;
        posY += dy;
    }
    /**
     * Проверка на возможность хода на заданную позицию
     *
     * @param x Предполагаемая позиция по оси X
     * @param y Предполагаемая позиция по оси Y
     * @return  true - если ход возможен
     */
    public boolean isMove(int x, int y)
    {
         return x >= 0 && x < width && y >= 0 && y < height;
    }

    /**
     * Вычисляет расстояние расстояние до другой точки
     * 
     * @param target До куда считаем
     * @return       Расстояние
     */
    public float distanceTo(Position target)
    {
        float x = posX - target.getX();
        float y = posY - target.getY();
        return (float) Math.sqrt(x*x + y*y);
    }

    public float fastDistance(Position target, int dx, int dy)
    {
        float tx = posX+dx - target.getX();
        float ty = posY+dy - target.getY();
        return (tx*tx + ty*ty);
    }

    /**
     * Возвращает разницу координат
     * @param to
     * @return
     */
    public Position getDelta(Position to)
    {
        return new Position(to.posX-posX, to.posY-posY);
    }

    /**
     * Сравнение координат
     * @param to Проверяемые координаты
     * @return true если равны
     */
    public boolean equal(Position to)
    {
        return posX == to.posX && posY == to.posY;
    }

    public String toString()
    {
        return posX + ":" + posY;
    }
}

//     public List<Integer> getPosition(){
//         List<Integer> list = new ArrayList<>();
//         list.add(x);
//         list.add(y);
//         return list;
//     }
    
//     public double getDistance(Position target){
//         double targetDistance = Math.sqrt(Math.pow(target.x - x, 2) + (Math.pow(target.y - y, 2)));
//         return targetDistance;

//     }
//     public boolean isMove(int x, int y)
//     {
//         return x >= 0 && x < width && y >= 0 && y < height;
//     }
//     public void moveTo(int dx, int dy)
//     {
//         if (isMove(x +dx, y +dy))
//         {
//             x += dx;
//             y += dy;
//         }
//     }
//     public float distanceTo(Position target)
//     {
//         float x = getX() - target.getX();
//         float y = getY() - target.getY();
//         return (float) Math.sqrt(x*x + y*y);
//     }
//     public float fastDistance(Position target, int dx, int dy)
//     {
//         float tx = posX+dx - target.getX();
//         float ty = posY+dy - target.getY();
//         return (tx*tx + ty*ty);
//     }

//     /**
//      * Возвращает разницу координат
//      * @param to
//      * @return
//      */
//     public Position getDelta(Position to)
//     {
//         return new Position(to.posX-posX, to.posY-posY);
//     }

//     /**
//      * Сравнение координат
//      * @param to Проверяемые координаты
//      * @return true если равны
//      */
//     public boolean equal(Position to)
//     {
//         return posX == to.posX && posY == to.posY;
//     }

//     public String toString()
//     {
//         return posX + ":" + posY;
//     }

// }