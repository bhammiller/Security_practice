package com.example.demo.Security;

import org.springframework.data.repository.CrudRepository;

public interface RoleListRepository extends CrudRepository<RoleList, Long> {
    RoleList findByRole(String role);
}
