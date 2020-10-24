package com.dell.week4.service.npc;


import com.dell.week4.model.Npc;
import com.dell.week4.util.SlowPrint;

/**
 * 可以将具体的npc类共有的部分提取出来
 */
public abstract class AbstractNpcService implements NpcService {
    Npc npc = new Npc();
    @Override
    public void welcome() {
        // 输出npc的名字和台词
        SlowPrint.print(npc.getNpcName() + "：" + npc.getDialogue());

    }
}
