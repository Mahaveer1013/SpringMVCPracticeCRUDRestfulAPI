/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.springmvcpracticecrudrestfulapi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Thammana Srinivas
 */
@Controller
public class HomeRedirectionController {
    @RequestMapping("/home")
    public String redirection() {
        return "home";
    }
}
