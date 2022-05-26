package Pooltool;

import dao.AdminDao;
import model.Admin;
import model.ResultVo;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AdminTokenFilter", urlPatterns = {"/selectuserbyname", "/SelectUser", "/selectuserbyid", "/updateServletbyadmin", "/deleteuser"})
public class TokenAdminFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException {


        HttpServletRequest req = (HttpServletRequest) request;

        HttpServletResponse resp = (HttpServletResponse) response;

        // 获取token
        String token = req.getHeader("token");

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        AdminDao adminDao = new AdminDao();


        if (token != null) {
            try {
                String name = Token.verifyToken(token);
                if (name == null) {
                    jsonReader.getJson(req, resp, resultVo.error("token失效，请重新登录"));
                }
                Admin admin = adminDao.Selectbyname(name);
                if (admin == null) {
                    jsonReader.getJson(req, resp, resultVo.error("您不是管理员"));
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


