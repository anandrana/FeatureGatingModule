package account;

public class Address {
    private String houseNumber;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public Address(String houseNumber, String street, String city, String state, String country, String pinCode){
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String toString(){
        StringBuilder str = new StringBuilder();
        str.append("Address = {\n");
        str.append("\t\tHouseNumber = ").append(houseNumber).append("\n");
        str.append("\t\tStreet = ").append(street).append("\n");
        str.append("\t\tCity = ").append(city).append("\n");
        str.append("\t\tState = ").append(state).append("\n");
        str.append("\t\tCountry = ").append(country).append("\n");
        str.append("\t\tPinCode = ").append(pinCode).append("\n");
        str.append("\t\t}");
        return str.toString();
    }

}
