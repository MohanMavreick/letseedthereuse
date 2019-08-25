package com.lsr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lsr.model.BuyerSuppilerVO;
import com.lsr.model.CommodityVO;
import com.lsr.service.ReuseService;

@Controller
@RequestMapping("/reuse")
public class SupplierBuyerController {

  @Autowired
  private ReuseService reuseService;

  @GetMapping(path = "/buyerAndSupplier")
  public ResponseEntity<BuyerSuppilerVO> findBuyerAndSupplier(Integer itemId, String itemType) {
    BuyerSuppilerVO buyerSuppilerVO = reuseService.findSupplierDetails(itemId, itemType);
    return new ResponseEntity<>(buyerSuppilerVO, HttpStatus.OK);
  }

  @GetMapping(path = "/commodity")
  public ResponseEntity<List<CommodityVO>> findBuyerAndSupplier() {
    List<CommodityVO> commodityVOS = reuseService.findAllCommodity();
    return new ResponseEntity<>(commodityVOS, HttpStatus.OK);
  }

}
