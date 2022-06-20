import com.google.gson.Gson;

class GsonTest {
    public static void main(String[] args) {
        String json = "{\n" +
                "  \"name\": \"Bill\",\n" +
                "  \"age\": 30,\n" +
                "  \"married\": true,\n" +
                "  \"height\": 1.78\n" +
                "}";

        Person person = new Gson().fromJson(json, Person.class);
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.isMarried());
        System.out.println(person.getHeight());
    }
}

class Person {
    private String name;
    private int age;
    private boolean married;
    private double height;

    public Person(String name, int age, boolean married, double height) {
        this.name = name;
        this.age = age;
        this.married = married;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isMarried() {
        return married;
    }

    public double getHeight() {
        return height;
    }
}