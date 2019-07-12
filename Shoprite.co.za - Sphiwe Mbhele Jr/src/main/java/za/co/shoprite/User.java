package za.co.shoprite;

import com.ebay.xcelite.annotations.Column;

public class User {

    @Column(name="FirstName")
    private String firstName;



    @Column(name="LastName")
    private String lastName;



    @Column(name="Username")
    private String username;

    @Column(name="Password")
    private String password;

    @Column(name="CustomerType")
    private String customerType;

    @Column(name="Role")
    private String role;

    @Column(name="Email")
    private String email;

    @Column(name="Cellphone")
    private String cellphone;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCustomerType() {
        return customerType;
    }

    public String getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

}
