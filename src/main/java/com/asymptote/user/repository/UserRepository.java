package com.asymptote.user.repository;

import com.asymptote.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User findAllByUserId(Long userId);
}
