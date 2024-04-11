package com.mygdx.game.Objects;

import com.mygdx.game.Actions.Position;
import com.mygdx.game.Control.MainGame;

public class ShootObject extends BaseObject {
    private static final int SIZE_STEP = 16;

    private float deltaX;       // вектор на цель по X
    private float deltaY;       // вектор на цель по Y

    protected int PosX, PosY;             // текущие

    protected int toX;
    protected int toY;

    protected Position to;

    private int targetDamage;

    public ShootObject(int fromX, int fromY, int toX, int toY, int targetDamage)
    {
        super(fromX, fromY, 15f);
        this.targetDamage = targetDamage;
        this.toX = toX;
        this.toY = toY;

        float w = MainGame.getMapWidth() * MainGame.getMapTileWidth();
        float h = MainGame.getMapHeight() * MainGame.getMapTileHeight();
        float maxLen = (float) Math.sqrt(w*w + h*h);
        deltaX = toX - fromX;
        deltaY = toY - fromY;
        float len = (float) Math.sqrt(deltaX*deltaX + deltaY*deltaY);
        float time = (1.5f / maxLen) * len;
        setLiveTime(time);
    }

    public int getTargetDamage()
    {
        return this.targetDamage;
    }

    @Override
    public int getPosX() {
        return PosX;
    }

    @Override
    public int getPosY() {
        return PosY;
    }

    public int getTargetX()
    {
        return toX;
    }
    public int getTargetY()
    {
        return toY;
    }

    @Override
    public boolean update(float delta)
    {
        if (!super.update(delta))
            return false;

        PosX = fromX + (int) ((deltaX / getLiveTime()) * getTime());
        PosY = fromY + (int) ((deltaY / getLiveTime()) * getTime());
        return true;
    }
}
