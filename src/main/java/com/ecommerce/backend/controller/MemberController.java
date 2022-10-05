package com.ecommerce.backend.controller;

import com.ecommerce.backend.dto.MemberDto;
import com.ecommerce.backend.entity.Member;
import com.ecommerce.backend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/users")
    public Member saveMember(@RequestBody Member member){
        return memberService.saveMember(member);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<MemberDto> getMemberById(@PathVariable Long id){

        MemberDto memberDto = null;
        memberDto = memberService.getMemberById(id);

        return ResponseEntity.ok(memberDto);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<MemberDto> updateUser(@PathVariable("id") Long id, @RequestBody MemberDto memberDto){
        memberDto = memberService.updateMember(id,memberDto);
        return ResponseEntity.ok(memberDto);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteUser(@PathVariable("id") Long id){
        boolean deleted = false;
        deleted = memberService.deleteMember(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted",deleted);

        return ResponseEntity.ok(response);
    }
}
