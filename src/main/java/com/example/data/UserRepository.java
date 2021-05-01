package com.example.data;

import com.example.models.*;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>{

	public User findByUsername(String username);
}
