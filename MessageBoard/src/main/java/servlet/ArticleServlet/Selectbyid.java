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


@WebServlet("/selectByid")
public class Selectbyid extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        ArticleDao articleDao = new ArticleDao();
        int id = Integer.parseInt(req.getParameter("id"));
        Article articles = articleDao.selectByid(id);
        jsonReader.getJson(req, resp, resultVo.success(articles));
    }

}
