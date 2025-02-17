package com.coding.prod_ready_feature.prod_ready_feature.entities;


// this class is considered  as a super class of postEntity class

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditableEntity.class)
@Audited
public class AuditableEntity {

    @CreatedDate
//    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updateDate;

    @CreatedBy
    private String createdBY;

    @LastModifiedBy
    private String updatedBy;


}
