class Hero {
    name: string;
    private hp: number;
    // 勇者的召唤方式
    constructor(name: string, hp: number) {
        this.name = name;
        this.hp = hp;
    }
}

// 通过extends继承了勇者之力
class Warrior extends Hero {
    weapon: string;
    // 战士的召唤方式
    constructor(name: string, hp: number , weapon: string) {
        // 你的名字和你的血液是勇者的名字和勇者的血液，这是你的内心
        super(name, hp);
        this.weapon = weapon;
    }
    swing() {
        console.log("swing");
    }
}

// 通过extends继承了勇者之力
class Magician extends Hero {
    weapon: string;
    // 魔法师的召唤方式
    constructor(name: string, hp: number , weapon: string) {
        // 你的名字和你的血液是勇者的名字和勇者的血液，这是你的内心
        super(name, hp);
        this.weapon = weapon;
    }
    fireball() {
        console.log("fireball");
    }
}

// 通过extends继承了勇者之力
class Archer extends Hero {
    weapon: string;
    // 弓箭手的召唤方式
    constructor(name: string, hp: number , weapon: string) {
        // 你的名字和你的血液是勇者的名字和勇者的血液，这是你的内心
        super(name, hp);
        this.weapon = weapon;
    }
    shoot() {
        console.log("shoot");
    }
}

function forest(hero: Hero) {
    console.log("Enter Forest !!");
}

var hero1 = new Warrior("warrior", 10, "sword");
var hero2 = new Magician("magician", 10, "wand");
var hero3 = new Archer("archer", 10, "bow");

forest(hero1);
forest(hero2);
forest(hero3);



class Weapon {
    name: string;
    private atk: number;
    constructor(name: string, atk: number) {
        this.name = name;
        this.atk = atk;
    }
}

class Sword extends Weapon {
    constructor(name: string, atk: number) {
        super(name, atk);
    }
    swing() {
        console.log("swing");
    }
}

class Wand extends Weapon {
    constructor(name: string, atk: number) {
        super(name, atk);
    }
    fireball() {
        console.log("fireball");
    }
}

class Bow extends Weapon {
    constructor(name: string, atk: number) {
        super(name, atk);
    }
    shoot() {
        console.log("shoot");
    }
}

