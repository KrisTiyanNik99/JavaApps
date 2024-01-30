public class Bsks {
    private String name;
    private int age;

    public Bsks(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Bsks() {
        this.age = 0;
        this.name = "Test1";
    }

    public Object[] toTableRow() {

        return new Object[]{
                age, name
        };
    }
}
