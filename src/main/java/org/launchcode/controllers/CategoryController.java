package org.launchcode.controllers;

import org.launchcode.models.Category;
import org.launchcode.models.data.CategoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

/**
 * Created by rebeccahubbard on 6/21/17.
 */

@Controller
@RequestMapping("category")
public class CategoryController {
    @Autowired
    private CategoryDao categoryDao;

    @RequestMapping("")
    public String indexHandler(Model model){
        model.addAttribute("Categories", categoryDao.findAll());
        return "category/index";
    }
}
