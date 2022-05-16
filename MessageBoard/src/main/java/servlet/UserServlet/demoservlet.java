package servlet.UserServlet;

import Pooltool.JsonReader;
import model.ResultVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo")
public class demoservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        resp.setHeader("Access-Control-Allow-Methods", "GET,POST");

        resp.setHeader("Access-Control-Allow-Headers", "token");
        resp.setHeader("Access-Control-Expose-Headers", "token");

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        jsonReader.getJson(req, resp, resultVo.success("跨域测试"));
    }
}
