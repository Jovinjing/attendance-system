package com.gxuwz.zjh.util.leaveList;

public class CTOSingleton {
    private final static CTOSingleton singleton = new CTOSingleton();
    private ApproveHandler approveHandler;

    public ApproveHandler getApproveHandler(){
        return approveHandler;
    }

    private CTOSingleton() {
        approveHandler = new CTOApproveHandler();
    }

    public static CTOSingleton getInstance(){
        return singleton;
    }
}
