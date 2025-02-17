package com.coding.prod_ready_feature.prod_ready_feature.repositories;

import com.coding.prod_ready_feature.prod_ready_feature.entities.PostEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
