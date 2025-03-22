package com.fsofter.home.repository;

import com.fsofter.home.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    Page<User> findByEmailContainingOrFirstNameContainingOrLastNameContaining(
            String email, String firstName, String lastName, Pageable pageable);
}
