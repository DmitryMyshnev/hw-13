package Users;

import Users.Address;
import Users.Geo;

import java.util.ArrayList;

public class User {
    private Long id;
    private String name;
    private String username;
    private String email;
    private Address address;

    private String phone;
    private String website;
    private Company company;

    public User(long id, String name, String username, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public Address getAddress() {
        return address;
    }
    public String getPhone() {
        return phone;
    }
    public String getWebsite() {
        return website;
    }
    public Company getCompany() {
        return company;
    }
    public static int compare(User u1,User u2){
        if(u1.getId() > u2.getId())
            return 1;
        return -1;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}';
    }
}
