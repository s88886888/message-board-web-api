package dao;

import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDao {


    public static void main(String[] args) throws IOException {

//
//        System.out.println("增加");
//        Addbrand("Linson","17677275020","123456","854700937@qq.com");

//        System.out.println("查询所有");
//        List alldemo = selectAll();
//        System.out.print(alldemo);

//        System.out.println("查询一个");
//        User user = selectbyId(1);
//        System.out.print(user);

//        System.out.println("模糊查询");
//        List<User>  demolist= Seelct ("","17677275020");
//        System.out.print(demolist);


//        System.out.println("删除");
//        delect(4);

//        System.out.println("修改");
//        UpdateinformationBrand(13,"老坛酸菜", "统一集团食品", 1, "315曝光", 1);

    }

    public static List<User> selectAll() throws IOException {

        SqlSession sqlSession = getSqlSession();
        UserMapper brandMapper = sqlSession.getMapper(UserMapper.class);
        List<User> brand = brandMapper.selectALL();
        sqlSession.close();
        return brand;
    }

//    public boolean delect(int id) throws IOException {
//        SqlSession sqlSession = getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        String a = selectByphone(id);
//        if (a == null) {
//            System.out.println("没有这条记录");
//            return false;
//        } else {
//            User returnData = userMapper.selectByid(id);
//            //向数据库提交数据
//            sqlSession.commit();
//            sqlSession.close();
//            return true;
//        }
//    }

    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务 开关
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession;
    }

    public boolean UpdateBrand(int id, String name, String email, String password) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper brandMapper = sqlSession.getMapper(UserMapper.class);
        boolean returnData = brandMapper.updateUser(id, name, email, password);
        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        return returnData;
    }

    public boolean AddbUser(String name, String phone, String password, String email) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean returnData = userMapper.AddUser(name, phone, password, email);
        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        System.out.println(returnData + "又注册一个");
        return returnData;
    }

    public List<User> selectLikeData(String name, String phone) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = (List<User>) userMapper.SelectUsernamOrphone(name, phone);
        sqlSession.close();
        return user;
    }

    public User selectByphone(String phone) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByphone(phone);
        sqlSession.close();
        return user;
    }

    public User Login(String phone, String password) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.Login(phone, password);
        sqlSession.close();
        return user;
    }


    public boolean deletebyid(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        boolean user = userMapper.deletebyid(id);
        sqlSession.commit();
        sqlSession.close();
        return user;
    }



    public User selectbyid(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByid(id);
        sqlSession.close();
        return user;
    }

    public User selectbyname(String name) throws IOException {
        SqlSession sqlSession = getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.selectByname(name);
        sqlSession.close();
        return user;
    }



}
