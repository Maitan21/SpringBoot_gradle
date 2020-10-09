package practice.SpringPractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import practice.SpringPractice.service.MemberService;

@Controller
public class MemberController {

    //스프링 컨테이너에 컨트롤러 이노테이션이 객체를 생성 그리고 스프링이 관리
    //스프링이 관리하게 되면 스프링컨테이너에 등록해서 여기서 받아서 쓰도록 하여야함

    //Depedency Injection
    private final MemberService memberService;


    @Autowired
    public MemberController(MemberService memberService) {
        /*Autowired
        memberService 를 스프링이 컨테이너에있는 MemberService에 연결시켜준다.
        */
        this.memberService = memberService;

    }

}
