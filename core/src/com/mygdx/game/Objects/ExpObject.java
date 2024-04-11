package com.mygdx.game.Objects;

import com.mygdx.game.Control.MainGame;

public class ExpObject extends BaseObject{
    public ExpObject(int x, int y)
    {
        super(x, y, MainGame.getExplodeLiveTime());
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
