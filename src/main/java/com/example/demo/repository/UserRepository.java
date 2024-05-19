package com.example.demo.repository;

import com.example.demo.entity.UserRoleProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String username);
	User getUserByUsername(String username);

	@Query("SELECT new com.example.demo.entity.UserRoleProjection(u.ID, r.roleId, u.username,u.password, r.roleName) " +
			"FROM User u JOIN UserRole ur on u.ID = ur.userId JOIN Role r ON ur.roleId = r.roleId " +
			"WHERE u.username = :username")
	List<UserRoleProjection> findUserProjectionByUsername(String username);

	boolean existsByUsername(String username);
}
