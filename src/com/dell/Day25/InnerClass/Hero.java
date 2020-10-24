package com.dell.Day25.InnerClass;

public class Hero {
    private String name;
    private int armor;
    private int movespeed;
    private int majectresistance;
    public int attack;

    public Hero(String name, int attack) {
        this.name = name;
        this.attack = attack;
    }

    public void hitEnemyCrystal(EnemyCrystal e) {
        e.blood -= Math.min(attack, (e).blood);
        System.out.printf("enermy get hurt , remain blood equals %d\n", e.blood);
    }

    class BattaleScore {
        private int kill;
        private int death;
        private int assistant;

        @Override
        public String toString() {
            return "BattaleScore{" +
                    "kill=" + kill +
                    ", death=" + death +
                    ", assistant=" + assistant +
                    '}';
        }

        public boolean lengedary() {
            return kill > 8;
        }
    }

    static class EnemyCrystal {
        public int blood = 10000;

        public boolean checkIfVictory() {
            return blood > 0;
        }
    }

    static class FollowHero extends com.dell.Day25.InnerClass2.Hero {
        private int attack;

        public FollowHero(int attack) {
            this.attack = attack;
        }

        @Override
        public void attack(Object e) {
            ((EnemyCrystal) e).blood -= Math.min(attack, ((Hero.EnemyCrystal) e).blood);
            System.out.printf("enermy get hurt , remain blood equals %d\n", ((EnemyCrystal) e).blood);
        }
    }


}
