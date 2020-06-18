package com.eduware.classbooster;

public class RoomInfo {
    protected int span;
    protected int depth;
    protected int seatingType;

    public RoomInfo(int s, int d, int sT){
        span = s;
        depth = d;
        seatingType = sT;
    }

    public int getSpan(){
        return span;
    }
    public int getDepth(){
        return depth;
    }
    public int getSeatingType(){
        return seatingType;
    }
}
