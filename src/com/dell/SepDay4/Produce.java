package com.dell.SepDay4;

class Goods {
    private int number = 10;

    public synchronized void productGoods() throws InterruptedException {

        if (number < 20) {
            System.out.println(Thread.currentThread().getName() + "开始生产第" + (number + 1) + "个产品");
            number++;
            notify();
        }else wait();
    }

    public synchronized void purchaseGoods() throws InterruptedException {
        if (number >= 1) {
            System.out.println(Thread.currentThread().getName() + "消费了第" + (number) + "个产品");
            number--;
            notify();
        }else wait();
    }
}

class Product implements Runnable {
    private Goods goods;

    public Product(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(100);
                goods.productGoods();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

class Cosumer implements Runnable {
    private Goods goods;

    public Cosumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public synchronized void run() {
        try {
            while (true) {
                Thread.sleep(110);
                goods.purchaseGoods();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Produce {/*来个产品共享数量，当数量小于20生产，当数量>0开始消费*/

    public static void main(String[] args) {
        Goods goods = new Goods();
        Product th1 = new Product(goods);
        Cosumer th2 = new Cosumer(goods);
        Thread thread1 = new Thread(th1);
        Thread thread2 = new Thread(th2);
        thread1.setName("生产者");
        thread2.setName("消费者");
        thread1.start();
        thread2.start();
    }
}
