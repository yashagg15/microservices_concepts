package com.project.springrestfulmicroservice.Repository;

import com.project.springrestfulmicroservice.model.User_V2;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User_V2, Long> {

}
