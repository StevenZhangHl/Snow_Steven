package com.steven.ssm.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steven.ssm.entity.User;
import com.steven.ssm.service.UserService;
import com.steven.ssm.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/getUser")
public class UserController {
    @Autowired
    private UserService personService;

    @RequestMapping(value = "/selectPerson", method = RequestMethod.POST)
    public void selectPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        long personId = Long.parseLong(request.getParameter("id"));
        User person = personService.findUserById(personId);
        ObjectMapper mapper = new ObjectMapper();
        if (person==null){

        }
        try {
            response.getWriter().write(mapper.writeValueAsString(person));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/selectUserList", method = RequestMethod.POST)
    public void getUserList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<User> person = personService.getUserList();
        ObjectMapper mapper = new ObjectMapper();
        try {
            response.getWriter().write(mapper.writeValueAsString(new CommonResult<>(true,person)));
            response.getWriter().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
