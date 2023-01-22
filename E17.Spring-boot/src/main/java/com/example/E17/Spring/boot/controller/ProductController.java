package com.example.E17.Spring.boot.controller;



import com.example.E17.Spring.boot.entity.Product;
import com.example.E17.Spring.boot.services.ProductService;
import com.example.E17.Spring.boot.services.RecordNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@org.springframework.stereotype.Controller
@RequestMapping
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/index")
    public String goToHome(){

        return  "products/index";
    }
//    @GetMapping ("addProductPage")
//    public String addProductPage(Model model){
//        return "product/addProductPage";
//    }
//
//    @PostMapping("/addProduct")
//    public String addProduct(@ModelAttribute Product product){
//
//
//
//
//        if(product.getProductName().isEmpty()  String.valueOf(product.getQuantity()).isEmpty()  String.valueOf(product.getPrice()).isEmpty() || product.getImageUrl().isEmpty()){
//            return "product/addProductPage";
//        }
//
//        productService.addProduct(product);
//
//        return "product/addProductPage";
//    }


    @GetMapping("/allProducts")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products/productlist";
    }


    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute Product product, Model model){

         String username = product.getUsername();
        model.addAttribute("products", productService.findByUserName(username));
          if(product.getProductName().isEmpty()){
              return "products/productlist";
          }


        if(String.valueOf(product.getPrice()).isEmpty()){
            return "products/productlist";
        }

        if(String.valueOf(product.getQuantity()).isEmpty()){
            return "products/productlist";
        }

        if(product.getImageUrl().isEmpty()){
            return "products/productlist";
        }


        productService.addProduct(product);
        model.addAttribute("userid", username);
        model.addAttribute("products", productService.findByUserName(username));

        model.addAttribute("products", productService.findByUserName(username));

        return "products/productlist";
    }


    @PostMapping("/save")
    public String submitForm(@RequestParam("submitButton") String submitButton, @ModelAttribute Product product, Model model) {
        String username = product.getUsername();
        model.addAttribute("products", productService.findByUserName(username));
        model.addAttribute("userid", username);
        System.out.println("heres my update "+ username);
        if (submitButton.equals("update")) {
            try {

                model.addAttribute("products", productService.findByUserName(username));
                 productService.findProduct(String.valueOf(product.getProductId()));
                productService.addProduct(product);
            }
            catch (Exception e){
                model.addAttribute("products", productService.findByUserName(username));
                model.addAttribute("products", productService.getAllProduct());
                return "products/productlist";
            }
        } else {
            model.addAttribute("products", productService.findByUserName(username));
            productService.deleteProduct(product);
        }



        model.addAttribute("products", productService.findByUserName(username));
        return "products/productlist";
    }




    @GetMapping("/Cart")
    public String addtoCart(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products/addtoCart";
    }








}

