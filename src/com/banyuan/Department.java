package com.banyuan;

import java.util.Arrays;

public class Department {
    private String name;
    private Person[] staff=new Person[10];
    private int count;

    public Department(String name) {
        this.name = name;
    }

    public void add(Person person){
        if(count>=(staff.length*3)/4){
            Person[] newstaff = Arrays.copyOf(staff,staff.length*2);
            staff=newstaff;
        }
        for (int i = 0; i < staff.length; i++) {
            if(staff[i]==null){
                staff[i]=person;
                count++;
                break;
            }
        }
//        for (Person one : staff) {
//            if(one==null){
//                one=person;
//                count++;
//                break;
//            }
//        }
    }

    public void delete(int id){
        for (int i = 0; i <count ; i++) {
            if(staff[i].getId()==id){
                if(i==(count-1)){
                    staff[i]=null;
                    count--;
                }else{
                    for (int j = i; j <count ; j++) {
                        staff[j]=staff[j+1];
                    }
                    count--;
                }
            }
        }
    }
    public Person search(int id){
        for (Person one : staff) {
            if(one.getId()==id){
                return one;
            }
        }
        return null;
    }

    public boolean update(Person person){
        Person p = search(person.getId());
        if(p!=null){
            p.setType(person.getType());
            p.setName(person.getName());
            return true;
        }
        return false;
    }

    public void print(){
        for (Person person : staff) {
            if(person != null){
                System.out.println(person);
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
