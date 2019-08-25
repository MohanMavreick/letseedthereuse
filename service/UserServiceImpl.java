package com.lsr.service;

import com.lsr.entity.Users;
import com.lsr.model.UserVO;
import com.lsr.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UsersRepository userRepo;

  @Override
  public void createRegistration(UserVO userVO) {
    Users user = new Users();
    user.setCity(userVO.getCity());
    user.setEmailAddress(userVO.getEmailAddress());
    user.setName(userVO.getName());
    user.setState(userVO.getState());
    user.setZip(userVO.getZip());
    userRepo.save(user);
  }

  @Override
  public void updateRegistration(UserVO userVO) {
    userRepo.save(userRepo.findById(userVO.getUserId()).map(u -> u)
        .orElseThrow(IllegalArgumentException::new));
  }

  @Override
  public Integer authentic(UserVO userVO) {
    return userRepo.findByUserEmail(userVO.getEmailAddress().toLowerCase(), userVO.getPassword())
        .map(Users::getId).orElseThrow(IllegalArgumentException::new);
  }
}
