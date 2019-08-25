package com.lsr.service;

import java.util.List;

import com.lsr.model.BuyerSuppilerVO;
import com.lsr.model.CommodityVO;

public interface ReuseService {

  BuyerSuppilerVO findSupplierDetails(Integer itemId, String userType);

  List<CommodityVO> findAllCommodity();

}
