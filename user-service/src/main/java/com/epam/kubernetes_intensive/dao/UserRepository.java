package com.epam.kubernetes_intensive.dao;

import com.epam.kubernetes_intensive.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
