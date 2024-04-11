package com.mygdx.game.Objects;


import com.mygdx.game.Control.MainGame;

public class TextObject extends BaseObject {

    private String text;

    public TextObject(int x, int y, String text)
    {
        super(x, y, MainGame.getExplodeLiveTime());
        this.text = text;
    }

    public String getText()
    {
        return text;
    }

    @Override
    public int getPosX() {
        return (int) fromX;
    }

    @Override
    public int getPosY() {
        return (int) fromY;
    }
}