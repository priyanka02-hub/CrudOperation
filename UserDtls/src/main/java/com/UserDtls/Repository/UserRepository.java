package com.UserDtls.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.UserDtls.Entity.Users;


@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {

}
