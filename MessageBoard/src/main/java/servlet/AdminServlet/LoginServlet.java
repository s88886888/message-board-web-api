package servlet.AdminServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.AdminDao;
import model.Admin;
import model.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/AdminLogin")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String name = req.getParameter("name");
        String password = req.getParameter("password");


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();


        if (name == "") {
            jsonReader.getJson(req, resp, resultVo.error("手机账号不能为空"));
        } else if (password == "") {
            jsonReader.getJson(req, resp, resultVo.error("密码不能为空"));
        }

        AdminDao AdminDao = new AdminDao();
        try {
            if (AdminDao.Login(name, password) == null) {
                jsonReader.getJson(req, resp, resultVo.error("登录失败"));
            } else {

                Admin Admin = AdminDao.Selectbyname(name);

                String token = Token.getToken(Admin.getName());

                resp.setHeader("token", token);

                jsonReader.getJson(req, resp, resultVo.success("登录成功"));
            }
        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.success(e.getMessage()));
        }
    }
}
