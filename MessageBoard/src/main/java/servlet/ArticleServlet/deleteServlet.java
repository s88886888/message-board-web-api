package servlet.ArticleServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.AdminDao;
import dao.ArticleDao;
import dao.UserDao;
import model.Admin;
import model.Article;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/deletearticle")
public class deleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        ArticleDao articleDao = new ArticleDao();

        int id = Integer.parseInt(req.getParameter("id"));

         Article article = articleDao.selectByid(id);

        UserDao userDao = new UserDao();
        AdminDao adminDao = new AdminDao();

        String token = req.getHeader("token");




        try {

            String   key = Token.verifyToken(token);
            User user = userDao.selectByphone(key);
            Admin admin = adminDao.Selectbyname(key);

            if (user == null||admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }
            if (article==null)
            {
                jsonReader.getJson(req, resp, resultVo.error("文章不存在"));
                return;
            }
            else
            {
                if ( articleDao.delect(id))
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

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error("未知错误"));
            return;
        }
    }
}
