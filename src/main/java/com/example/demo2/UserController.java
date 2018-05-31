package com.example.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserTemplate userTemplate;

    int count = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        List<User> userList = new ArrayList<>();
        userList = userTemplate.findAll();

        System.out.println(userList);

        count = userList.size();
        model.addAttribute("count",count);

        return "index";
    }
}
