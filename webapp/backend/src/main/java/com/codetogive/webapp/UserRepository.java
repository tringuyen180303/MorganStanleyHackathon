package com.codetogive.webapp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codetogive.webapp.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

