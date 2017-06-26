package org.launchcode.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.launchcode.models.AddMenuItemForm;
import org.launchcode.models.Menu;
import org.launchcode.models.data.CheeseDao;
import org.launchcode.models.data.MenuDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.validation.Valid;
import java.util.Random;

@Controller
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuDao menuDao;

    @Autowired
    private CheeseDao cheeseDao;

    @RequestMapping(value = "")
    public String index(Model model) {

        model.addAttribute("menus", menuDao.findAll());
        model.addAttribute("title", "My Menus");

        return "menu/index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add (Model model){
        model.addAttribute("title", "Add Menu");
        model.addAttribute(new Menu());
        return "/menu/add-menu";
    }

    @RequestMapping(value="add", method=RequestMethod.POST)
    public String add(Model model, @ModelAttribute @Valid Menu menu, Errors errors){
        if(errors.hasErrors()){
            model.addAttribute(menu);
            return"menu/add";
        }
        menuDao.save(menu);
        return"redirect:view/"+menu.getId();
    }

    @RequestMapping(value = "view/{menuId}", method = RequestMethod.GET)
    public String viewMenu(Model model, @PathVariable("menuId") int id){
        Menu menu = menuDao.findOne(id);
        model.addAttribute("title", menu.getName());
        model.addAttribute("menu", menu);

        return "menu/view";
    }

    @RequestMapping(value = "add-item/{menuId}", method = RequestMethod.GET)
    public String addItem(Model model, @PathVariable("menuID") int id) {
        Menu menu = menuDao.findOne(id);
        Iterable cheeses = cheeseDao.findAll();

        AddMenuItemForm form = new AddMenuItemForm(menu,cheeses);

        model.addAttribute("form", form);
        model.addAttribute("title", "Add Item to Menu" + menu.getName());

        return "menu/add-item";

    }

}
