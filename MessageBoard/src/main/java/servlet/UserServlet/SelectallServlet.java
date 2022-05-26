package servlet.UserServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.AdminDao;
import dao.UserDao;
import model.Admin;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/SelectUser")
public class SelectallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        UserDao UserDao = new UserDao();

        AdminDao adminDao = new AdminDao();

        String token = req.getHeader("token");


        try {
            String name = Token.verifyToken(token);
            Admin admin = adminDao.Selectbyname(name);

            if (admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("token异常重新登录"));
            } else {
                List<User> user = UserDao.selectAll();
                jsonReader.getJson(req, resp, resultVo.success(user));
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.success(e.getMessage()));
        }
    }
}
