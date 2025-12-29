package com.example.examplemember.service;

import com.example.examplemember.dto.*;
import com.example.examplemember.entity.Member;
import com.example.examplemember.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public CreateMemberResponse save(CreateMemberRequest request) {
        Member member = new Member(request.getName());
        Member saved = memberRepository.save(member);
        return new CreateMemberResponse(saved.getMemberId(), saved.getName(), saved.getCreatedAt(), saved.getModifiedAt());
    }

    @Transactional(readOnly = true)
    public List<GetMemberResponse> findAll() {
        List<Member> members = memberRepository.findAll();
        List<GetMemberResponse> dtos = new ArrayList<>();
        for (Member member : members) {
            GetMemberResponse dto = new GetMemberResponse(member.getMemberId(), member.getName(), member.getCreatedAt(), member.getModifiedAt());
            dtos.add(dto);
        }
        return dtos;
    }

    @Transactional(readOnly = true)
    public GetMemberResponse findOne(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("Member with id: " + memberId + " not found")
        );
        return new GetMemberResponse(member.getMemberId(), member.getName(), member.getCreatedAt(), member.getModifiedAt());
    }

    @Transactional
    public UpdateMemberResponse update(Long memberId, UpdateMemberRequest request) {
        Member member = memberRepository.findById(memberId).orElseThrow(
                () -> new IllegalArgumentException("Member with id: " + memberId + " not found")
        );
        member.update(request.getName());
        return new UpdateMemberResponse(member.getMemberId(), member.getName(), member.getCreatedAt(), member.getModifiedAt());
    }

    @Transactional
    public void delete(Long memberId) {
        boolean existence = memberRepository.existsById(memberId);
        if (!existence) {
            throw new IllegalArgumentException("Member with id: " + memberId + " not found");
        }
        memberRepository.deleteById(memberId);
    }
}
