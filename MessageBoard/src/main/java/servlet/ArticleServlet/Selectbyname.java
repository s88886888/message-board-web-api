package servlet.ArticleServlet;

import Pooltool.JsonReader;
import dao.ArticleDao;
import model.Article;
import model.ResultVo;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/selectByname")
public class Selectbyname extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        ArticleDao articleDao = new ArticleDao();

        String name = req.getParameter("name");
        if (name=="")
        {
            jsonReader.getJson(req, resp, resultVo.success("没有这个作品"));
            return;
        }
        else {
            List<Article> articles = articleDao.selectLikeData(name);

            jsonReader.getJson(req, resp, resultVo.success(articles));
        }
    }

}
