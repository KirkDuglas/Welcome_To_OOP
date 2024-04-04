package Objects;

import BaseSettings.Config;

public class ExpObject extends BaseObject{
    public ExpObject(int x, int y)
    {
        super(x, y, Config.getExplodeLiveTime());
    }

    @Override
    public int getposX() {
        return (int) fromX;
    }

    @Override
    public int getposY() {
        return (int) fromY;
    }
    
}
