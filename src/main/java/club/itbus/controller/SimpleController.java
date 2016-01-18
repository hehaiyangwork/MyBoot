package club.itbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @RestController注解作用：为该controller类下的所有方法添加@ResponseBody注解
 */
//@RestController
@Controller
@RequestMapping
public class SimpleController {

    @Value("${appName}")
    private String appName;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> index(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","hello");
        map.put("appName", appName);
        return map;
    }

    @RequestMapping(value = "/jsp", method = RequestMethod.GET)
    public ModelAndView jsp(){
        ModelMap model = new ModelMap();
        model.addAttribute("app", this.appName);
        model.addAttribute("time", new Date());
        return new ModelAndView("welcome", model);
    }


    @RequestMapping(value = "/jsp2", method = RequestMethod.GET)
    public String jsp2(HttpServletRequest request){
        request.setAttribute("app", this.appName);
        request.setAttribute("time", new Date());
        return "welcome";
    }


}