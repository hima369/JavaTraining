package com.wellsfargo.fsd.cpk.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wellsfargo.fsd.cpk.entity.kit;
import com.wellsfargo.fsd.cpk.exception.cpkException;
import com.wellsfargo.fsd.cpk.service.KitService;
import com.wellsfargo.fsd.cpk.service.KitServiceImpl;



/**
 * Servlet implementation class cpkFrontController
 */
@WebServlet({"/list","/newkit", "/addkit", "/deletekit","/editkit","/savekit"})
public class cpkFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	private KitService kitservice;

	@Override
	public void init() throws ServletException {
		kitservice = new KitServiceImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = request.getServletPath();
			String viewName = "";
			
			switch(url) {
			case "/list":viewName = dolist(request,response);break;
			case "/newkit":viewName = donewkit(request,response);break;
			case "/addkit":viewName = doaddkit(request,response);break;
			case "/deletekit":viewName = dodeletekit(request,response);break;
			case "/editkit":viewName = doeditkit(request,response);break;
			case "/savekit":viewName = dosavekit(request, response);break;
			}
			request.getRequestDispatcher(viewName).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private String dolist(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String view = "";
	  try {
		List<kit> kits = kitservice.getAllKits();
		request.setAttribute("kits", kits);
		view = "kitsListPage.jsp";
	} catch (cpkException e) {
		request.setAttribute("errMsg",e.getMessage());
		view = "errorPage.jsp";
		e.printStackTrace();
	}
		return view;
	}
	
	private String donewkit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		kit kit = new kit();
		request.setAttribute("kit",kit);
		return "kitFormPage.jsp";
	}
	
	private String doaddkit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		kit kit = new kit();
		kit.setKitID(Integer.parseInt(request.getParameter("kitID")));
		kit.setProductitem(request.getParameter("productitem"));
		kit.setCost(Double.parseDouble(request.getParameter("cost")));
		kit.setProductdescription(request.getParameter("productdescription"));
		
		String view= "";
		try {
			kitservice.ValidateAndAdd(kit);
			request.setAttribute("msg", "Item Got Added!");
			view="index.jsp";
		} catch (cpkException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	
	private String dodeletekit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int kitID = Integer.parseInt(request.getParameter("kitID"));
		String view="";
		
		try {
			kitservice.deleteKit(kitID);
			request.setAttribute("msg", "Item Got Deleted!");
			view="index.jsp";
		} catch (cpkException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	private String doeditkit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		int kitID = Integer.parseInt(request.getParameter("kitID"));
		String view="";
						
		try {
			kit kit = kitservice.getKitById(kitID);
			request.setAttribute("kit", kit);
			view="kitFormPage.jsp";
		} catch (cpkException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	private String dosavekit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		kit kit = new kit();
		kit.setKitID(Integer.parseInt(request.getParameter("kitID")));
		kit.setProductitem(request.getParameter("productitem"));
		kit.setCost(Double.parseDouble(request.getParameter("cost")));
		kit.setProductdescription(request.getParameter("productdescription"));
		
		String view= "";
		try {
			kitservice.ValidateAndSave(kit);
			request.setAttribute("msg", "Item Got Saved!");
			view="index.jsp";
//			view="kitFormPage.jsp";
		} catch (cpkException e) {
			request.setAttribute("errMsg", e.getMessage());
			view="errorPage.jsp";
		}
		return view;
	}
	

}
