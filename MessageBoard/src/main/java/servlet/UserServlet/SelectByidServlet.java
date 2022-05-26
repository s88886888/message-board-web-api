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


@WebServlet("/selectuserbyid")
public class SelectByidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        int id = Integer.parseInt(req.getParameter("id"));

        if (id == 0) {
            jsonReader.getJson(req, resp, resultVo.error("id不可以为空"));
            return;
        }
        UserDao userDao = new UserDao();
        AdminDao adminDao = new AdminDao();
        String token = req.getHeader("token");
        try {
            String name = Token.verifyToken(token);
            Admin admin = adminDao.Selectbyname(name);

            if (admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("token异常重新登录"));
            } else {
                User user = userDao.selectbyid(id);
                jsonReader.getJson(req, resp, resultVo.success(user));
            }
        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.success(e.getMessage()));
        }
    }
}
