package com.example.examplemember.controller;

import com.example.examplemember.dto.*;
import com.example.examplemember.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/members")
    public ResponseEntity<CreateMemberResponse> create(@RequestBody CreateMemberRequest request) {
        CreateMemberResponse response = memberService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/members")
    public ResponseEntity<List<GetMemberResponse>> getAll() {
        return  ResponseEntity.status(HttpStatus.OK).body(memberService.findAll());
    }

    @GetMapping("/member/{memberId}")
    public ResponseEntity<GetMemberResponse> get(@PathVariable Long memberId) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findOne(memberId));
    }

    @PutMapping("/member/{memberId}")
    public ResponseEntity<UpdateMemberResponse> update(@PathVariable Long memberId, @RequestBody UpdateMemberRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.update(memberId, request));
    }

    @DeleteMapping("member/{memberId}")
    public ResponseEntity<Void> delete(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
