package com.heycolor.yunziyuanbackend;

import com.heycolor.yunziyuanbackend.DAOuser.Request.loginParams;
import com.heycolor.yunziyuanbackend.constant.ReturnInfo;
import com.heycolor.yunziyuanbackend.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class ManagerApi {
    @Autowired
    private ManagerService managerService;

//    @PostMapping({"/userManagerAdd"})
//    private ResponseEntity<ReturnInfo> userManagerAdd(@Validated @RequestBody loginParams bao) {
//
//
//    }

}
