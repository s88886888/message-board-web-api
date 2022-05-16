package servlet.UserServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.UserDao;
import model.ResultVo;
import model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {




        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");

        String phone = req.getParameter("phone");
        String password = req.getParameter("password");


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();


        if (phone == "") {
            jsonReader.getJson(req, resp, resultVo.error("手机账号不能为空"));
        } else if (password == "") {
            jsonReader.getJson(req, resp, resultVo.error("密码不能为空"));
        }

        UserDao userDao = new UserDao();
        try {
            if (userDao.Login(phone, password) == null) {
                jsonReader.getJson(req, resp, resultVo.error("登录失败"));
            } else {
               User user = userDao.selectByphone(phone);

                String token = Token.getToken(user.getPhone());
                resp.setHeader("token", token);

                jsonReader.getJson(req, resp, resultVo.success("登录成功"));
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.success(e.getMessage()));
        }

    }
}
