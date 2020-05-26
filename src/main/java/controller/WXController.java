package controller;

import entity.MemberEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import util.WXTools;

@RequestMapping("/wx")
@Controller("controller.WXController")
public class WXController {

    @ResponseBody
    @RequestMapping("/getMember")
    public MemberEntity getMember(@RequestParam("jsCode") String jsCode,@RequestParam("iv") String iv,
                                  @RequestParam("encryptedData") String encryptedData){
        return WXTools.getMemberByJsCode(encryptedData,jsCode,iv);
    }
}
