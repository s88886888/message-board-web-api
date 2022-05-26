package servlet.UserServlet;

import Pooltool.JsonReader;
import Pooltool.Token;
import dao.UserDao;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateuserimg")
public class UpdateImg extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String phone = req.getParameter("phone");
        String img = req.getParameter("img");


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        UserDao userDao = new UserDao();


        if (phone.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("phone不能为空"));
            return;
        }

        String token = req.getHeader("token");

        try {

            String aixosphone  = Token.verifyToken(token);
            if (aixosphone==null)
            {
                jsonReader.getJson(req, resp, resultVo.error("异常用户"));
                return;
            }else
            {
                if (!aixosphone.equals(phone))
                {
                    jsonReader.getJson(req, resp, resultVo.error("没有权限"));
                    return;
                }
                else
                {
                    if (userDao.updateUserimg(phone,img))
                    {
                        jsonReader.getJson(req, resp, resultVo.success("修改图片成功，记得按一下保存个人信息"));
                        return;
                    }
                    else
                    {
                        jsonReader.getJson(req, resp, resultVo.error("修改失败"));
                        return;
                    }
                }

            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));

        }
    }
}
