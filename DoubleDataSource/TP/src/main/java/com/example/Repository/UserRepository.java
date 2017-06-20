package com.example.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.doMain.User;
public interface UserRepository extends JpaRepository<User, Long>{
	User findByName(String name);
	
	/*   User findByNameAndId(String name, Integer id);*/
    
    @Query(value = "from Users u where u.name=?1", nativeQuery = true)
    @Modifying
    User findUser(String name);
}
