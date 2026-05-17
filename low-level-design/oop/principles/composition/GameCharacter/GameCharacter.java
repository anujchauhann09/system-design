class GameCharacter {
    String name;
    WeaponStrategy weapon;
    MovementStrategy movement;
    AttackStrategy attack;

    GameCharacter(String name, WeaponStrategy weapon, MovementStrategy movement, AttackStrategy attack) {
        this.name = name;
        this.weapon = weapon;
        this.movement = movement;
        this.attack = attack;
    }

    void perform() {
        weapon.useWeapon();
        movement.move();
        attack.attack();
    }
}
