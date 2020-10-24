package com.dell.week4.service.npc;

import com.dell.week4.data.NpcData;
import com.dell.week4.data.SkillData;
import com.dell.week4.model.Player;
import com.dell.week4.model.Skill;
import com.dell.week4.util.InputCheck;
import com.dell.week4.util.SlowPrint;

import java.util.List;

/**
 * 包含回复导师npc的具有的方法
 */
public class NpcDoctorService extends AbstractNpcService {
    /**
     * 构造方法，在实例化医师npc时生效
     */
    public NpcDoctorService() {
        // 给从父类继承的npc对象进行赋值
        this.npc = NpcData.npcDoctor;
    }

    /**
     * 支付金币进行治疗
     *
     * @param player
     */
    @Override
    public void helpPlayer(Player player) {
        SlowPrint.print(npc.getNpcName() + " : " + npc.getDialogue());
        int pay = player.getMoney() - 20;
        if ("y".equals(InputCheck.checkInput("y Y n N").toLowerCase())) {
            if (pay > 0) {
                player.setMoney(pay);
                if (player.getHp()!=player.getMaxHp()){
                    player.setHp(player.getMaxHp());
                    SlowPrint.print("你已经恢复如初，欢迎下次再来");
                }else SlowPrint.print("你治疗了个寂寞");
                SlowPrint.print("当前家当还有：" + player.getMoney() + "两");
            } else SlowPrint.print("钱不够，救不了，早点埋");
        } else {
            SlowPrint.print("铁公鸡是真的牛皮,告辞");
        }
    }
}

