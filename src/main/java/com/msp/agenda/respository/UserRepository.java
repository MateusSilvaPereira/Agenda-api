package com.msp.agenda.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msp.agenda.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
