package com.woong.blog.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;


import com.woong.blog.model.Users;


public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	//selecct * from users where username = ?
	Optional<Users>findByUsername(String username);

}


// select * from user where username = ? and password = ?;
//Users findByUsernameAndPassword(String username, String password);

//@Query(value="SELECT * FROM user WHERE username = ?1 AND passwod = ?2", nativeQuery = true)
//Users login(String username, String password);