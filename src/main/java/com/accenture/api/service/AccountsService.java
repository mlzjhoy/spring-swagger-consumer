package com.accenture.api.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accenture.model.User;

@FeignClient(name = "user-api", url="${feign.userURL}")
public interface AccountsService {

    @GetMapping(value="/v1/user/{userId}", consumes="application/json", produces = "application/json")
    public User getUser(@PathVariable("userId") Integer userId);

}
