package assignment7.part1;

public class User {
    private String name;
    private int age;
    private String address;
    private String phoneNumber;
    private String bankAccountNumber;

    public User(String name, int age, String phoneNumber, String bankAccountNumber) {
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.bankAccountNumber = bankAccountNumber;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }
}
