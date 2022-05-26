package servlet.UserServlet;

import Pooltool.JsonReader;
import dao.UserDao;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Selectbyphone")
public class Selectbyphone extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        String phone = req.getParameter("phone");
        UserDao userDao = new UserDao();
        if (phone.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("name不可以为空"));
            return;
        }
        try {

            User user = userDao.selectByphone(phone);
            jsonReader.getJson(req, resp, resultVo.success(user));


        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.success(e.getMessage()));
        }
    }
}




