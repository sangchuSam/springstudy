package com.haul.spring;


import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanul.springstudy.SampleDTO;
import com.hanul.springstudy.domain.SampleDTOList;
import com.hanul.springstudy.domain.TodoDTO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/sample")
//@RequestMapping("/sample/*")
@Slf4j
public class SampleController {
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	/*
	@RequestMapping("/basic")
	public void basic() {
		logger.info("logger basic..........");
		log.info("롬복 basic..........");
	}
	*/
	
	@PostMapping("/basic")
	public void postBasic() {
		logger.info("logger basic..........");
		log.info("롬복 basic..........");
	}
	
	@GetMapping("/basic")
	public void getBasic() {
		logger.info("logger basic..........");
		log.info("롬복 basic..........");
	}
	
	@RequestMapping(value = "/get_post", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basicGet.....");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO sDto) {
		log.info("" + sDto);
		
		return "ex01";
	}
	
	/*
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String superName, @RequestParam("age") int superAge) {
		log.info("name : " + superName + ", age : " + superAge);
		SampleDTO sDto = new SampleDTO();
		sDto.setName(superName);
		sDto.setAge(superAge);
		
		return "ex02";
	} */
	
	@GetMapping("/ex02List")
	public String ex02(@RequestParam("ids") ArrayList<String> ids) {
		log.info("ids : " + ids);
		return "ex02List";
	}
	
	// 브라우저에서 배열 접근 금지시킴
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		log.info("list dtos : {}", list);
		
		return "/ex02Bean";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("todo : {}", todo);
		return "/ex03";
	}
	
	/*
	@RequestMapping("/sampleModel")
	public String sampleModel(Model model) {
		SampleDTO sampleDTO = new SampleDTO("홍길동", 18);
		
		log.info("sampleModel.......");
		model.addAttribute("sDto",sampleDTO);
		
		return "/sample/sample";
	}
	*/
	/*값 1개만 넘길때*/
	/*
	@RequestMapping("/sampleModel")
	public String sampleModel(Model model) {
		SampleDTO sampleDTO = new SampleDTO("홍길동", 18);
		
		log.info("sampleModel.......");
		model.addAttribute(sampleDTO);
		
		return "/sample/sample";
	}
	*/
	
	@GetMapping("/ex04")
	public String ex04(SampleDTO dto, @ModelAttribute("page")int page) {
	
		log.info("dto : {}", dto);
		log.info("page : {}", page);
		
		return "/sample/ex04";
	}
	
	@RequestMapping(value = "/doE")
	public String doE(RedirectAttributes rttr) {
		log.info("doE 호출되지만 /doF로 리다이렉트.....");
		rttr.addFlashAttribute("msg", "리다이렉트된 메세지입니다.");
		
		return "redirect:/sample/doF";
	}
	
	@RequestMapping("/doF")
	public String doF(String msg) {
		log.info("doF 호출 됨.......");
		
		return "/sample/redirectAttributeResult";
	}
	
	@RequestMapping("/ex05")
	@ResponseBody 
	public SampleDTO ex05() {
		log.info("/ex05...........");
		
		SampleDTO dto = new SampleDTO("홍길동",18);
		
		return dto;
	}
}
