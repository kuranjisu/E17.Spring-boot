package com.example.E17.Spring.boot.controller;




import com.example.E17.Spring.boot.entity.CheckOut;
import com.example.E17.Spring.boot.entity.Product;
import com.example.E17.Spring.boot.services.CheckOutService;
import com.example.E17.Spring.boot.services.ProductService;
import com.example.E17.Spring.boot.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import org.springframework.web.client.RestTemplate;

//...



@org.springframework.stereotype.Controller
@RequestMapping
public class CheckOutController {



 @Autowired
 private RestTemplate restTemplate;

    private final CheckOutService checkOutService;
    private final ProductService productService;

    private final UserService userService;


    public static String x;













    public CheckOutController(CheckOutService checkOutService, ProductService productService, UserService userService) {
        this.checkOutService = checkOutService;
        this.productService = productService;
        this.userService = userService;
    }

    //@GetMapping("/allCheckOut")



    @RequestMapping(value="/reloadProd", method=RequestMethod.GET)
    public String allProd(Model model){

        model.addAttribute("products", productService.getAllProduct());

        return "products/addtoCart :: test_frag1";
    }




    @RequestMapping(value="/increment", method=RequestMethod.POST)
    public String increment(@ModelAttribute CheckOut checkOut,Model model){



        String uname = checkOutService.findByCheckOutId(checkOut.getCheckOutId()).getUsername();
        checkOut.setUsername(uname);

        int productId = checkOut.getProductId();
        int ckQuantity = checkOut.getProductQuantity();

        try {
            Product product = productService.findProduct(String.valueOf(productId));
            int pQuantity =product.getQuantity();

            System.out.println(" i got my "+product.getProductName()+"and i have "+product.getQuantity());



            if(pQuantity!=0){
                product.setQuantity(pQuantity-1);
                System.out.println(" i got my "+product.getProductName()+"and i have "+product.getQuantity());
                checkOut.setProductQuantity(ckQuantity+1);
                checkOut.setProductTotal((ckQuantity+1)*checkOut.getPrice());
                checkOutService.addCheckOut(checkOut);

                productService.addProduct(product);

            }




        }catch (Exception e){


        }

        model.addAttribute("checkOuts", checkOutService.findByUserName(x));


        return "products/addtoCart :: test_frag";
    }




    @RequestMapping(value="/decrement", method=RequestMethod.POST)
    public String decrement(@ModelAttribute CheckOut checkOut,Model model){



        String rname = checkOutService.findByCheckOutId(checkOut.getCheckOutId()).getUsername();
        checkOut.setUsername(rname);

        int productId = checkOut.getProductId();
        int ckQuantity = checkOut.getProductQuantity();



        try{
            Product product = productService.findProduct(String.valueOf(productId));
            int pQuantity =product.getQuantity();

            System.out.println(" i got my "+product.getProductName()+"and i have "+product.getQuantity());



            if(ckQuantity!=0){
                product.setQuantity(pQuantity+1);
                System.out.println(" i got my "+product.getProductName()+"and i have "+product.getQuantity());
                checkOut.setProductQuantity(ckQuantity-1);
                checkOut.setProductTotal((ckQuantity-1)*checkOut.getPrice());
                checkOutService.addCheckOut(checkOut);
                productService.addProduct(product);

                if(ckQuantity-1==0){
                    checkOutService.deleteCheckOut(checkOut);
                }



            }

        }catch (Exception e){
            checkOutService.deleteCheckOut(checkOut);
        }



        model.addAttribute("products", productService.getAllProduct());

        model.addAttribute("checkOuts", checkOutService.findByUserName(x));


        return "products/addtoCart :: test_frag";
    }









    @RequestMapping(value = "/allCheckOut", method = RequestMethod.GET)
    public String getAllCheckouts(Model model, HttpServletRequest request){

        String userId = (String) request.getSession().getAttribute("userId");
        x = userId;

        String role =  userService.findUser(x).getRole();

    try {



        model.addAttribute("userid", userId);


        if(role.equals("Seller")){

            model.addAttribute("products", productService.findByUserName(x));
            return "products/productlist";


        }
        /*    System.out.println("Size of all checkouts by "+userId+":"+checkOutService.findByUserName(userId).size());*/
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("checkouts", checkOutService.findByUserName(x));



        return "products/addtoCart";

    }catch(Exception e){
        return "products/index";
       }







   }



    @RequestMapping(value="/test_ajax_frag", method=RequestMethod.POST)
    public String sendHtmlFragment(Model model) {
         model.addAttribute("userid", x);
        model.addAttribute("checkOuts", checkOutService.findByUserName(x));
    return "products/addtoCart :: test_frag";
    }






/*    @PostMapping("/addCheckOut")*/
    @RequestMapping(value="/addCheckOut", method=RequestMethod.POST)
    public String submitForm( @ModelAttribute CheckOut checkOut, Model model) {



        checkOut.setUsername(x);
        System.out.println("valiue of x "+x);
        model.addAttribute("userid", x);
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("checkOuts", checkOutService.findByUserName(checkOut.getUsername()));


        try {
            int quantity = Integer.parseInt(String.valueOf(checkOut.getProductQuantity()));
            checkOut.setProductTotal(quantity*checkOut.getPrice());
            String userName = checkOut.getUsername();
            Integer prodId = checkOut.getProductId();

            Product product = productService.findProduct(String.valueOf(prodId));

            if(quantity>product.getQuantity()){
              /*  return "products/addtoCart";*/
                return "products/addtoCart :: test_frag";
            }

            product.setQuantity(product.getQuantity()-quantity);


            try{

                int newCoId = checkOutService.findByUserNameId(userName, prodId).getCheckOutId();
                int currQuantity = checkOutService.findByUserNameId(userName, prodId).getProductQuantity();
                checkOut.setCheckOutId(newCoId);
                checkOut.setProductQuantity(currQuantity+checkOut.getProductQuantity());
                checkOut.setProductTotal(checkOut.getPrice()*checkOut.getProductQuantity());
            }
            catch (Exception e){

            }

        }catch (Exception e){
            System.out.println(e);
      /*      return "products/addtoCart";*/
            return "products/addtoCart :: test_frag";
        }








        checkOut.setUsername(x);
        checkOutService.addCheckOut(checkOut);
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("checkOuts", checkOutService.findByUserName(checkOut.getUsername()));








 /*       return "products/addtoCart";*/

        return "products/addtoCart :: test_frag";


    }


    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }

    


}
