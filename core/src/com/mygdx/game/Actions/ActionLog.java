package com.mygdx.game.Actions;
import com.mygdx.game.units.Person;
public class ActionLog {
    private ActionType type;
    private Person parent;
    private Person target;
    private Position to;
    private int value;
    private boolean isCritical;

    public ActionLog(Person parent) {
        this.type = ActionType.NONE;
        this.parent = parent;
        this.target = null;
    }

    public ActionType getActionType()
    {
        return type;
    }

    public Person getTarget()
    {
        return target;
    }

    public int getValue()
    {
        return value;
    }

    public void logNone()
    {
        type = ActionType.NONE;
    }

    public void logMove(Position to)
    {
        type = ActionType.MOVE;
        this.to = to;
    }

    public void logShoot(Person target, int damage, boolean critical)
    {
        type = ActionType.SHOOT;
        this.target = target;
        value = damage;
        isCritical = critical;
    }

    public void logAttack(Person target, int damage, boolean critical)
    {
        type = ActionType.ATTACK;
        this.target = target;
        value = damage;
        isCritical = critical;
    }

    public void logGiveArrow(Person target)
    {
        type = ActionType.GIVE_ARROW;
        this.target = target;
    }

    public void logHealed(Person target, int health)
    {
        type = ActionType.HEALED;
        this.target = target;
        value = health;
    }

    public void logResurrect(Person target)
    {
        type = ActionType.RESURRECT;
    }

    public void logWaitForMana(Person target)
    {
        type = ActionType.WAIT_FOR_MANA;
        this.target = target;
    }

    public void logDeceasedTarget()
    {
        type = ActionType.DECEASED_NOT_FOUND;
    }

    public String getInfo()
    {
        String res = "";
        switch (type)
        {
            case MOVE:
                res = String.format("%s пошёл на (%s)", parent, to.toString());
                break;

            case SHOOT:
            case ATTACK:
                res = String.format("%s атаковал %s ", parent, target);
                if (value == 0)
                {
                    res += "но он увернулся!";
                } else {
                    res += "и нанёс ";
                    if (isCritical)
                    {
                        res += "критический ";
                    }
                    res += "урон в " + res;
                }
                break;

            case HEALED:
                res = String.format("%s вылечил %s на %d пунктов здоровья", parent, target, value);
                break;

            case GIVE_ARROW:
                res = String.format("%s дал стрелу %s", parent, target);
                break;

            case RESURRECT:
                res = String.format("%s воскресил %s", parent, target);
                break;

            case WAIT_FOR_MANA:
                res = String.format("%s восстанавливает ману для воскрешения %s", parent, target);
                break;

            case DECEASED_NOT_FOUND:
                res = String.format("%s не нашел погибшего для воскрешения!", parent);

            case NONE:
                res = String.format("%s пропускает ход.", parent);
        }
        return res;
    }
}
