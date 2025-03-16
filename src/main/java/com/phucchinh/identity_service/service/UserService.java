package com.phucchinh.identity_service.service;


import com.phucchinh.identity_service.dto.request.UserCreationRequest;
import com.phucchinh.identity_service.dto.request.UserUpdateRequest;
import com.phucchinh.identity_service.dto.response.UserResponse;
import com.phucchinh.identity_service.entity.User;
import com.phucchinh.identity_service.exception.AppException;
import com.phucchinh.identity_service.exception.ErrorCode;
import com.phucchinh.identity_service.mapper.UserMapper;
import com.phucchinh.identity_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    public User createUser(UserCreationRequest request){

        if(userRepository.existsByUsername(request.getUsername()))
            throw new AppException(ErrorCode.USER_EXISTED);

        User user = userMapper.toUser(request); //cai dong nay no lam het toan bo cai dong o duoi =)))
//        user.setUsername(request.getUsername());
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());

        return userRepository.save(user);
    }

    public UserResponse updateUser(String userId, UserUpdateRequest request){
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found!"));
        userMapper.updateUser(user,request);
//        user.setPassword(request.getPassword());
//        user.setFirstName(request.getFirstName());
//        user.setLastName(request.getLastName());
//        user.setDob(request.getDob());

        return userMapper.toUserResponse(userRepository.save(user)) ;
    }

    public void deleteUser(String userId){
        userRepository.deleteById(userId);
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public UserResponse getUser(String id){
        return userMapper.toUserResponse(userRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found!")));
    }
}
