package club.itbus.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * @RestController注解作用：为该controller类下的所有方法添加@ResponseBody注解
 */
@RestController
@RequestMapping
public class SimpleController {

    @Value("${appName}")
    private String appName;

    @RequestMapping(method = RequestMethod.GET)
    public Map<String,Object> index(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("message","hello");
        map.put("appName", appName);
        Cookie cookie = new Cookie("aouth_token","abcde1872sdfsdf34s2gg443s");
        cookie.setMaxAge(60*60*2);//秒
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return map;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Map<String,Object> hello(HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("name","hehaiyang");
        map.put("age", 21);
        Cookie[] cookies=request.getCookies();
        /**
         * 用户登录网站，登录，获取ip,生成sign. redis 保存md5(ip+sign)。设置cookie(sign)
         *
         * 用户第二次访问，获取ip,sign。得到md5(ip+sign),比较redis,存在即为已登录。
         */
        if(!cookies[1].getValue().equals("abcde1872sdfsdf34s2gg443s")){
            try{
                response.sendRedirect("/");
            }catch (Exception e){
            }

        }
        return map;
    }

    public String getRemoteAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || ip.equalsIgnoreCase("unknown")) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    public String getMACAddress(String ip) {
        String str = "";
        String macAddress = "";
        try {
            Process p = Runtime.getRuntime().exec("nbtstat -A " + ip);
            InputStreamReader ir = new InputStreamReader(p.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);
            for (int i = 1; i < 100; i++) {
                str = input.readLine();
                if (str != null) {
                    if (str.indexOf("MAC Address") > 1) {
                        macAddress = str.substring(
                                str.indexOf("MAC Address") + 14, str.length());
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        return macAddress;
    }

//    public static void main(String[] args) {
//        SpringApplication.run(SimpleController.class, args);
//    }
}