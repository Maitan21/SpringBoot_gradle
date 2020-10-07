package practice.SpringPractice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http에서 body부에 데이터를 직접 넣어주겠다는 뜻 즉, 데이터를 그대로 내려줌
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    //중요!
    //JSON 방식으로 데이터 아웃풋
    @GetMapping("hello-api")
    @ResponseBody // JSON으로 반환이 기본 셋팅
    public Hello helloApi(@RequestParam("name") String name){
        //Hello 객체 새 객체 생성 위와 다르게 객체를 넘겨줌
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    // 객체 메소드
    /*java bean 기본양식 */
    static class Hello {
        private  String name;

        //꺼내올때
        public String getName() {
            return name;
        }

        //세팅할떄
        public void setName(String name) {
            this.name = name;
        }
    }
}
