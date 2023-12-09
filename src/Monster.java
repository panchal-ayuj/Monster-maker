import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Random;

public class Monster {
    String colorOfEyes;
    String featherColor;
    String magicalAbilities;
    int monsterSize;
    int monsterStrength;
    int monsterDurability;
    String monsterWeakness;
    int aggressionLevel;

    public Monster(String colorOfEyes, String featherColor, String magicalAbilities, int monsterSize, int monsterStrength, int monsterDurability, String monsterWeakness, int aggressionLevel) {
        this.colorOfEyes = colorOfEyes;
        this.featherColor = featherColor;
        this.magicalAbilities = magicalAbilities;
        this.monsterSize = monsterSize;
        this.monsterStrength = monsterStrength;
        this.monsterDurability = monsterDurability;
        this.monsterWeakness = monsterWeakness;
        this.aggressionLevel = aggressionLevel;
    }
    // Creating baby using Java reflection
    public Monster createBaby(Monster monster) {
        try {
            Class<?> babyMonsterClass = Class.forName("Monster");
            Constructor<?> constructor = babyMonsterClass.getConstructor(String.class, String.class, String.class, int.class, int.class, int.class, String.class, int.class);
            Random random = new Random();
            Object[] args = new Object[]{
                    random.nextBoolean() ? this.colorOfEyes : monster.colorOfEyes,
                    random.nextBoolean() ? this.featherColor : monster.featherColor,
                    random.nextBoolean() ? this.magicalAbilities : monster.magicalAbilities,
                    random.nextBoolean() ? this.monsterSize : monster.monsterSize,
                    random.nextBoolean() ? this.monsterStrength : monster.monsterStrength,
                    random.nextBoolean() ? this.monsterDurability : monster.monsterDurability,
                    random.nextBoolean() ? this.monsterWeakness : monster.monsterWeakness,
                    random.nextBoolean() ? this.aggressionLevel : monster.aggressionLevel
            };

            //Used reflection to make an instance of the KidMonster Class
            Monster babyMonster = (Monster) constructor.newInstance(args);
            return babyMonster;
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        return "Monster{" +
                "colorOfEyes='" + colorOfEyes + '\'' +
                ", featherColor='" + featherColor + '\'' +
                ", magicalAbilities='" + magicalAbilities + '\'' +
                ", monsterSize=" + monsterSize +
                ", monsterStrength=" + monsterStrength +
                ", monsterDurability=" + monsterDurability +
                ", monsterWeakness='" + monsterWeakness + '\'' +
                ", aggressionLevel=" + aggressionLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return monsterSize == monster.monsterSize && monsterStrength == monster.monsterStrength && monsterDurability == monster.monsterDurability && aggressionLevel == monster.aggressionLevel && Objects.equals(colorOfEyes, monster.colorOfEyes) && Objects.equals(featherColor, monster.featherColor) && Objects.equals(magicalAbilities, monster.magicalAbilities) && Objects.equals(monsterWeakness, monster.monsterWeakness);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colorOfEyes, featherColor, magicalAbilities, monsterSize, monsterStrength, monsterDurability, monsterWeakness, aggressionLevel);
    }
}
