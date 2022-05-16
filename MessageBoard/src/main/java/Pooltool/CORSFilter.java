package Pooltool;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
public class CORSFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        response.setContentType("text/html;charset=utf-8");

//        告诉浏览器, 可以从某个位置跨域来访问
//        String[] allowDomain = {"http://127.0.0.1:8999","http://localhost:8999"};
//        String originHeader = request.getHeader("Origin");
//        Set<String> allowedOrigins = new HashSet<>(Arrays.asList(allowDomain));
//        if (allowedOrigins.contains(originHeader)) {
//            response.setHeader("Access-Control-Allow-Origin", originHeader);
//        }


        // 告诉浏览器, 可以从某个位置跨域来访问
//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5501");

        /* 星号表示所有的异域请求都可以接受， */
//        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

//         允许用前端Request用Header
        response.setHeader("Access-Control-Request-Headers", "Authorization,Origin, X-Requested-With,content-Type,Accept");
        response.setHeader("Access-Control-Allow-Headers", "token");

        response.setHeader("Access-Control-Expose-Headers", "*");

        response.setHeader("Access-Control-Allow-Origin", "*");
        //所有请求方式：|GET|POST|PUT ......
        response.setHeader("Access-Control-Allow-Methods", "*");


        System.out.println("拦截工作中");

        chain.doFilter(request, response);
    }
}
