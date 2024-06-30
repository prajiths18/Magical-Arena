import java.util.Random;

class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;
    private Random dice;
    private int fixedAttackRoll = -1;
    private int fixedDefenseRoll = -1;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.dice = new Random();
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getStrength() {
        return strength;
    }

    public int getAttack() {
        return attack;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setFixedAttackRoll(int roll) {
        fixedAttackRoll = roll;
    }

    public void setFixedDefenseRoll(int roll) {
        fixedDefenseRoll = roll;
    }

    public void attack(Player defender) {
        int attackRoll = fixedAttackRoll != -1 ? fixedAttackRoll : dice.nextInt(6) + 1;
        int defenseRoll = defender.rollDefense();

        int attackDamage = attack * attackRoll;
        int defenseStrength = defender.getStrength() * defenseRoll;
        int damageDealt = Math.max(attackDamage - defenseStrength, 0);

        defender.reduceHealth(damageDealt);

        System.out.printf("%s attacks %s! Attack Roll: %d, Defense Roll: %d%n", name, defender.getName(), attackRoll, defenseRoll);
        System.out.printf("Damage Dealt: %d, %s's Health: %d%n", damageDealt, defender.getName(), defender.getHealth());
    }

    private int rollDefense() {
        return fixedDefenseRoll != -1 ? fixedDefenseRoll : dice.nextInt(6) + 1;
    }

    private void reduceHealth(int damage) {
        health -= damage;
    }
}