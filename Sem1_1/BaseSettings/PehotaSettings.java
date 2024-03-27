package BaseSettings;
import units.Person;
import Actions.Position;
import java.util.ArrayList;

public abstract class PehotaSettings extends Person {

    protected int level;            // уровень, увеличивается по мере опыта

    /**
     * Конструктор базы Пехоты
     *
     * @param name     Имя
     * @param priority Приоритет хода
     * @param health   Текущее здоровье
     * @param power    Сила
     * @param agility  Ловкость (%). 3 ловкости = 1% к увороту, и 10 ловкости = 1% к критическому удару
     * @param armor  Защита (% к сопротивлению урону)
     * @param distance Дистанция воздействия на другой объект (10 у мага, 1 у крестьянина и тд)
     * @param pos      Положение в прогстранстве
     */
    protected PehotaSettings(String name, int health, int power, int armor, String weapon, String className, Position pos, int priority, int agility,  int distance)
    {
        super(name, health, power, armor, weapon, className, pos, priority, agility, distance);
        level = 1;
    }


    /**
     * Проверяет, не находится ли кто в заданных координатах
     * @param pos     Позиция для проверки
     * @param persons Список персонажей
     * @return        true, если в заданной позиции никого нет.
     */
    private boolean isMoved(Position pos, ArrayList<Person> persons)
    {
        for (Person p : persons)
        {
            if (p.position.equal(pos))
                return false;
        }
        return true;
    }

    private void move(Person target, ArrayList<Person> friends)
    {
        int[] px = {1, 0, -1, 0};       // координаты возможных ходов (вправо, вниз, влево, вверх)
        int[] py = {0, 1, 0, -1};

        // ищем кратчайший возможный ход в сторону противника
        Position newPos = new Position(position.getX(),position.getY());
        int minIdx = -1;
        float minDist = Float.MAX_VALUE;
        for (int i = 0; i < 4; i++)
        {
            newPos.setXY(position.getX()+px[i], position.getY()+py[i]);
            if (isMoved(newPos, friends))
            {
                // сюда ходить можно, но нужно убедиться - кратчайший ли это путь?
                float dist = position.fastDistance(target.position, px[i], py[i]);
                if (dist < minDist)
                {
                    minIdx = i;
                    minDist = dist;                }
            }
        }
        if (minIdx == -1.0f)
            return;

        position.increment(px[minIdx], py[minIdx]);

        conseq = "move to " + position;
    }

    private void attack(Person target, boolean isMoved)
    {
        int damage = getRound(power, 10) + (power / 10) * level;
        boolean critical = (this.agility/3) >= rnd.nextInt(100);
        if (critical)
        {
            damage *= 2.0f;
        }
        if (isMoved)
            damage /= 2;                        // удар с хода

        int res = target.getDamage(damage);
        conseq = conseq + "attack " + target.name + " set " + res + "damage";
    }

    @Override
    public void step(ArrayList<Person> enemies, ArrayList<Person> friends)
    {
        conseq = "";
        Person target = this.findNearestPerson(enemies);
        if (health <= 0 || target == null)
            return;

        if (position.distanceTo(target.position) < 1.5f)
        {
            // бьём
            attack(target, false);
        } else {
            move(target, friends);
            if (position.distanceTo(target.position) < 1.5f)
            {
                // бьём с ходу, с меньшей силой
                attack(target, true);
            }
        }

    }
}
