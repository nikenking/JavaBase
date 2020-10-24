package com.dell.Day24.Testing3;

public class Province extends StateCouncil implements CentralPartyCommittee{
    @Override
    void safetyinProduction() {
        System.out.println("我们各省人民一定按照谷物源的只是进行安全生产！");
    }

    @Override
    public void partyLeader() {
        System.out.println("我们各省人民一定坚持党的领导");
    }
}
