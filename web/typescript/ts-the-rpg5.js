// 定义什么是勇者
var Hero = /** @class */ (function () {
    // 召唤一个勇者的规则
    function Hero(name, hp) {
        this.name = name;
        this.hp = hp;
    }
    return Hero;
}());
// 召唤一个勇者
var hero = new Hero("勇者", 10);
// 只能由勇者通过的路
function hello(hero) {
    console.log("Hello , " + hero.name);
}
hello(hero);
// 伪装成勇者的史莱姆
hello({ name: "我不是史莱姆", hp: 1 });
