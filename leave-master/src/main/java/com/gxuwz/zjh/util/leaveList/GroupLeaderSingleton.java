package com.gxuwz.zjh.util.leaveList;

public class GroupLeaderSingleton {
    private final static GroupLeaderSingleton singleton = new GroupLeaderSingleton();
    private ApproveHandler approveHandler;

    public ApproveHandler getApproveHandler(){
        return approveHandler;
    }

    private GroupLeaderSingleton() {
        approveHandler = new GroupLeaderApproveHandler();
        // 处理器初始化
        DepartLeaderApproveHandler departLeaderHandler = new DepartLeaderApproveHandler();
        CTOApproveHandler ctoHandler = new CTOApproveHandler();
        approveHandler.setNext(departLeaderHandler);
        departLeaderHandler.setNext(ctoHandler);
    }

    public static GroupLeaderSingleton getInstance(){
        return singleton;
    }
}
