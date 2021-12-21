package com.example.dto;

import com.example.entity.Member;
import lombok.Data;

@Data
public class MemberDto {
    private String name;
    private String address;

    public Member toEntity() {
        return Member.builder()
                .name(this.name)
                .address(this.address).build();
    }

}



