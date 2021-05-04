package com.example.springbootwebservice.repository;

import com.example.springbootwebservice.domain.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {

}
