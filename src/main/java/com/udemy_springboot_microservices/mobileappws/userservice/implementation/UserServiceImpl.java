package com.udemy_springboot_microservices.mobileappws.userservice.implementation;

import com.udemy_springboot_microservices.mobileappws.shared.Utils;
import com.udemy_springboot_microservices.mobileappws.ui.model.request.UserDetailsRequestModel;
import com.udemy_springboot_microservices.mobileappws.ui.model.response.User;
import com.udemy_springboot_microservices.mobileappws.userservice.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

  Map<String, User> users;

  @Override
  public User createUser(UserDetailsRequestModel userDetails) {
    String userID = Utils.generateUserID();
    User user = new User(userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userID);

    if(users == null) {
      users = new HashMap<>();
    }
    users.put(userID, user);

    return user;
  }
}
