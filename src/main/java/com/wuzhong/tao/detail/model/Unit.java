package com.wuzhong.tao.detail.model;

/**
 * Created by wuzhong on 14-9-2.
 */
public class Unit {

    public String value;

    public int type;

    public Unit(String value, int type) {
        this.value = value;
        this.type = type;
    }

    private Callback callback;

    public void registerCallback(Callback callback){
        this.callback = callback;
    }

    public static interface Callback{
        void onData(Unit unit);
    }

}
