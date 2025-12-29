package com.example.examplemember.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CreateMemberResponse {
    private final Long memberId;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CreateMemberResponse(Long memberId, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.memberId = memberId;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
