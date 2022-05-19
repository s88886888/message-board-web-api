package Pooltool;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonReader {


    public void getJson(HttpServletRequest request, HttpServletResponse response, Object object) {
        response.setContentType("text/html;charset=UTF-8");
        /** 设置响应头允许跨域访问 **/
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 星号表示所有的异域请求都可以接受， */
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");


//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:8020");

//        chain.doFilter(request, response);


        //禁用缓存，确保网页信息是最新数据
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -10);
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Gson gson = new Gson();
            out.print(gson.toJson(object));
            out.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            out.close();
        }
    }


}