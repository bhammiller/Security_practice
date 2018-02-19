package com.example.demo.Security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class RoleList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true)
    private String role;

    @ManyToMany(mappedBy = "roles",fetch = FetchType.LAZY)
    private Collection<UserList> users;

    public RoleList() {
        this.users = new ArrayList<>();
    }

    public RoleList(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Collection<UserList> getUsers() {
        return users;
    }

    public void setUsers(Collection<UserList> users) {
        this.users = users;
    }
}
