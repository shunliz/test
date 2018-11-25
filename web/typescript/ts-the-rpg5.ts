// 定义什么是勇者
class Hero {
    name: string;   // 每个勇者都有一个名字
    hp: number;     // 每个勇者有自己的HP值
    // 召唤一个勇者的规则
    constructor(name: string, hp: number) {
        this.name = name;
        this.hp = hp;
    }
}

// 召唤一个勇者
var hero = new Hero("勇者", 10);

// 只能由勇者通过的路
function hello(hero: Hero) {
    console.log("Hello , " + hero.name);
}

hello(hero);
// 伪装成勇者的史莱姆
hello({ name: "我不是史莱姆", hp: 1 });