package banyuan;

public class Person {
    private String name;
    private String id;
    private String type;

    public Person() {
    }

    public Person(String name, String id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'';

    }
}
