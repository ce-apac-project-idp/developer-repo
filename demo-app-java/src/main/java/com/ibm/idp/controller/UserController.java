package com.ibm.idp.controller;

import java.util.ArrayList;

import java.util.List;


import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.idp.domain.UserEntity;
import com.ibm.idp.schema.ErrorResponse;
import com.ibm.idp.schema.Response;
import com.ibm.idp.service.UserService;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/users")
@Tag(name = "users", description = "endpoints for user")
@ComponentScan(basePackages = {"com.ibm.skillSetNavigator"})
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;
    
    @Operation(summary = "All users in the skillset navigator")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "SUCCESS", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class),
                            examples= {@ExampleObject(value = "")})}),
            @ApiResponse(responseCode = "500", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @GetMapping("")
    public Response getUsers() {

        logger.info("Get All Users");
        
        List<UserEntity> result =  userService.getUsers();
        
        if (result != null) {
            return new Response("200","Successful Result", result);
            
        } else {
            return new Response("500","Internal Error", result);
        }

    }
    
    @Operation(summary = "Provide users in a team by given team name ")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "SUCCESS", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid team name", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @GetMapping("/team/{teamname}")
    public Response getUsersByTeamName(@PathVariable("teamname") String teamname) {
        logger.info("path parameter :" + teamname);
        List<UserEntity> result =  userService.getUsersByTeamName(teamname);
        
        if (result != null) {
            return new Response("200","Successful Result", result);
            
        } else {
            return new Response("500","Internal Error", result);
        }

    }
    
    @Operation(summary = "Provide specific user by given email address")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "SUCCESS", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid email address", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Data not found", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))) })
    @GetMapping("/email/{email}")
    public Response getUsersByEmail(@PathVariable("email") String email) {
        logger.info("path parameter :" + email);
        UserEntity result = userService.getUserByEmail(email);
        
        if (result != null) {
            List<UserEntity> users = new ArrayList<UserEntity>();
            users.add(result);
            return new Response("200","Successful Result", users);
            
        } else {
            return new Response("500","Internal Error", null);
        }


    }

    @Operation(summary = "Add a user with info")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully registered", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }) })
    @PostMapping("")
    public Response createUser(@Valid @RequestBody UserEntity user) {
       logger.info("create a user");

       UserEntity result = userService.userCreate(user);
       
       if (result != null) {
           List<UserEntity> users = new ArrayList<UserEntity>();
           users.add(result);
           return new Response("200","Successful Result", users);
           
       } else {
           return new Response("500","Internal Error", null);
       }

    }
    
    @Operation(summary = "Update the user info")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully updated", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }) })
    @PutMapping("")
    public Response updateUser(@Valid @RequestBody UserEntity user) {
        logger.info("create a user");

        UserEntity result = userService.updateUser(user);
        
        if (result != null) {
            List<UserEntity> users = new ArrayList<UserEntity>();
            users.add(result);
            return new Response("200","Successful Result", users);
            
        } else {
            return new Response("500","Internal Error", null);
        }
    }
    
    @Operation(summary = "Delete the user info by given email")
    @ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Successfully deleted", content = {
            @Content(mediaType = "application/json", schema = @Schema(implementation = Response.class)) }) })
    @DeleteMapping("/email/{email}")
    public Response deleteUser(@PathVariable("email") String email) {
        logger.info("delete a user");
        
        try {

            userService.deleteUseByEmail(email);
            return new Response("200","Successful Result", null);
        } catch (Exception e) {
            e.printStackTrace();
            return new Response("500","Internal Error", null);
            
        }       

    }   
}
