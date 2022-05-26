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


@WebServlet("/updateUser")
public class UpdateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String Phone = req.getParameter("phone");
        String Email = req.getParameter("email");
        String Name = req.getParameter("name");
        String PassWord = req.getParameter("password");

        int id = Integer.parseInt(req.getParameter("id"));

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        UserDao userDao = new UserDao();

        if (Phone.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("电话不可以为空"));
            return;
        }

        User phoneuser = userDao.selectByphone(Phone);

        if (phoneuser != null) {
            jsonReader.getJson(req, resp, resultVo.error("电话已经存在了"));
            return;
        } else if (Email.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("Email不能为空"));
            return;
        } else if (Name.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("Name不能为空"));
            return;
        } else if (PassWord.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("PassWord不能为空"));
            return;
        } else if (id == 0) {
            jsonReader.getJson(req, resp, resultVo.error("id不能为空"));
            return;
        }

        AdminDao adminDao = new AdminDao();

        try {
            String token = req.getHeader("token");
            String key = Token.verifyToken(token);
            User user = userDao.selectByphone(key);
            Admin admin = adminDao.Selectbyname(key);
            if (user == null && admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }
            if (userDao.updateUser(id, Name, PassWord, Phone, Email)) {
                jsonReader.getJson(req, resp, resultVo.success("修改成功"));
            } else {
                jsonReader.getJson(req, resp, resultVo.error("修改失败"));
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
        }
    }
}
