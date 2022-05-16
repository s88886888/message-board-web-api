package servlet.ArticleServlet;

import Pooltool.JsonReader;
import dao.ArticleDao;
import model.Article;
import model.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getArticleData")
public class SelectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {




        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        ArticleDao articleDao = new ArticleDao();
        List<Article> articles = articleDao.selectAll();
        jsonReader.getJson(req, response, resultVo.success(articles));



    }
}
