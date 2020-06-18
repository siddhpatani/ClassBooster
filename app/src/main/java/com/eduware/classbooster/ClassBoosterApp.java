package com.eduware.classbooster;

import android.app.Application;

public class ClassBoosterApp extends Application {
    protected RoomInfo roomInfo;

    public RoomInfo getRoomInfo(){
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo r){
        roomInfo = r;
    }

}
