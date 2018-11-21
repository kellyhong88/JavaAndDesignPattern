package com.learning.java.designPattern.stratery;

public class DuckSimulator {

    public static void main(String[] args) {

        Duck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.swim();
        mallardDuck.fly();
        mallardDuck.quack();

        Duck decoyDuck = new DecoyDuck();
        decoyDuck.display();
        decoyDuck.swim();
        decoyDuck.fly();
        decoyDuck.quack();

        decoyDuck.setFlyBehavior(new FlyWithWings());
        decoyDuck.fly();

        decoyDuck.setQuackBehavior(new QuackSound());
        decoyDuck.quack();
    }

}
