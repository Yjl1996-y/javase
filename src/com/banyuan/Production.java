package com.banyuan;

public class Production {
    private String name;
    private String work;

    public Production() {
    }

    public Production(String name, String work) {
        this.name = name;
        this.work = work;
    }

    @Override
    public String toString() {
        return "Production{" +
                "name='" + name + '\'' +
                ", work='" + work + '\'' +
                '}';
    }
}
