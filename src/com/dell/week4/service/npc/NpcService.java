package com.dell.week4.service.npc;


import com.dell.week4.model.Player;

public interface NpcService {
    /**
    * 当玩家访问时打招呼并自我介绍
    */
    void welcome();

    /**
     * 对玩家提供相应的帮助
     *
     * @param player
     *            访问NPC的玩家
     */
    void helpPlayer(Player player);

}
