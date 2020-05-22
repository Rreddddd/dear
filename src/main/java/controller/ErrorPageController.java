package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import util.RequestTools;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("/error")
@Controller("controller.ErrorPageController")
public class ErrorPageController {

    @RequestMapping("/404")
    public ModelAndView page_404(HttpServletRequest request){
        return new ModelAndView(RequestTools.isPhone(request)?"/jsp/404_mobile":"/jsp/404_pc");
    }
}
