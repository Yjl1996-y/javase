package banyuan;

import java.util.Arrays;

public class Department {
    private String name;
    private Person[] staff=new Person[10];
    private int count;
    private String partid;
    public Department(String name,String partid) {
        this.name = name;
        this.partid=partid;
    }

    public void add(Person person){
        if(count>=(staff.length*3)/4){
            Person[] newstaff = Arrays.copyOf(staff,staff.length*2);
            staff=newstaff;
        }
        for (int i = 0; i < staff.length; i++) {
            if(staff[i]==null){
                person.setId(partid+person.getId());
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

    public void delete(String id){
        for (int i = 0; i <count ; i++) {
            if(staff[i].getId().equals(id)){
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
    public Person search(String id){
        for (Person one : staff) {
            if(one.getId().equals(id)){
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

    public String getPartid() {
        return partid;
    }

    public void setPartid(String partid) {
        this.partid = partid;
    }

    public Person[] getStaff() {
        return staff;
    }

    public void setStaff(Person[] staff) {
        this.staff = staff;
    }
}
