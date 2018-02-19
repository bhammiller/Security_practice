package com.example.demo.Security;

import org.springframework.data.repository.CrudRepository;

public interface UserListRepository extends CrudRepository<UserList, Long> {
    UserList findByUsername(String username);
    UserList findByEmail(String email);
    Long countByEmail(String email);
    Long countByUsername(String username);

}
