package Pooltool;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 验证token是否有效
 */

@WebFilter(filterName = "TokenFilter", urlPatterns = {"/addArticle"})
public class TokenFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) request;
        // 获取token
        String token = req.getHeader("token");
        JSONObject jsonObject = new JSONObject();

        if (token != null) {
            try {
                String username = Token.verifyToken(token);
                if (username == null) {
                    jsonObject.put("err", "用户失效, 请重新登陆");
                    jsonObject.put("errcode", "998");
                    response.getWriter().print(jsonObject.toJSONString());
                } else {
                    // 验证成功
                    req.setAttribute("username", username);
                    chain.doFilter(req, response);
                }
            } catch (Exception e) {
                jsonObject.put("err", e.getMessage());
                jsonObject.put("errcode", "999");
                response.getWriter().print(jsonObject.toJSONString());
            }
        } else {
            jsonObject.put("err", "尚未登录, 请登陆");
            jsonObject.put("errcode", "998");
            response.getWriter().print(jsonObject.toJSONString());
        }

    }
}
