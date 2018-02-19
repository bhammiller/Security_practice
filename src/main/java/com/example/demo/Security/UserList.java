package com.example.demo.Security;
import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class UserList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name ="email",nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "username")
    private String username;

    public Boolean getUsertype() {
        return usertype;
    }

    public void setUsertype(Boolean usertype) {
        this.usertype = usertype;
    }

    @Column(name = "usertype")
    private Boolean usertype;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<com.example.demo.Security.RoleList> roles;

    public UserList() {
        this.roles = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<com.example.demo.Security.RoleList> getRoles() {
        return roles;
    }

    public void setRoles(Collection<com.example.demo.Security.RoleList> roles) {
        this.roles = roles;
    }

    public void addRole(com.example.demo.Security.RoleList r)
    {
        this.roles.add(r);
    }
}
