package com.nsu.strange;
import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        System.out.println("测试环形数组");
        //测试一把
        //创建一个环形队列
        //说明设置为4，其队列的有效数据最大是3
        CircleArray arrayQueue = new CircleArray(4);
        char key = ' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出队列");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);//接收字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    arrayQueue.showQueue();
                    break;
                case 'g'://取出数据
                    try {
                        int res = arrayQueue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头的数据
                    try {
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n",res);
                    } catch (Exception e) {

                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e'://退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }

        }
        System.out.println("程序退出");
    }
}

class CircleArray{
    private int maxSize;//表示数组的最大容量
    private int front;
    //front 变量的含义做一个调整：front 就指向队列的第一个元素
    //也就是说arr[front],初始值为0；
    private int rear;
    //rear变量的含义做了一个调整：rear指向队列的最后一个元素
    //的后一个位置，因为希望空出一个空间作为约定，rear初始值为0；
    private int[] arr;//该数据用于存放数据，模拟队列

    public CircleArray(int arrMaxSize){
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满
    public boolean isFull() {
        System.out.printf("添加前front = %d rear = %d\n",front,rear);
        return ((rear + 1) % maxSize) ==front ;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，不能加入数据~");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，取余
        rear = (rear + 1) % maxSize;
        System.out.printf("添加后front = %d rear = %d\n",front,rear);

    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常处理
            throw new RuntimeException("队列空，不能取数据");
        }
        //这里需要分析出front是指向队列的第一个元素
        //1.先把front对应的值保留到一个临时变量
        //2.将front后移
        //3.将临时变量返回
        System.out.printf("取之前 front = %d rear = %d\n",front,rear);
        int value = arr[front];
        arr[front] = 0;
        front = (front+1)%maxSize;
        System.out.printf("取值后front = %d rear = %d\n",front,rear);
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列为空，没有数据~~");
            return;
        }
        //思路：front开始遍历，遍历多个元素

        for (int i = front; i < front+size(); i++) {
            System.out.printf("arr[%d]=%d\n", i%maxSize, arr[i%maxSize]);
        }
    }

    //求出当前队列有效数据的个数
    public int size(){
        return (rear+maxSize-front)%maxSize;
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue() {
        //判断
        if (isEmpty()) {
            //System.out.println("队列为空，没有数据~~");
            throw new RuntimeException("队列为空，没有数据~~");
        }
        return arr[front];
    }



}
