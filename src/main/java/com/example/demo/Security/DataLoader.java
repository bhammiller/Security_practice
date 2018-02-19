package com.example.demo.Security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner{



    @Autowired
    RoleListRepository roleListRepository;

    @Override
    public void run(String... strings) throws Exception{
        System.out.println("Loading data ...");
        roleListRepository.save(new RoleList("EMPLOYER"));
        roleListRepository.save(new RoleList("APPLICANT"));
        roleListRepository.save(new RoleList("ADMIN"));
    }

}