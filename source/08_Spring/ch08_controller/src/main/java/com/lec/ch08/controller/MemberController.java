package com.lec.ch08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.lec.ch08.dto.Member;
// "member?method=join" "member?method=login"
// "member?method=logout" "member?method=infoModify"
@Controller
@RequestMapping("member")
public class MemberController {
	@RequestMapping(params="method=join", method=RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("kind", "회원");
		return "member/join";
	}
	@RequestMapping(params="method=login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("result", "login");
		return "member/result";
	}
	@RequestMapping(params="method=logout", method=RequestMethod.GET)
	public String logout(Model model) {
		model.addAttribute("result", "logout");
		return "member/result";
	}
	@RequestMapping(params="method=infoModify", method=RequestMethod.GET)
	public String modify(Model model) {
		model.addAttribute("result", "modify");
		return "member/result";
	}
	@RequestMapping(params="method=infoModify", method=RequestMethod.POST)
	public ModelAndView modify(ModelAndView mav){
		mav.addObject("result", "modify");
		mav.setViewName("member/result");
		return mav;
	}
}
