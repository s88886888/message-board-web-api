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
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        User user = new User();

//        String phone = req.getParameter("phone");
//        String password = req.getParameter("password");
//        String email = req.getParameter("email");
//        String name = req.getParameter("name");


        user.setPhone(req.getParameter("phone"));
        user.setPassWord(req.getParameter("password"));
        user.setEmail(req.getParameter("email"));
        user.setName(req.getParameter("name"));


        ResultVo resultVo = new ResultVo();
        JsonReader jsonReader = new JsonReader();
        String regex = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(17[013678])|(18[0,5-9]))\\d{8}$";
        if (user.Phone.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("手机账号不能为空"));
            return;
        } else if (regex.equals(user.Phone)) {
            jsonReader.getJson(req, resp, resultVo.error("你还是别注册了，搁着试我bug呢"));
            return;
        } else if (user.Phone.length() < 11) {
            jsonReader.getJson(req, resp, resultVo.error("手机账号格式错误"));
            return;
        } else if (user.PassWord.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("密码不能为空"));
            return;
        } else if (user.Email.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("email不能为空"));
            return;
        } else if (user.Name.equals("")) {
            jsonReader.getJson(req, resp, resultVo.error("昵称不能为空"));
            return;
        }
        UserDao userDao = new UserDao();
        User userphone = userDao.selectByphone(user.Phone);
        try {
            if (userphone != null) {
                jsonReader.getJson(req, resp, resultVo.error("手机已经注册过了"));
                return;
            }
            if (userDao.AddbUser(user.Name, user.Phone, user.PassWord, user.Email)) {
                jsonReader.getJson(req, resp, resultVo.success("注册成功"));
            } else {
                jsonReader.getJson(req, resp, resultVo.error("注册失败"));
            }

        } catch (Exception e) {
            jsonReader.getJson(req, resp, resultVo.error(e.getMessage()));
        }
    }
}
