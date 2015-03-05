package org.lsh.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lsh on 15/3/4.
 */
@Controller
public class TestController {

    @RequestMapping(value = {"/student/*", "/instructor/*", "/officer/*", "/others/*"})
    public String redirect() {
        return "student/success";
    }

}
