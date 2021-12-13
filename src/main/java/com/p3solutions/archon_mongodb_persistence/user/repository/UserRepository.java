package com.p3solutions.archon_mongodb_persistence.user.repository;

import com.p3solutions.archon_mongodb_persistence.user.entity.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserModel, String> {
    @Query(value = "SELECT * FROM users b WHERE b.user_data->>'accountLocked'=?2", nativeQuery = true)
    List<UserModel> findAccountLockedUser(boolean accountLocked);
    @Query(value = "SELECT * FROM users b WHERE b.data->>'firstName'=?2", nativeQuery = true)
    Optional<UserModel> findByEmailAddressIgnoreCase(String emailAddress);

    @Query(value = "SELECT * FROM users b WHERE b.user_data->>'firstName' ILIKE CONCAT('%', ?1, '%')", nativeQuery = true)
    List<UserModel> findByGlobalGroup(String globalGroupId);}
