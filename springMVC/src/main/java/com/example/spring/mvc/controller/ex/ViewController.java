package com.example.spring.mvc.controller.ex;

import com.example.spring.mvc.dto.ex.Member;
import com.example.spring.mvc.validator.ex.Student;
import com.example.spring.mvc.validator.ex.StudentValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/board")
public class ViewController {

//    @RequestMapping(value = "board/view", method = RequestMethod.GET)
//    public ModelAndView index() {
//
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("id", 30);
//
//        return mv;
//    }

//    private static final com.sun.org.slf4j.internal.Logger Logger = LoggerFactory.getLogger(ViewController.class);

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest httpServletRequest) {
//
//        int id = Integer.parseInt(httpServletRequest.getParameter("id"));
//
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("id", id);
//
//        return mv;
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public ModelAndView index(@RequestParam("id") String id) {
//
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("id", id);
//
//        return mv;
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public ModelAndView index(Member member) {
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("memberInfo", member);
//        return mv;
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public String index(Member member) {
//        return "board/view";
//    }

//    @RequestMapping(value = "/view/{id}", method = RequestMethod.GET)
//    public String index(@PathVariable String id, Model model){
//        model.addAttribute("id", id);
//        return "board/view";
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public String index(@RequestParam("id") String id, Model model){
//        model.addAttribute("id", id);
//        return "board/view";
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public ModelAndView index(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("id", request.getParameter("id"));
//        return mv;
//    }
//
//    @RequestMapping(value = "/view", method = RequestMethod.POST)
//    public ModelAndView indexI(HttpServletRequest request){
//        ModelAndView mv = new ModelAndView("board/view");
//        mv.addObject("id", request.getParameter("id"));
//        return mv;
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public String index(@ModelAttribute("mem") Member member) {
//        return "board/view";
//    }

//    @RequestMapping(value = "/view", method = RequestMethod.GET)
//    public String index(Member member) {
//        if(member.getName().equals("전주호")) return "board/view";
//        return "redirect:/board/views";
//    }
//
//    @RequestMapping(value = "/views", method = RequestMethod.GET)
//    public String indexx(){
//        return "board/view";
//    }


    @RequestMapping(value = "/studentForm", method = RequestMethod.GET)
    public String studentForm() {
        return "student/createPage";
    }

    @RequestMapping(value = "/student/create", method = RequestMethod.GET)
    public String studentCreate(@ModelAttribute("student") Student student, BindingResult bindingResult) {

        // 유효성 검사를 통과하면 이동할 페이지
        String page = "student/createDone";

//        // 유효성 검사
//        StudentValidator validator = new StudentValidator();
//        validator.validate(student, bindingResult);

        // 유효성 검사 실패 시 이동할 페이지
        if (bindingResult.hasErrors()) {
            page = "redirect:/board/studentForm";
        }

        // 페이지 이동
        return page;
    }


    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(new StudentValidator());
    }



}











