package com.dell.DayTest;

import javax.crypto.spec.PSource;
import java.util.*;

public class StackPopUpOderCopy {
    public static int[] turnToInt(List<String> list){
        int[] ret = new int[list.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.parseInt(list.get(i));
        }
        return ret;
    }
    public static boolean isOrder(int[] pushA, int[] popA) {
        // 判断标志
        boolean isPossibal = false;
        if (pushA != null && popA != null) {
            Stack<Integer> stack = new Stack<Integer>();
            int i = 0, j = 0;
            // 检查每一个出栈
            while (j < popA.length) {
                // 将pushA中的每一个数与popA[j]进行比较，如果不相等则把pushA[i]压入栈，如果相等则同时越过。
                while (i < pushA.length && pushA[i] != popA[j]) {
                    stack.push(pushA[i]);
                    i++;
                }
                i++;
                j++;
                // 检查已入栈的数是否和下一个出栈数相等,如果相等进行下一个数的比较，如果不等把出栈的数压回
                while (!stack.isEmpty() && j < popA.length) {
                    int top = 0;
                    if ((top = stack.pop()) == popA[j]) {
                        j++;
                    } else {
                        stack.push(top);
                        break;
                    }
                }
                if (i >= pushA.length && stack.isEmpty()) {
                    isPossibal = true;
                }
            }
        }
        return isPossibal;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> oder1 = new ArrayList<String>(Arrays.asList(sc.nextLine().split(" ")));
        List<String> oder2 = new ArrayList<>(Arrays.asList(sc.nextLine().split(" ")));
        int[] push = turnToInt(oder1);
        int[] pop = turnToInt(oder2);
        System.out.println(isOrder(push,pop));
    }
}
