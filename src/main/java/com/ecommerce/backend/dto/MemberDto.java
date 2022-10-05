package com.ecommerce.backend.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class MemberDto {
    private Long id;
    private String name;
    private String address;
    private String emailId;
    private LocalDateTime created;
    private LocalDateTime updated;

    public MemberDto(Long id, String name, String address,String emailId, LocalDateTime created, LocalDateTime updated) {
        this.id = id;
        this.name = name;
        this.emailId = emailId;
        this.address = address;
        this.created = created;
        this.updated = updated;
    }
    public MemberDto(){

    }
}
