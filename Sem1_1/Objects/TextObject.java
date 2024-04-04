package Objects;


import BaseSettings.Config;

public class TextObject extends BaseObject {

    private String text;

    public TextObject(int x, int y, String text)
    {
        super(x, y, Config.getExplodeLiveTime());
        this.text = text;
    }

    public String getText()
    {
        return text;
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