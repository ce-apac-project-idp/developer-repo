package com.ibm.idp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ibm.idp.domain.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{
    
    public List<UserEntity> findByTeamName(String teamname);
    
    public UserEntity findByEmail(String email);
    
    public void deleteByEmail(String email);

}
