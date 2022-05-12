package com.gxuwz.zjh.util.leaveList;

public class GroupLeaderApproveHandler extends ApproveHandler {
    @Override
    public void doHandler(int size) {
        state = 1;
        if (size <= 1) {
            return;
        }
        next.doHandler(size);
    }
}
