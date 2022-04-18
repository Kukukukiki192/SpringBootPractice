package com.example.crud.web;

import com.example.crud.dao.CategoryDAO;
import com.example.crud.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class CategoryController {

    @Autowired
    CategoryDAO categoryDAO;

    @GetMapping("/listCategory")
    public String listCategory(Model model){
        List<Category> cs = categoryDAO.findAll();
        log.info("{}",cs);
        model.addAttribute("cs",cs);
        return "listCategory";
    }

}
