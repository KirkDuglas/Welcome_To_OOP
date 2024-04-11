package com.mygdx.game.Actions;

import com.mygdx.game.Actions.*;
import com.mygdx.game.Control.MainGame;
import com.mygdx.game.Objects.*;
import com.mygdx.game.units.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// import org.w3c.dom.Text;


public class Teams {
    private final ArrayList<Person> red;
    private final ArrayList<Person> blue;

    private final ArrayList<TeamPerson> allPersons;

    int curPerson;

    public final ArrayList<BaseObject> actionObjects;  // взрывы, "стрелы" и тд.

    public Teams()
    {
        this.red = new ArrayList<Person>();
        this.blue = new ArrayList<Person>();
        this.allPersons = new ArrayList<TeamPerson>();
        actionObjects = new ArrayList<BaseObject>();
        curPerson = -1;
    }

    /**
     * Возвращает список всех персонажей, отсортированный для правильной отрисовки
     * @return Отсортированный список персонажей
     */
    public ArrayList<TeamPerson> getAllPersons()
    {
        ArrayList<TeamPerson> team = new ArrayList<TeamPerson>(allPersons);
        Collections.sort(team, new TeamSort());
//        ArrayList<TeamPerson> team = (ArrayList<TeamPerson>) allPersons.stream()
//                .sorted((n1, n2) -> Integer.compare(n2.person.getPosition().getY(), n1.person.getPosition().getY()))
//                .collect(Collectors.toList());
        return team;
    }

    /**
     * Ход персонажей, или вывод анимированных объектов
     *
     * @param deltaTime Прошедшее с последнего вызова время
     */
    public void update(float deltaTime)
    {
        if (actionObjects.isEmpty())
        {
            updateTeams();
        } else {
            updateAction(deltaTime);
        }
    }


    private void updateTeams()
    {
        allPersons.get(curPerson).active = false;
        curPerson++;
        if (curPerson >= allPersons.size())
        {
            curPerson = 0;
        }
        TeamPerson p = allPersons.get(curPerson);
        p.active = true;
        if (p.team == TeamType.RED)
        {
            p.person.step(blue, red);
        } else {
            p.person.step(red, blue);
        }
        /*
            Проверяем последние действия активного персонажа
         */
        Person person = allPersons.get(curPerson).person;
        ActionLog conseq = person.getConseq();
        switch (conseq.getActionType())
        {
            case SHOOT:
            case ATTACK:
                Position from = person.getPosition();
                Position to = conseq.getTarget().getPosition();
                BaseObject shoot = new ShootObject(from.getX()* MainGame.getMapTileWidth(), from.getY()*MainGame.getMapTileHeight(),
                        to.getX()*MainGame.getMapTileWidth(), to.getY()*MainGame.getMapTileHeight(), conseq.getValue());
                actionObjects.add(shoot);
                break;
            case HEALED:
                int toX = conseq.getTarget().getPosition().getX();
                int toY = conseq.getTarget().getPosition().getY();

                BaseObject healed = new ResObject(toX * MainGame.getMapTileWidth(), toY * MainGame.getMapTileHeight());
                BaseObject text = new TextObject(toX * MainGame.getMapTileWidth(), (toY+1) * MainGame.getMapTileHeight(), "" + conseq.getValue());
                actionObjects.add(healed);
                actionObjects.add(text);
                break;
        }
    }

    private void updateAction(float delta)
    {
        int index = 0;
        while (index < actionObjects.size())
        {
            BaseObject p = actionObjects.get(index);
            if (!p.update(delta))
            {
                if (p instanceof ShootObject)
                {
                    ExpObject exp = new ExpObject(((ShootObject) p).getTargetX(), ((ShootObject) p).getTargetY());
                    TextObject txt = new TextObject(((ShootObject) p).getTargetX(), ((ShootObject) p).getTargetY()+ MainGame.getMapTileHeight(), "" + ((ShootObject) p).getTargetDamage());
                    // добавляем в начало, чтобы сразу не обновлять
                    actionObjects.add(0, exp);
                    actionObjects.add(0, txt);
                    index += 2;
                }
                actionObjects.remove(index);
            } else {
                index++;
            }
        }
    }

    public boolean checkRedCommand()
    {
        for (Person p : red)
            if (p.getHealth() > 0)
                return true;
        return false;
    }

    public boolean checkBlueCommand()
    {
        for (Person p : blue)
            if (p.getHealth() > 0)
                return true;
        return  false;
    }

    public void createTeams(int numPersons)
    {
        createOneTeam(red, numPersons, 0);
        createOneTeam(blue, numPersons, 3);
        // создаём список всех персонажей, отсортированных по приоритету хода
        ArrayList<Person> all = new ArrayList<>();
        all.addAll(red);
        all.addAll(blue);
        Collections.sort(all, new PrioritySorting());  //        all.sort((o1, o2) -> Integer.compare(o2.priority, o1.priority));
        // переносим их в команды
        for (Person p : all)
        {
            if (red.contains(p))
            {
                allPersons.add(new TeamPerson(TeamType.RED, p));
            } else {
                allPersons.add(new TeamPerson(TeamType.BLUE, p));
            }
        }
        curPerson = allPersons.size()-1;
    }

    private void createOneTeam(ArrayList<Person> team, int num, int start)
    {
        Random rnd = new Random();
        while (--num >= 0)
        {
            int n = start + rnd.nextInt(4);
            switch (n)
            {
                case 0:
                    team.add(new Crossbowman(Names.getRandomName(), new Position(0, num)));
                    break;
                case 1:
                    team.add(new Spearman(Names.getRandomName(), new Position(0, num)));
                    break;
                case 2:
                    team.add(new Magician(Names.getRandomName(), new Position(0, num)));
                    break;
                case 3:
                    team.add(new Peasant(Names.getRandomName(), new Position(start > 0 ? 9 : 0, num)));
                    break;
                case 4:
                    team.add(new Sniper(Names.getRandomName(), new Position(9, num)));
                    break;
                case 5:
                    team.add(new Monk(Names.getRandomName(), new Position(9, num)));
                    break;
                case 6:
                    team.add(new Robber(Names.getRandomName(), new Position(9, num)));
                    break;
                default:
                    System.out.println("ERROR!");
            }

        }
    }

}
