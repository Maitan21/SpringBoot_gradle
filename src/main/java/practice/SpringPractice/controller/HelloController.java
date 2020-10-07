package practice.SpringPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    //맵핑URL
    @GetMapping("hello")
    public String hello(Model model) {
        // attributeName : 키 attributeValue : 값
        model.addAttribute("data","hello!!");
        //return 실행파일위치
        return "hello";
        //(attributeValue)"hello!!"가 hello.html 에서 {data}부분에 치환됨
    }
}
