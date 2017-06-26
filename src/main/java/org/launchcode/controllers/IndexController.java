package org.launchcode.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.PublicKey;

/**
 * Created by rebeccahubbard on 6/26/17.
 */

@Controller
@RequestMapping("")
public class IndexController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String indexHandler(){
        return "redirect:/cheese";

    }

}
