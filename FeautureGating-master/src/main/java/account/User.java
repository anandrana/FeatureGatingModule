package account;

import utils.EnumList;

public class User extends Person {

    double pastOrderAmount;
    EnumList.PreferredModeOfPayment preferredModeOfPayment;
    EnumList.CustomerType customerType;
    EnumList.AccountType accountType;

    public User(String name, Address address, String email, String phone, EnumList.Gender gender, int age, double pastOrderAmount, EnumList.PreferredModeOfPayment preferredModeOfPayment, EnumList.CustomerType customerType, EnumList.AccountType accountType){
        super(name, address, email, phone, gender, age);
        this.pastOrderAmount = pastOrderAmount;
        this.preferredModeOfPayment = preferredModeOfPayment;
        this.customerType = customerType;
        this.accountType = accountType;
    }

    public String getName(){
        return this.name;
    }
    public String getGender() {
        return gender.toString();
    }
    public double getPastOrderAmount() {
        return pastOrderAmount;
    }
    public int getAge() {
        return age;
    }
    public String getAddress(){
        return address.toString();
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getHouseNumber() {
        return address.getHouseNumber();
    }
    public String getStreet() {
        return address.getStreet();
    }
    public String getCity() {
        return address.getCity();
    }
    public String getState() {
        return address.getState();
    }
    public String getCountry() {
        return address.getCountry();
    }
    public String getPinCode() {
        return address.getPinCode();
    }
    public String getPreferredModeOfPayment() {
        return preferredModeOfPayment.toString();
    }
    public String getCustomerType() {
        return customerType.toString();
    }
    public String getAccountType() {
        return accountType.toString();
    }
    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("User = {\n").append(super.toString()).append("\n");
        str.append("PastOrderAmount = ").append(pastOrderAmount).append("\n");
        str.append("PreferredModeOfPayment = ").append(preferredModeOfPayment.toString()).append("\n");
        str.append("CustomerType = ").append(customerType.toString()).append("\n");
        str.append("AccountType = ").append(accountType.toString()).append("\n");
        str.append("}");
        return str.toString();
    }
}
