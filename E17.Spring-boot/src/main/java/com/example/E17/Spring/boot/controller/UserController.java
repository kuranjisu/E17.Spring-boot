package com.example.E17.Spring.boot.controller;






import com.example.E17.Spring.boot.entity.User;
import com.example.E17.Spring.boot.services.ProductService;
import com.example.E17.Spring.boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping
public class UserController {



    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/submitForm")
    public String submitForm(@RequestParam("submitButton") String submitButton, @ModelAttribute User user, Model model) {


        System.out.println(user.getUserName());


        if(!(user.getUserName().isEmpty()||user.getPassword().isEmpty())){

            if (submitButton.equals("register")) {

                System.out.println("register");


                try {
                    userService.findUser(String.valueOf(user.getUserName()));
                    System.out.println( userService.findUser(String.valueOf(user.getUserName())).getUserId());

                    System.out.println("alreay exist");

                    return "products/index";


                    //security codes here
                }
                catch (Exception e){;
                    System.out.println("hindi angawa");

                    userService.addUser(user);
                    //redirect based on role
                    return "products/index";
                }

            }


            else{

                try {
                    userService.findUser(String.valueOf(user.getUserName()));
                    return "products/productlist";
                    //security codes here
                }
                catch (Exception e){;
                    return "products/index";
                }


            }

            }




        return "products/index";







    }









}
