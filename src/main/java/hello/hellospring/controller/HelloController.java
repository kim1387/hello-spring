package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //hello.html로 이동하여라
    }
    @GetMapping("hello-mvc")
    public  String helloMvc(@RequestParam(value = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";//hello-template.html로 이동하여라
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody// 이게 있으면 ViewResolve한테 던지지 않고 htppMessageConvertor에게 =>   HTPP의 body에 문자내용을 직접 반환
                 // String이면 string으로 객체가 오면 default는 json으로 데이터 반환
                 // String convertor 가 변환 JsonConvertor가 변환
    public Hello helloapi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
