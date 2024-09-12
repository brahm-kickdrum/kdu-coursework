package com.example.java12.repository;

import com.example.java12.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {
    @Modifying
    @Query(value = "UPDATE User u SET u.username = :username, u.loggedIn = :loggedIn, u.timeZone = :timeZone WHERE u.id = :userId")
    void updateUserDetails(
            @Param("userId") UUID userId,
            @Param("username") String username,
            @Param("loggedIn") int loggedIn,
            @Param("timeZone") String timeZone
    );

}
