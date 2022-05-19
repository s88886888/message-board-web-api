package servlet.UserServlet;

import Pooltool.JsonReader;
import dao.ArticleDao;
import dao.UserDao;
import model.Article;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/selectuserbyname")
public class SelectByidServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        UserDao userDao = new UserDao();
        String name = req.getParameter("name");

        User user = userDao.selectbyname(name);
        jsonReader.getJson(req, resp, resultVo.success(user));
    }
}
