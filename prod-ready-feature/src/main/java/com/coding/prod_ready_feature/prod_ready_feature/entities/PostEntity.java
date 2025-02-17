package com.coding.prod_ready_feature.prod_ready_feature.entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
//@EntityListeners(AuditingEntityListener.class)
@Audited
public class PostEntity extends  AuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;


    private String description;

    @PrePersist
    void beforeSave() {

    }

    @PreUpdate
    void beforeUpdate(){

    }

    @PreRemove
    void beforeDelete() {

    }



}
