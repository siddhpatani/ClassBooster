package com.eduware.classbooster;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

public class ClassBoosterApp extends Application {
    protected RoomInfo roomInfo;
    protected List<Student> roster;

    public RoomInfo getRoomInfo(){
        return roomInfo;
    }

    public void setRoomInfo(RoomInfo r){
        roomInfo = r;
    }

    public List<Student> getRoster() {
        return roster;
    }

    public void setRoster(List<Student> roster) {
        this.roster = roster;
    }
}
