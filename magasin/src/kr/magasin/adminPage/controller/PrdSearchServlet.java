package kr.magasin.adminPage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.magasin.product.model.service.ProductService;
import kr.magasin.product.model.vo.Product;

@WebServlet(name = "PrdSearch", urlPatterns = { "/prdSearch" })
public class PrdSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public PrdSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String productnamesearch = request.getParameter("productnamesearch");
		String prdCtgr = request.getParameter("prdCtgr");
		String prdSubCtrg = request.getParameter("prdSubCtrg");
		//int prddatesearch = -1;
		int prddatesearch = Integer.parseInt(request.getParameter("prddatesearch"));
		
		ProductService pservice = new ProductService();
		ArrayList<Product> list = pservice.productSearch(productnamesearch,prdCtgr,prdSubCtrg,prddatesearch);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		new Gson().toJson(list, response.getWriter());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
