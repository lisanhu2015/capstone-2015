package org.lsh.controller.global;

import org.lsh.service.LoginService;
import org.lsh.util.model.LoginUser;
import org.lsh.util.validator.LoginUserValidator;
import org.lsh.utils.HelperFunctions;
import org.lsh.utils.MessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by lsh on 15/3/3.
 */
@Controller
@RequestMapping(value = "/global")
@Scope(value = "request")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String redirect() {
        return "global/login";
    }

    @InitBinder
    public void initBinder(DataBinder binder) {
        binder.setValidator(new LoginUserValidator());
    }

    @Autowired
    private MessageQueue errors;

    @Autowired
    private LoginService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
                        @ModelAttribute("login") @Valid
                        LoginUser user,
                        BindingResult result, Model model) {

        try {
            request.login(user.getUserId(), user.getPassword());
        } catch (ServletException e) {
            e.printStackTrace();
        }
        System.err.println(HelperFunctions.ObjectToJsonString(request.getUserPrincipal()));

        if (result.hasErrors()) {
            return "global/login";
        }

        if (!service.Login(user, errors)) {
            model.addAttribute("errors", errors);
            return "global/login";
        }

        return "success";
    }

}
