package BaseSettings;
import units.Person;
import Actions.Position;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Базовый класс для Волшебников, в данном случае для Кодуна и Монаха,
 * но можно добавить Некроманты или Шамана.
 */
public abstract class MagicSettings extends Person {

    private static final int COST_HEALED = 10;  // кол-во маны за процедуру лечения
    private static final int MANA_RECOVERY = 5; // кол-во восстанавливаемой маны за ход ожидания
    private static final int MANA_TO_HEAL = 3;  // коэфф. конвертации маны в здоровье

    protected int mana;                     // мана для волшебства
    protected int maxMana;
    private int resurrectMana;              // необходимое кол-во маны для воскрешения
    private Person respawnTarget;       // наша цель на воскрешение

    /**
     * Конструктор базы Волшебников
     *
     * @param name     Имя
     * @param priority Приоритет хода
     * @param health   Текущее здоровье
     * @param power    Сила
     * @param agility  Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param defence  Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     * @param mana     Маны в наличии
     * @param pos      Положение в прогстранстве
     */
    protected MagicSettings(String name, int health, int power, int armor, String weapon, String className, Position pos, int priority, int agility, int distance, int mana)
    {
        super(name, health, power, armor, weapon, className, pos, priority, agility, distance);
    
        this.mana = mana;
        this.maxMana = mana;
        this.resurrectMana = mana / 2;
        this.respawnTarget = null;
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends)
    {
        conseq = "";

        if (health <= 0)
            return;

        mana += MANA_RECOVERY;

        if (isWaitResurrection(friends))
            return;

        if (getNumOfDead(friends, mana >= resurrectMana) > 3)
        {
            beginResurrection(friends);     // воскрешаем
        } else {
            doHeal(friends);                // лечим
        }
    }

    private void beginResurrection(ArrayList<Person> friends)
    {
        Person p = friends.stream()
                                .filter(n -> n.health == 0)
                                .sorted((n1, n2) -> n2.priority - n1.priority)
                                .collect(Collectors.toList())
                                .getFirst();
        if (p != null)
        {
            if (mana >= resurrectMana)
            {
                doResurrection(p);
            } else {
                respawnTarget = p;
                respawnTarget.health = -1;      // помечаем как ожидающего воскрешение
                conseq = String.format(" восстанавливает ману для воскрешения %s", respawnTarget);
            }
        }
    }

    /**
     * Воскрешаем цель или продолжаем копить ману для воскрешения
     *
     * @param friends Список своих
     * @return true - пропускаем ход (копим ману), false - ожидание прервано, ходим дальше
     */
    private boolean isWaitResurrection(ArrayList<Person> friends)
    {
        if (respawnTarget == null || respawnTarget.getHealth() >= 0)
        {
            respawnTarget = null;               // некого воскрешать (или уже воскресили)
            return false;
        }
        if (mana >= resurrectMana)
        {
            doResurrection(respawnTarget);      // воскрешаем
        } else {
            conseq = String.format(" восстанавливает ману для воскрешения %s", respawnTarget);
        }
        return true;
    }

    /**
     * Воскрешение персонажа
     * @param person Собственно воскрешаемый персонаж
     */
    private void doResurrection(Person person)
    {
        if (respawnTarget.getHealth() < 0)
        {
            person.healed(respawnTarget.getMaxHealth());
            mana -= resurrectMana;
            conseq = String.format(" воскресил %s", respawnTarget);
        } else {
            conseq = String.format(" не нашел погибшего для воскрешения!");
        }
        respawnTarget = null;
    }

    /**
     * Лечение наиболее хилого персонажа
     *
     * @param friends Список персов
     */
    private void doHeal(ArrayList<Person> friends) {
        int min = Integer.MAX_VALUE;
        Person p = null;
        for (Person friend : friends) {
            int hp = friend.getHealth() * 100 / friend.getMaxHealth();
            if (hp > 0 && hp < min) {
                min = hp;
                p = friend;
            }
        }
        if (p != null && min < 100) {
            int n = Math.min(mana, COST_HEALED);
            mana -= n;
            int hp = p.getHealth();
            p.healed(n * MANA_TO_HEAL);
            conseq = String.format(" вылечил %s на %d пунктов здоровья", p, p.getHealth()-hp);
        } else {
            conseq = String.format(" пропускает ход.");
        }
    }

    /**
     * Подсчет погибших
     *
     * @param friends       Список всех персонажей
     * @param isReservation Если true, то учитывает и зарезервированных погибших
     * @return Количество покойников
     */
    private int getNumOfDead(ArrayList<Person> friends, boolean isReservation) {
//        return (int) friends.stream().filter(n -> n.getHealth() <= 0).count();
        int count = 0;
        for (Person friend : friends) {
            if (friend.getHealth() == 0)
                count++;
            else if (friend.getHealth() < 0 && isReservation)
                count++;
        }
        return count;
    }

    /**
     * Получение повреждений. Если персонаж умирает, то освобождаем respawnTarget.
     * @param damage Величина урона (конечная будет зависеть от @defence и ловкости)
     * @return Величина реально нанесенного урона.
     */
    @Override
    public int getDamage(int damage)
    {
        int hp = super.getDamage(damage);
        if (health <= 0)
        {
            if (respawnTarget != null)
            {
                if (respawnTarget.getHealth() < 0)
                    respawnTarget.health = 0;
                respawnTarget = null;
            }
        }
        return hp;
    }
}
