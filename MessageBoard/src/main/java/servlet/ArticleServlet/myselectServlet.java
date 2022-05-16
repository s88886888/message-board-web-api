package servlet.ArticleServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
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
import java.util.List;

@WebServlet("/getmyArticleData")
public class myselectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        ArticleDao articleDao = new ArticleDao();




        String token = req.getHeader("token");

        UserDao userDao = new UserDao();

        try {
            String phone = Token.verifyToken(token);
            User user = userDao.selectByphone(phone);
            if (user == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }
            List<Article> articles = articleDao.selectByauthor(user.Name);
            jsonReader.getJson(req, resp, resultVo.success(articles));
        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
            return;
        }

    }
}
