package com.ibm.idp.domain;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user")
public class UserEntity {
    
    @Schema(description = "User name", example = "Sam Smith", requiredMode = RequiredMode.REQUIRED)
    private String name;
  
    @Schema(description = "User id", example = "55074766", requiredMode = RequiredMode.REQUIRED)
    private String uid;
    
    @Schema(description = "Manager's serial number", example = "51222", requiredMode = RequiredMode.REQUIRED)
    private String managerSerialNumber;
    
    @Schema(description = "User emailr", example = "sam.smith.ibm.com", requiredMode = RequiredMode.REQUIRED)
    private String email;
    
    @Schema(description = "User's job responsibility", example = "Cloud Engineer - IBM Technology Garage", requiredMode = RequiredMode.REQUIRED)
    private String job;
    
    @Schema(description = "Check if user is manager", example = "0: general user, 1: first stage manager, 2: second stage manager", requiredMode = RequiredMode.REQUIRED)
    private Integer isManager;
    
    @Schema(description = "User's team name", example = "Technology Garage")
    private String team;
    
    public UserEntity (
        final String name,
        final String uid,
        final String email,
        final String managerSerialNumber,
        final String job,
        final Integer isManager,
        final String team){
            this.name = name;
            this.uid = uid;
            this.email = email;
            this.managerSerialNumber = managerSerialNumber;
            this.job = job;
            this.isManager = isManager;
            this.team = team;
    }
}
