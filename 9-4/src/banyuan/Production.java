package banyuan;

public class Production {
    private String name;
    private String effect;

    public Production() {
    }

    public Production(String name, String work) {
        this.name = name;
        this.effect = work;
    }

    @Override
    public String toString() {
        return "Production{" +
                "name='" + name + '\'' +
                ", work='" + effect + '\'' +
                '}';
    }
}
