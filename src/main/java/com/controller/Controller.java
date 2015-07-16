package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.RefreshListConfig;

@RestController
@RequestMapping("/test")
public class Controller {

    @Autowired
    private RefreshListConfig refreshCOnfig;
    
    @RequestMapping(value = "/refreshed", method = { RequestMethod.POST, RequestMethod.GET })
    public String refreshed() {
        
        
        return refreshCOnfig.toString();
    }
}
