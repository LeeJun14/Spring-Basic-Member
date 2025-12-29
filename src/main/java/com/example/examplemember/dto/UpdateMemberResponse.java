package com.example.examplemember.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UpdateMemberResponse {
    private final Long id;
    private final String name;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public UpdateMemberResponse(Long id, String name, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
