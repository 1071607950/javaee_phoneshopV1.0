package com.city.shop.service.Impl;

import java.util.List;

import com.city.shop.dao.SellerDao;
import com.city.shop.dao.Impl.SellerDaoImpl;
import com.city.shop.model.Seller;
import com.city.shop.service.ManagerService;
import com.city.shop.utils.PageUtils;

/**
 * 
 * @author 
 * @category 管理员审核逻辑处理接口实现
 */
public class ManagerServiceImpl implements ManagerService{

	

	@Override
	public List<Seller> lookAllSeller(PageUtils pageUtils) throws Exception {
		SellerDao sellerDao=new SellerDaoImpl();
		return sellerDao.findAllSellerInfo(pageUtils);	
	}

	@Override
	public Boolean modifyPower(String sellerId, int power) throws Exception {
		SellerDao sellerDao=new SellerDaoImpl();
		return sellerDao.toExamine(sellerId, power);
	}

	@Override
	public Boolean delectSeller(String sellerId) throws Exception {
		SellerDao sellerDao=new SellerDaoImpl();
		return sellerDao.delectSeller(sellerId);
	}
	
	
}
