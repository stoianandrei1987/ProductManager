package ro.andreistoian.ProductManager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.andreistoian.ProductManager.models.Product;
import ro.andreistoian.ProductManager.services.ProductService;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private ProductService service;

    @RequestMapping("/")
    public String viewHomePage(Model model){

        List<Product> productList = service.listAll();
        model.addAttribute("productList", productList);
        return "index";
    }

    @RequestMapping("/new")
    public String createProduct(Model model)
    {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @RequestMapping(value = "/save", method= RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        service.save(product);
        return "redirect:/";
    }



    @RequestMapping(value = "/edit/{id}")
    public ModelAndView editProduct(@PathVariable(name = "id") Long id) {

        ModelAndView mav = new ModelAndView("edit_product");
        Product p = service.get(id);
        mav.addObject("product", p);
        return mav;
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/";
    }

}
