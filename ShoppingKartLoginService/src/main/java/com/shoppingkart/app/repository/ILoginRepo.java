package com.shoppingkart.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shoppingkart.app.entity.Login;

@Repository
public interface ILoginRepo extends CrudRepository<Login, Integer> {

	@Query(value = "Select * from user where user_name = ?1", nativeQuery = true)
	List<Login> findUser(String userName);

}
