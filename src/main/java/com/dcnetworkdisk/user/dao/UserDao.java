package com.dcnetworkdisk.user.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dcnetworkdisk.common.dao.DcRepository;
import com.dcnetworkdisk.user.model.User;

@Repository
public interface UserDao extends DcRepository<User, String>{

	@Query("select u from User u where u.username = :username and u.password = :password")
	public User ensureUser(@Param("username") String username, @Param("password") String password);
	
	public User findByUsername(String username);
}
