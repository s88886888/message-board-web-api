package servlet.ArticleServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.ArticleDao;
import dao.UserDao;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/addArticle")
public class AddSevlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");


        String articlename = req.getParameter("articlename");
        String text = req.getParameter("text");
        String img = req.getParameter("img");


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        if (articlename == "") {
            jsonReader.getJson(req, resp, resultVo.error("作品名字不可以为空"));
            return;
        } else if (text == "") {
            jsonReader.getJson(req, resp, resultVo.error("内容不能为空"));
            return;
        } else if (img == "") {
            jsonReader.getJson(req, resp, resultVo.error("图片不能为空"));
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        UserDao userDao = new UserDao();
        Date time = new Date(new Date().getTime());

        try {
            String token = req.getHeader("token");
            String phone = Token.verifyToken(token);
            User user = userDao.selectByphone(phone);
            if (user == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }
            if (articleDao.AddArticle(articlename, time, user.Name, user.id, text, img, 0)) {
                jsonReader.getJson(req, resp, resultVo.success("注册成功"));
            } else {
                jsonReader.getJson(req, resp, resultVo.error("注册失败"));
                return;
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
        }
    }
}
