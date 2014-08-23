package com.vivetest.app;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by 9020MT on 2014/8/23.
 * I'm observer
 */
public class MyObserver implements Observer {
    private int i;
    private MyPerson myPerson;

    public MyObserver(int i ){
        //我是观察者
        this.i = i;
    }
    public int getI(){
        return i;
    }
    public void setI(int i){
        this.i = i;
    }
    public MyPerson getMyPerson(){
        return myPerson;
    }
    public void setMyPerson(MyPerson myPerson){
        this.myPerson = myPerson;
    }
    @Override
    public void update(Observable observable, Object o) {
        this.myPerson = (MyPerson)observable;
        System.out.println(this.myPerson.toString());
    }
}
