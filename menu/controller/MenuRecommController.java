package com.kh.cook.menu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.cook.menu.service.MenuService;
import com.kh.cook.menu.vo.MenuVo;
@WebServlet(urlPatterns = "/")
public class MenuRecommController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<MenuVo> recommList = new MenuService().selectRecommList();
		
    	req.setAttribute("recommList", recommList);
    	req.getRequestDispatcher("/").forward(req, resp);
	}
}
