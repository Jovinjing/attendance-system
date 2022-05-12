package com.gxuwz.zjh.util.leaveList;

import java.util.HashMap;
import java.util.Map;

public class ChainHandleFactory {
    private Map<Integer,ApproveHandler> chainHandleMap;

    ChainHandleFactory(){
        chainHandleMap = new HashMap<>();
        chainHandleMap.put(1,GroupLeaderSingleton.getInstance().getApproveHandler());
        chainHandleMap.put(2,DepartLeaderSingleton.getInstance().getApproveHandler());
        chainHandleMap.put(3,CTOSingleton.getInstance().getApproveHandler());
    }

    public ApproveHandler getHandlerByType(Integer type){
        return chainHandleMap.get(type);
    }
}
