package com.banyuan;

import java.util.Arrays;

public class Company {
    //老板
    private Person owner;
    //部门
    private Department[] departments=new Department[10];
    //产品
    private Production production;
    //pcount 部门数
    private int pcount;
    public Company(Person owner) {
        this.owner = owner;
    }
    public void addDepartment(Department department){
        if(pcount>=(departments.length*3)/4){
            Department[] copy = Arrays.copyOf(departments, departments.length*2);
            departments=copy;
        }
//        for (Department depart : departments) {
//            if(depart==null){
//                depart=department;
//                pcount++;
//                break;
//            }
//        }
        for (int i = 0; i < departments.length; i++) {
            if(departments[i]==null){
                departments[i]=department;
                pcount++;
                break;
            }
        }
    }

    public boolean deleteDepartment(String name){
        Department department = searchDepartment(name);
        if(department!=null){
            for (int i = 0; i < pcount; i++) {
                if(department.equals(departments[i])){
                    if(i==(pcount-1)){
                        departments[i]=null;
                    }else{
                        for (int j = i; j <pcount ; j++) {
                            departments[j]=departments[j+1];
                        }
                    }
                    pcount--;
                    return true;
                }
            }
        }
        return false;
    }

    public Department searchDepartment(String name){
        for (Department department : departments) {
            if(department.getName()==name){
                return department;
            }
        }
        return null;
    }

    public boolean updateDepartment(Department department){
        for (int i = 0; i < pcount; i++) {
            if(departments[i].getName().equals(department.getName())){
                departments[i]=department;
                return true;
            }
        }
        return false;
    }

    public void print(){
        System.out.println(owner);
        for (int i = 0; i < pcount; i++) {
            System.out.println(departments[i].getName());
            departments[i].print();
            System.out.println("==========");
        }
    }

    public static void main(String[] args) {
        Company company = getCompany();
        company.print();
    }

    private static Company getCompany() {
        Person boss = new Person("王富贵", 1, "老板");
        Company company = new Company(boss);
        Department department1 = new Department("招生部");
        Person p1 = new Person("张三", 2, "经理");
        Person p2 = new Person("张四", 3, "职员");
        Person p3 = new Person("张五", 4, "职员");
        department1.add(p1);
        department1.add(p2);
        department1.add(p3);
        company.addDepartment(department1);
        Department department2 = new Department("研发部");
        Person p4 = new Person("李三", 5, "经理");
        Person p5 = new Person("李四", 6, "职员");
        Person p6 = new Person("李五", 7, "职员");
        department2.add(p4);
        department2.add(p5);
        department2.add(p6);
        company.addDepartment(department2);
        Department department3 = new Department("教学部");
        Person p7 = new Person("王三", 8, "经理");
        Person p8 = new Person("王四", 9, "职员");
        Person p9 = new Person("王五", 10, "职员");
        department3.add(p7);
        department3.add(p8);
        department3.add(p9);
        company.addDepartment(department3);
        Department department4 = new Department("后勤部");
        Person p10 = new Person("赵六", 11, "职员");
        department4.add(p10);
        company.addDepartment(department4);
        return company;
    }
}
