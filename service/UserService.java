package com.lsr.service;

import com.lsr.exceptionhandling.BusinessServiceException;
import com.lsr.model.UserVO;

public interface UserService {

  void createRegistration(UserVO userVO);

  void updateRegistration(UserVO userVO);

  Integer authentic(UserVO userVO) throws BusinessServiceException;

}
