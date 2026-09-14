public class Main {
    public static void main(String[] args) {
        EnemySpawner forest = new ForestSpawner();
        EnemySpawner dungeon = new DungeonSpawner();

        String[] forestEnemies = {"goblin", "wolf"};
        String[] dungeonEnemies = {"skeleton", "slime"};

        for (String type : forestEnemies) {
            Enemy enemy = forest.spawnEnemy(type);
            enemy.attack();
        }

        for (String type : dungeonEnemies) {
            Enemy enemy = dungeon.spawnEnemy(type);
            enemy.attack();
        }
    }
}

abstract class Enemy {
    protected Weapon weapon;
    protected Armor armor;

    public Enemy(EquipmentFactory equipmentFactory) {
        weapon = equipmentFactory.createWeapon();
        armor = equipmentFactory.createArmor();
    }

    public abstract void attack();
}

class Goblin extends Enemy {
    public Goblin(EquipmentFactory equipmentFactory) {
        super(equipmentFactory);
    }

    public void attack() {
        System.out.println("Goblin attacks with " + weapon.getDescription()
                + " wearing " + armor.getDescription());
    }
}

class Skeleton extends Enemy {
    public Skeleton(EquipmentFactory equipmentFactory) {
        super(equipmentFactory);
    }

    public void attack() {
        System.out.println("Skeleton attacks with " + weapon.getDescription()
                + " wearing " + armor.getDescription());
    }
}

class Wolf extends Enemy {
    public Wolf(EquipmentFactory equipmentFactory) {
        super(equipmentFactory);
    }

    public void attack() {
        System.out.println("Wolf attacks with " + weapon.getDescription()
                + " wearing " + armor.getDescription());
    }
}

class Slime extends Enemy {
    public Slime(EquipmentFactory equipmentFactory) {
        super(equipmentFactory);
    }

    public void attack() {
        System.out.println("Slime attacks with " + weapon.getDescription()
                + " wearing " + armor.getDescription());
    }
}

class SimpleEnemyFactory {
    public Enemy createEnemy(String type) {
        if ("goblin".equalsIgnoreCase(type)) {
            return new Goblin(new WarriorEquipmentFactory());
        }

        if ("skeleton".equalsIgnoreCase(type)) {
            return new Skeleton(new MageEquipmentFactory());
        }

        throw new IllegalArgumentException("Unknown enemy: " + type);
    }
}

abstract class EnemySpawner {
    protected abstract Enemy createEnemy(String type);

    public Enemy spawnEnemy(String type) {
        Enemy enemy = createEnemy(type);
        System.out.println("Spawning " + type);
        return enemy;
    }
}

class ForestSpawner extends EnemySpawner {
    protected Enemy createEnemy(String type) {
        if ("goblin".equalsIgnoreCase(type)) {
            return new Goblin(new WarriorEquipmentFactory());
        }

        if ("wolf".equalsIgnoreCase(type)) {
            return new Wolf(new WarriorEquipmentFactory());
        }

        throw new IllegalArgumentException("Unknown forest enemy: " + type);
    }
}

class DungeonSpawner extends EnemySpawner {
    protected Enemy createEnemy(String type) {
        if ("skeleton".equalsIgnoreCase(type)) {
            return new Skeleton(new MageEquipmentFactory());
        }

        if ("slime".equalsIgnoreCase(type)) {
            return new Slime(new MageEquipmentFactory());
        }

        throw new IllegalArgumentException("Unknown dungeon enemy: " + type);
    }
}

interface Weapon {
    String getDescription();
}

interface Armor {
    String getDescription();
}

class Sword implements Weapon {
    public String getDescription() {
        return "Sharp Iron Sword";
    }
}

class Staff implements Weapon {
    public String getDescription() {
        return "Enchanted Wooden Staff";
    }
}

class PlateArmor implements Armor {
    public String getDescription() {
        return "Heavy Plate Armor";
    }
}

class Robe implements Armor {
    public String getDescription() {
        return "Silk Spellcaster Robe";
    }
}

interface EquipmentFactory {
    Weapon createWeapon();
    Armor createArmor();
}

class WarriorEquipmentFactory implements EquipmentFactory {
    public Weapon createWeapon() {
        return new Sword();
    }

    public Armor createArmor() {
        return new PlateArmor();
    }
}

class MageEquipmentFactory implements EquipmentFactory {
    public Weapon createWeapon() {
        return new Staff();
    }

    public Armor createArmor() {
        return new Robe();
    }
}
