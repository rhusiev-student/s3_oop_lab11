package nl.r1a.task2;

import lombok.Getter;

enum Sex {
    MALE, FEMALE
}

@Getter
public class Client {
    private static int counter = 0;
    private int id;
    private String name;
    private int age;
    private Sex sex;

    public Client(String name, int age, Sex sex) {
        this.id = counter;
        this.name = name;
        this.age = age;
        this.sex = sex;
        counter++;
    }

    public Client(String name, int age, String sex) {
        this.id = counter;
        this.name = name;
        this.age = age;
        this.sex = Sex.valueOf(sex);
        counter++;
    }
}
