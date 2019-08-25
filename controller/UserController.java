package com.lsr.controller;

import com.lsr.exceptionhandling.BusinessServiceException;
import com.lsr.model.ResponseMessageVO;
import com.lsr.model.UserVO;
import com.lsr.service.UserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping(path = "/create")
  public ResponseEntity<ResponseMessageVO> createUser(UserVO userVo) {
    userService.createRegistration(userVo);
    ResponseMessageVO response = new ResponseMessageVO();
    response.setHttpStatusCode(String.valueOf(HttpStatus.OK));
    response.setMessage("Successfully Created");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping(path = "/update")
  public ResponseEntity<ResponseMessageVO> updateUser(UserVO userVo) {
    userService.updateRegistration(userVo);
    ResponseMessageVO response = new ResponseMessageVO();
    response.setHttpStatusCode(String.valueOf(HttpStatus.OK));
    response.setMessage("updated successfully");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }


  @PostMapping(path = "/auth")
  public ResponseEntity<ResponseMessageVO> authenticate(UserVO userVo)
      throws BusinessServiceException {
    Integer userId = userService.authentic(userVo);
    ResponseMessageVO response = new ResponseMessageVO();
    response.setUserId(userId);
    response.setHttpStatusCode(String.valueOf(HttpStatus.OK));
    response.setMessage("User validation is fine");
    return new ResponseEntity<>(response, HttpStatus.OK);
  }


}
