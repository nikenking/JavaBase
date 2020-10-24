package com.dell.week4.data;


import com.dell.week4.model.Npc;

public class NpcData {
    /**
     * 医师Npc静态实例
     */
    public static Npc npcDoctor = new Npc();

    /**
     * 技能导师Npc静态实例
     */
    public static Npc npcMaster = new Npc();

    static {

        // 为医师Npc静态实例属性赋值
        npcDoctor.setNpcName("华医师");
        npcDoctor.setDialogue("一手交钱(指20两)，一手救命。交吗？(Y/N)");
        // 为技能导师Npc静态实例属性赋值
        npcMaster.setNpcName("路边大师");
        npcMaster.setDialogue("小朋友，我看你天赋异禀、骨骼惊奇，想来是百年难得一见的练武奇才！\n这些秘籍与你有缘，就便宜卖给你了，选一本吧：");

    }
}
