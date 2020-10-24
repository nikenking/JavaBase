package com.dell.Day25.InnerClass;

import com.dell.Day24.Testing4.Teacher;

import java.net.http.WebSocket;

public class Test {
    class SomeHero extends com.dell.Day25.InnerClass2.Hero {
        private int attack;
        private String name;

        public SomeHero(String name, int attack) {
            this.attack = attack;
            this.name = name;
        }

        @Override
        public String toString() {
            return "SomeHero{" +
                    "name='" + name + '\'' +
                    '}';
        }

        @Override
        public void attack(Object e) {
            ((Hero.EnemyCrystal) e).blood -= Math.min(attack, ((Hero.EnemyCrystal) e).blood);
            System.out.printf("enermy get hurt , remain blood equals %d\n", ((Hero.EnemyCrystal) e).blood);
        }
    }

    public static void main(String[] args) {
        Hero blind = new Hero("blind", 500);
        Hero.FollowHero flame = new Hero.FollowHero(500);
        Test test = new Test();
        SomeHero flash = test.new SomeHero("flash",300);
        Hero.EnemyCrystal enermy = new Hero.EnemyCrystal();
        while (enermy.checkIfVictory()) {
            blind.hitEnemyCrystal(enermy);
            flame.attack(enermy);
            flash.attack(enermy);

        }
    }
}
