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

@WebServlet("/deleteuser")
public class DeleteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        UserDao userDao = new UserDao();

        int id = Integer.parseInt(req.getParameter("id"));

        User user = userDao.selectbyid(id);

        if (user==null)
        {
            jsonReader.getJson(req, resp, resultVo.error("用户不存在"));
            return;
        }
        else
        {
            if (userDao.deletebyid(id))
            {
                jsonReader.getJson(req, resp, resultVo.error("删除成功"));
                return;
            }
            else
            {
                jsonReader.getJson(req, resp, resultVo.error("删除错误"));
                return;
            }

        }
    }
}
