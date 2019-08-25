package com.lsr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lsr.entity.Buyer;
import com.lsr.entity.Commodity;
import com.lsr.entity.Supplier;
import com.lsr.model.BuyerSuppilerVO;
import com.lsr.model.BuyerVO;
import com.lsr.model.CommodityVO;
import com.lsr.model.SupplierVO;
import com.lsr.repository.BuyerRepository;
import com.lsr.repository.CommodityRepository;
import com.lsr.repository.SupplierRepository;

@Service
public class ReuseServiceImpl implements ReuseService {

  @Autowired
  private BuyerRepository buyerRepository;

  @Autowired
  private SupplierRepository supplierRepository;

  @Autowired
  private CommodityRepository commodityRepository;

  @Override
  public BuyerSuppilerVO findSupplierDetails(Integer itemId, String userType) {
    BuyerSuppilerVO buyerSuppilerVO = new BuyerSuppilerVO();
    BuyerVO buyerVo;
    SupplierVO supplierVO;
    List<SupplierVO> supplierVOs = new ArrayList<>();
    List<BuyerVO> buyerVOs = new ArrayList<>();
    List<Supplier> lstSupplier = supplierRepository.findAll();
    List<Buyer> lstBuyer = buyerRepository.findAll();
    for (Supplier supplier : lstSupplier) {
      supplierVO = new SupplierVO();
      supplierVO.setSupplierName(supplier.getContactNumber());
      supplierVO.setContactNumber(supplier.getContactNumber());
      supplierVO.setInterestedAddress(supplier.getInterestedAddress());
      supplierVO.setLocation(supplier.getLocation());
      supplierVOs.add(supplierVO);
    }
    for (Buyer buyer : lstBuyer) {
      buyerVo = new BuyerVO();
      buyerVo.setBuyerName(buyer.getBuyerName());
      buyerVo.setContactNumber(buyer.getContactNumber());
      buyerVo.setInterestedAddress(buyer.getBuyerAddress());
      buyerVo.setLocation(buyer.getLocation());
      buyerVOs.add(buyerVo);
    }
    buyerSuppilerVO.setBuyer(buyerVOs);
    buyerSuppilerVO.setSupplier(supplierVOs);
    return buyerSuppilerVO;
  }

  @Override
  public List<CommodityVO> findAllCommodity() {
    List<Commodity> commodities = commodityRepository.findAll();
    CommodityVO commodityVO;
    List<CommodityVO> commodityVOs = new ArrayList<>();
    for (Commodity commodity : commodities) {
      commodityVO = new CommodityVO();
      commodityVO.setLocation(commodity.getLocation());
      commodityVO.setName(commodity.getName());
      commodityVO.setQuality(commodity.getQuality());
      commodityVO.setQuantity(commodity.getQuantity());
      commodityVOs.add(commodityVO);
    }
    return commodityVOs;
  }


}
