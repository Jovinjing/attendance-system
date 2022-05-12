package com.gxuwz.zjh.util.leaveList;

public abstract class ApproveHandler {
    protected ApproveHandler next;
    int state;
    /**
     * 指定下一个处理者
     */
    public void setNext(ApproveHandler approveHandler) {
        this.next = approveHandler;
    }
    /**
     * 处理审批请假天数
     */
    public abstract void doHandler(int size);
}
