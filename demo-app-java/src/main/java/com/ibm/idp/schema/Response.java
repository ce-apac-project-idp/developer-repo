package com.ibm.idp.schema;

import java.util.List;
import java.util.Map;

import com.ibm.idp.domain.UserEntity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Response {
    
    @Schema(description = "Status Code", example = "200")
    private String status;
    
    @Schema(description = "Result message", example = "Successful Result")
    private String message;
    
    @Schema(description = "Result from DB")  
    private List<UserEntity> users;

    public Response(
            final String status,
            final String message,
            final List<UserEntity> users) {
        this.status = status;
        this.message = message;
        this.users = users;
    }
}
