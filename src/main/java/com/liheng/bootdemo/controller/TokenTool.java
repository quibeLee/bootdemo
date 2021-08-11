package com.liheng.bootdemo.controller;

/**

 *

 */


import javax.servlet.http.HttpServletRequest;




import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**

 * Token的工具类

 * @author zhous

 * @since 2018-2-23 14:01:41

 *

 */
@Controller
public class TokenTool {


    /**

     * 生成token放入session

     * @param request

     *

     */

    public static void createToken(HttpServletRequest request){

        String token = TokenProccessor.getInstance().makeToken();

        request.getSession().setAttribute("tokenKey", token);

    }

    /**

     * 移除token

     * @param request

     * @param tokenServerkey

     */

    public static void removeToken(HttpServletRequest request,String tokenServerkey){

        request.getSession().removeAttribute(tokenServerkey);

    }



    /**

     * 判断请求参数中的token是否和session中一致

     * @param request

     * @return

     */
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public  String login(HttpServletRequest request,String username,String password){

        createToken(request);

        String token_client = (String) request.getParameter("tokenKey");

        String user = username;
        String pwd = password;

       if(StringUtils.isEmpty(token_client) || user == null ||password == null){

            return "fail";

        }

        String token_server = (String) request.getSession().getAttribute("tokenKey");

        if(StringUtils.isEmpty(token_server)){

            return "fail";

        }

        if(!token_server.equals(token_client) || !user.equals("123") || !pwd.equals("123")){

            return "fail";

        }
        return "success";

    }

}
