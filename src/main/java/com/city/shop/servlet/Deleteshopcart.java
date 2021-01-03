package com.city.shop.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.city.shop.model.Buyer;
import com.city.shop.service.UserService;
import com.city.shop.service.Impl.UserServiceImpl;

@WebServlet("/Deleteshopcart")
public class Deleteshopcart extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//接收参数
		String StringGoodsid=request.getParameter("goodsid");
		System.out.println(StringGoodsid);
		Buyer buyer=(Buyer)request.getSession().getAttribute("buyer");
		String Buyerid=buyer.getBuyerId();
		//处理数据
		Integer[] Goodsid=new Integer[1];
		
			Goodsid[0]=Integer.valueOf(StringGoodsid);
		
		//调用接口
		UserService userservice=new UserServiceImpl();
		try {
			userservice.deleteCartGoods_service(Goodsid, Buyerid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/Seeshopcart").forward(request, response);
		
	}

	
	
}
