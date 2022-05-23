package servlet.AdminServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import com.sun.net.httpserver.HttpsServer;
import dao.AdminDao;
import dao.ArticleDao;
import dao.AdminDao;
import model.ResultVo;
import model.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


@WebServlet("/updateServletbyadmin")
public class updateServletbyadmin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        String articlename = req.getParameter("articlename");
        String text = req.getParameter("text");
        String img = req.getParameter("img");
        int id = Integer.parseInt(req.getParameter("id"));


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();


        if (articlename == "") {
            jsonReader.getJson(req, resp, resultVo.error("作品名字不可以为空"));
            return;
        } else if (text == "") {
            jsonReader.getJson(req, resp, resultVo.error("内容不能为空"));
            return;
        }
        ArticleDao articleDao = new ArticleDao();
        AdminDao AdminDao = new AdminDao();
        Date time = new Date(new Date().getTime());
        String token = req.getHeader("token");
        try {
            String name = Token.verifyToken(token);
            Admin admin = AdminDao.Selectbyname(name);
            if (admin == null) {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }
            if (articleDao.UpdateArticle(id, articlename, text, img)) {
                jsonReader.getJson(req, resp, resultVo.success("修改成功"));
            } else {
                jsonReader.getJson(req, resp, resultVo.error("注册失败"));
                return;
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
        }
        
    }
}
