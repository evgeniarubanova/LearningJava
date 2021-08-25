package entities;

public class User {

    private String name;
    private String surname;
    private String address;
    private String number;
    private int id;

    public User(String name, String surname, String address, String number) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
    }

    public User(String name, String surname, String address, String number, int id) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.number = number;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}
