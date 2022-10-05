package com.ecommerce.backend.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Data
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String emailId;

    @CreatedDate
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;

    public Member(Long id, String name, String address, String emailId, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.emailId = emailId;
        this.created = created;
        this.updated = updated;
    }

    public Member(){

    }
}
