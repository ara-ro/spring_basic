package com.beyond.basic.controller;

import com.beyond.basic.domain.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller // 컨트롤러 기능 명시
public class MemberController {

//    회원목록조회
    @GetMapping("/member/list")
    public String memberList(){
        return "/member/member-list";
    }

//    회원상세조회 : memberDetail
//    url(uri) : member/1, member/2
//    화면명 : member-detail
    @GetMapping("/member/{id}")
//    int 또는 long으로 받을 경우 스프링에서 알아서 형변환 된다.
    public String memberDetail(@PathVariable(value = "id") int id, Model model){
        model.addAttribute("id",id);
        return "/member/member-detail";
    }


//    회원가입화면 주고
//    url : member/create
    @GetMapping("/member/create")
    public String memberCreateView(){
        return "/member/member-create";
    }

//    회원가입 데이터를 받는다
//    url : member/create
//    name, email, password
    @PostMapping("/member/create")
    @ResponseBody
    public String memberCreatePost(@RequestBody Member member){
        System.out.println(member);
        return "ok";
    }




}
