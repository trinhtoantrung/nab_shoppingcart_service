package com.nab.assignment.shoppingcart.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDTO implements Serializable {
//    {
//        "timestamp": "2021-03-05T09:03:40.777+00:00",
//            "status": 400,
//            "error": "Bad Request",
//            "message": "Not found product id: 23fd1610-7c2f-4dfa-a0b7-0a55ac3d7895",
//            "path": "/api/product/price"
//    }
    private String timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
}
