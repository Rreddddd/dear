package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.RequestTools;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/home")
@Controller("controller.HomePageController")
public class HomePageController {

    @RequestMapping("")
    public ModelAndView index(HttpServletRequest request){
        return new ModelAndView(RequestTools.isPhone(request)?"/jsp/home/index_mobile":"/jsp/home/index");
    }
}
