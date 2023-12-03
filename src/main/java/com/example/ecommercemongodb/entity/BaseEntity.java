package com.example.ecommercemongodb.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@Getter
@Setter
public abstract class BaseEntity implements Serializable {

    @Id
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "uuid2")
    @Column(length = 36, nullable = false, updatable = false)
    private String id;

    @Column(name = "created_date", nullable = false, updatable = false)
    @CreatedDate
    @Setter(AccessLevel.NONE)
    private ZonedDateTime createdDate;

    @Column(name = "modified_date", nullable = false)
    @LastModifiedDate
    @Setter(AccessLevel.NONE)
    private ZonedDateTime modifiedDate;

}
