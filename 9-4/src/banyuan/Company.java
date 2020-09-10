package banyuan;

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

    public Person find(String id){
        for (int i = 0; i <pcount; i++) {
            if(id.contains(departments[i].getPartid())){
                Person[] staff = departments[i].getStaff();
                if(staff[0].getType().equals("经理")){
                    return staff[0];
                }
            }

        }
        return owner;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Department[] getDepartments() {
        return departments;
    }

    public void setDepartments(Department[] departments) {
        this.departments = departments;
    }

    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }

    public int getPcount() {
        return pcount;
    }

    public void setPcount(int pcount) {
        this.pcount = pcount;
    }

    public static void main(String[] args) {
        Company company = getCompany();
        company.print();
        System.out.println(company.find("103001"));
    }



    private static Company getCompany() {
        Person boss = new Person("王富贵", "1", "老板");
        Company company = new Company(boss);
        Department department1 = new Department("招生部","100");
        Person p1 = new Person("张三", "001", "经理");
        Person p2 = new Person("张四", "002", "职员");
        Person p3 = new Person("张五", "003", "职员");
        department1.add(p1);
        department1.add(p2);
        department1.add(p3);
        company.addDepartment(department1);
        Department department2 = new Department("研发部","101");
        Person p4 = new Person("李三", "001", "经理");
        Person p5 = new Person("李四", "002", "职员");
        Person p6 = new Person("李五", "003", "职员");
        department2.add(p4);
        department2.add(p5);
        department2.add(p6);
        company.addDepartment(department2);
        Department department3 = new Department("教学部","102");
        Person p7 = new Person("王三", "001", "经理");
        Person p8 = new Person("王四", "002", "职员");
        Person p9 = new Person("王五", "003", "职员");
        department3.add(p7);
        department3.add(p8);
        department3.add(p9);
        company.addDepartment(department3);
        Department department4 = new Department("后勤部","103");
        Person p10 = new Person("赵六", "001", "职员");
        department4.add(p10);
        company.addDepartment(department4);
        return company;
    }
}
