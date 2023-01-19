package com.ibm.idp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.idp.domain.UserEntity;
import com.ibm.idp.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;
    
    
    public List<UserEntity> getUsers() {
        try {
            List<UserEntity> result = userRepo.findAll();
            return result;
        } catch (Exception e) {
           //TODO
            e.printStackTrace();
            return null;
        }
               
    }
    
    public List<UserEntity> getUsersByTeamName(String teamname) {
        try {
            return userRepo.findByTeamName(teamname);
        } catch( Exception e) {
           //TODO
            e.printStackTrace();
            return null;
        }
    }
    
    public UserEntity getUserByEmail(String email) {
        try {
            return userRepo.findByEmail(email);
        } catch( Exception e) {
            //TODO
             e.printStackTrace();
             return null;
         }
    }
    
    public UserEntity userCreate(UserEntity user) {
        try {
            return userRepo.save(user);
        }catch( Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
    
    public UserEntity updateUser(UserEntity user) {
        UserEntity update = new UserEntity(user.getName(), user.getUid(), user.getEmail(), user.getManagerSerialNumber(), user.getJob(),
                user.getIsManager(), user.getTeam());
        
        try {
            return userRepo.save(update);
        }catch( Exception e) {
            //TODO
            e.printStackTrace();
            return null;
        }
    }
    
    public void deleteUseByEmail(String email) {
        userRepo.deleteByEmail(email);
    }

    
    

}
