package com.backend.pixel.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.backend.pixel.model.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long>{

}
