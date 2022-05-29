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


        int id = Integer.parseInt(req.getParameter("id"));


        UserDao userDao = new UserDao();
        AdminDao adminDao = new AdminDao();
        ArticleDao articleDao = new ArticleDao();

        String token = req.getHeader("token");


        try {

            String key = Token.verifyToken(token);

            User user = userDao.selectByphone(key);
            Admin admin = adminDao.Selectbyname(key);


            if (user == null && admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常请求，请重新登录"));
                return;
            }

            Article article = articleDao.selectByid(id);
            if (article == null) {
                jsonReader.getJson(req, resp, resultVo.error("文章不存在"));
                return;
            }
            if (user != null) {
                if (article.authorid != user.id) {
                    jsonReader.getJson(req, resp, resultVo.error("不是你的作品！没有权限"));

                    return;
                }else{
                    if (articleDao.delect(id)) {
                        jsonReader.getJson(req, resp, resultVo.success("删除成功"));
                    } else {
                        jsonReader.getJson(req, resp, resultVo.error("删除错误"));
                    }
                    return;
                }

            }
        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error("未知错误"));
            return;
        }
    }
}
