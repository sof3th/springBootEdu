package com.guestbook.entiry;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class })
@Getter
public abstract class BaseEntity {


    //@CreatedDate
    @CreationTimestamp
    @Column(name = "regdate", updatable = false)
    private LocalDate regDate;

    //@LastModifiedDate
    @UpdateTimestamp
    @Column(name ="moddate" )
    private LocalDate modDate;

}
