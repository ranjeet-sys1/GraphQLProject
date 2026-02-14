package com.example.graphQl.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Data;
import org.springframework.context.event.EventListener;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @Version
    private Long version;
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;
    @CreatedDate
    @Column(updatable = false,nullable = false)
    private OffsetDateTime createdOn;
    @LastModifiedBy
    private String lastUpdatedBy;
    @LastModifiedDate
    @Column(nullable = false)
    private OffsetDateTime lastUpdatedOn;
    @Column(nullable = false)
    private Boolean isActive = false;

}
