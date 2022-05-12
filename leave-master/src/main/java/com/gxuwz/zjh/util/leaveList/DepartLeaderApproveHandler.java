package com.gxuwz.zjh.util.leaveList;

public class DepartLeaderApproveHandler extends ApproveHandler {
    @Override
    public void doHandler(int size) {
        state = 2;
        if (size <= 3) {
            return;
        }
        next.doHandler(size);
    }
}
