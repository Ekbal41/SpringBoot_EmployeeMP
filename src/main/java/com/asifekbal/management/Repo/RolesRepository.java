package com.asifekbal.management.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.asifekbal.management.Shema.Role;

public interface RolesRepository extends JpaRepository<Role,Integer> {

    Role findByName(String string);
    
}