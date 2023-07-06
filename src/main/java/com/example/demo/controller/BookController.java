package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.BookDAO;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Setter;

@Controller
@Setter
public class BookController {
	@Autowired
	private BookDAO dao;
	
	@GetMapping("/listBook")
	public void list(HttpServletRequest request, Model model) {
		model.addAttribute("list",dao.findAll());
	}
	
	@GetMapping("/detailBook")
	public void detail(int bookid, Model model, HttpServletRequest request) {
		model.addAttribute("b", dao.findByBookid(bookid));
	}
}
