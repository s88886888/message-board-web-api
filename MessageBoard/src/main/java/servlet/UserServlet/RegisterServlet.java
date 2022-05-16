package servlet.UserServlet;

import Pooltool.JsonReader;
import dao.UserDao;
import model.ResultVo;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {



        resp.setContentType("application/json; charset=utf-8");
        resp.setCharacterEncoding("UTF-8");


        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String name = req.getParameter("name");

        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();

        if(phone == ""){
            jsonReader.getJson(req,resp,resultVo.error("手机账号不能为空"));
            return;
        }
        else if (password=="")
        {
            jsonReader.getJson(req,resp,resultVo.error("密码不能为空"));
            return;
        }
        else if (email=="")
        {
            jsonReader.getJson(req,resp,resultVo.error("email不能为空"));
            return;
        }
        else if (name=="")
        {
            jsonReader.getJson(req,resp,resultVo.error("昵称不能为空"));
            return;
        }



        UserDao userDao = new UserDao();
        User userphone= userDao.selectByphone(phone);
        try {

            if (userphone!=null){
                jsonReader.getJson(req,resp,resultVo.error("手机已经注册过了"));
                return;
            }

            if (userDao.AddbUser(name,phone,password,email))
            {

                jsonReader.getJson(req,resp,resultVo.success("注册成功"));
            }
            else
            {
                jsonReader.getJson(req,resp,resultVo.error("注册失败"));
                return;
            }

        }catch (Exception e){
            jsonReader.getJson(req,resp,resultVo.error(e.getMessage()));
        }






    }
}
