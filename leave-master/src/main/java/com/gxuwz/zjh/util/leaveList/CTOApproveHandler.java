package com.gxuwz.zjh.util.leaveList;

public class CTOApproveHandler extends ApproveHandler {
    @Override
    public void doHandler(int size) {
        state = 3;
        if (size > 3) {
            return;
        }
    }
}
