package com.gxuwz.zjh.util.leaveList;

public class DepartLeaderSingleton {
    private final static DepartLeaderSingleton singleton = new DepartLeaderSingleton();
    private ApproveHandler approveHandler;

    public ApproveHandler getApproveHandler(){
        return approveHandler;
    }

    private DepartLeaderSingleton() {
        approveHandler = new DepartLeaderApproveHandler();
        // 处理器初始化
        CTOApproveHandler ctoHandler = new CTOApproveHandler();
        approveHandler.setNext(ctoHandler);
    }

    public static DepartLeaderSingleton getInstance(){
        return singleton;
    }
}
