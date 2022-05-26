package Pooltool;

import model.ResultVo;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证token是否有效
 */

@WebFilter(filterName = "TokenFilter", urlPatterns = {"/addArticle", "/getArticleData", "/deletearticle"})
public class TokenFilter extends HttpFilter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException {


        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;
        // 获取token
        String token = req.getHeader("token");

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();


        if (token != null) {
            try {
                String username = Token.verifyToken(token);
                if (username == null) {
                    jsonReader.getJson(req, resp, resultVo.error("token失效，请重新登录"));
                } else {
                    // 验证成功 放行
                    chain.doFilter(req, response);
                }
            } catch (Exception e) {
                jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
            }
        } else {
            jsonReader.getJson(req, resp, resultVo.error("未登录，请先登录"));
        }

    }
}
