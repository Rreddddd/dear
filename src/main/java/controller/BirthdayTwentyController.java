package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.BirthdayTwentyStartService;
import service.BirthdayTwentyViewService;
import service.impl.BirthdayTwentyStartImplService;

import java.util.HashMap;
import java.util.Map;

@RequestMapping("/dear/birthday/twenty")
@Controller("controller.BirthdayTwentyController")
public class BirthdayTwentyController {

    private BirthdayTwentyStartService birthdayTwentyStartService;
    private BirthdayTwentyViewService birthdayTwentyViewService;

    @Autowired
    public BirthdayTwentyController(BirthdayTwentyStartImplService birthdayTwentyStartImplService,BirthdayTwentyViewService birthdayTwentyViewService){
        this.birthdayTwentyStartService=birthdayTwentyStartImplService;
        this.birthdayTwentyViewService=birthdayTwentyViewService;
    }

    @RequestMapping("/")
    public ModelAndView start(){
        if(birthdayTwentyStartService.getSuccessState()){
            return new ModelAndView("redirect:/dear/birthday/twenty/pageIn/");
        }else{
            return new ModelAndView("jsp/birthday/twenty/start");
        }
    }

    @ResponseBody
    @RequestMapping("/check")
    public Map<String,Object> check(@RequestParam("userName") String userName, @RequestParam("password") String password){
        Map<String,Object> result=new HashMap<String, Object>();
        String successUserName="我的宝贝",successPassword;
        int errorCount=birthdayTwentyStartService.getErrorCount();
        if(errorCount>=3){
            successPassword="gege";
        }else{
            successPassword="woaini";
        }
        if(successUserName.equals(userName.trim()) && successPassword.equals(password)){
            result.put("code",0);
            birthdayTwentyStartService.save(userName,password,true);
            result.put("errorCount",errorCount);
        }else{
            if(errorCount>=3){
                result.put("code",2);
            }else{
                result.put("code",1);
            }
            birthdayTwentyStartService.save(userName,password,false);
            result.put("errorCount",errorCount+1);
        }
        return result;
    }

    @RequestMapping("/pageIn")
    public ModelAndView pageIn(){
        if(birthdayTwentyViewService.getLikeState()){
            return new ModelAndView("jsp/birthday/twenty/memories");
        }else{
            return new ModelAndView("jsp/birthday/twenty/view");
        }
    }

    @ResponseBody
    @RequestMapping("/pick")
    public Map<String,Object> pick(@RequestParam("type") boolean type){
        Map<String,Object> result=new HashMap<String, Object>();
        birthdayTwentyViewService.save(type);
        result.put("dontCount",birthdayTwentyViewService.getDontLikeCount());
        return result;
    }

    @ResponseBody
    @RequestMapping("/reInit")
    public Map<String,Object> reInit(){
        Map<String,Object> result=new HashMap<String, Object>();
        try {
            birthdayTwentyStartService.removeAll();
            birthdayTwentyViewService.removeAll();
            result.put("success",true);
        }catch (Exception e){
            e.printStackTrace();
            result.put("success",false);
        }
        return result;
    }
}
