package Pooltool;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "CORSFilter", urlPatterns = "/*")
public class CORSFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

//        response.setContentType("text/html;charset=utf-8");
//        resp.setContentType("application/json; charset=utf-8");
//        resp.setCharacterEncoding("UTF-8");

//        告诉浏览器, 可以从某个位置跨域来访问
//        String[] allowDomain = {"http://127.0.0.1:8999","http://localhost:8999"};
//        String originHeader = request.getHeader("Origin");
//        Set<String> allowedOrigins = new HashSet<>(Arrays.asList(allowDomain));
//        if (allowedOrigins.contains(originHeader)) {
//            response.setHeader("Access-Control-Allow-Origin", originHeader);
//        }


//        告诉浏览器, 可以从某个位置跨域来访问
//        response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5501");
//        //指定允许其他域名访问
//        'Access-Control-Allow-Origin:http://127.0.0.0'//一般用法（*，指定域，动态设置），3是因为*不允许携带认证头和cookies
//        是否允许后续请求携带认证信息（cookies）,该值只能是true,否则不返回
//        'Access-Control-Allow-Credentials:true'
//         预检结果缓存时间,也就是上面说到的缓存啦
//        'Access-Control-Max-Age: 1800'
//         允许的请求类型
//        'Access-Control-Allow-Methods:GET,POST,PUT,POST'
//         允许的请求头字段 不能写*
//        'Access-Control-Allow-Headers:x-requested-with,content-type'


        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");


        response.setHeader("Access-Control-Allow-Origin", "*");
        //所有请求方式：|GET|POST|HEAD ......一般只能写三个
        response.setHeader("Access-Control-Allow-Methods", "*");

        response.setHeader("Access-Control-Request-Headers", "*");


        //服务器向客户端暴露的header字段，用于客户端获取response的头部信息，多个用逗号分隔。CORS请求时，XMLHttpRequest对象的getResponseHeader()方法只能拿到6个基本字段：Cache-Control、Content-Language、Content-Type、Expires、Last-Modified、Pragma。如果想拿到其他字段，就必须在Access-Control-Expose-Headers里面指定。
        response.setHeader("Access-Control-Expose-Headers", "*");


        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type,token");
        response.setHeader("Access-Control-Expose-Headers", "token");
        System.out.println("拦截工作中");

        chain.doFilter(request, response);
    }
}
