package account;

import utils.EnumList;

public abstract class Person {
    protected String name;
    protected Address address;
    protected String email;
    protected String phone;
    protected EnumList.Gender gender;
    protected int age;


    public Person(String name, Address address, String email, String phone, EnumList.Gender gender, int age){
        this.name = name;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.age = age;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Person = {\n");
        str.append("\tName = ").append(name).append("\n");
        str.append("\t").append(address.toString()).append("\n");
        str.append("\tEmail = ").append(email).append("\n");
        str.append("\tPhone = ").append(phone).append("\n");
        str.append("\tGender = ").append(gender.toString()).append("\n");
        str.append("\tAge = ").append(age).append("\n");
        str.append("}");
        return str.toString();
    }
}
