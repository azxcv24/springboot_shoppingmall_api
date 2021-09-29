package com.shopping.api.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {


    @Query("SELECT p from Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    //상품정보 리스트를 조건에맞게 select
    @Query("SELECT p FROM Posts p WHERE p.author= ?1 and p.category= ?2 and p.shipping= ?3 ORDER BY p.id DESC")
    List<Posts> getOrderPostsCase(String author, String category, String shipping);

}
//postsDB접근인터페이스(sql자동 생성 인터페이스)