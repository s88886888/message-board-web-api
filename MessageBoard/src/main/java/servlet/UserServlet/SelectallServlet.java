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
import java.util.List;

@WebServlet("/SelectUser")
public class SelectallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        UserDao UserDao = new UserDao();

        List<User> articles = UserDao.selectAll();


        jsonReader.getJson(req, resp, resultVo.success(articles));
    }
}
