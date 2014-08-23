package com.vivetest.app;

import java.util.Observable;

/**
 * Created by 9020MT on 2014/8/23.
 * create object for watching
 */
public class MyPerson extends Observable {
    private int age;
    private String name;
    private String sex;

    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
        setChanged();
        notifyObservers();
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
        setChanged();
        notifyObservers();
    }
    public String getSex(){
        return sex;
    }
    public void setSex(String sex){
        this.sex = sex;
        setChanged();
        notifyObservers();
    }
    public String toString(){
        return "MyPerson[age="+age+",name="+name+",sex="+sex+"]";
    }
}
