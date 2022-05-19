package dao;

import mapper.AdminMapper;
import mapper.AdminMapper;
import model.Admin;
import model.Admin;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class AdminDao {

    
    public static List<Admin> selectAll() throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper AdminMapper = sqlSession.getMapper(AdminMapper.class);
        List<Admin> Admin = AdminMapper.selectALL();
        sqlSession.close();
        return Admin;
    }
    

    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务 开关
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession;
    }
    
    

    public boolean UpdateAdmin(int id, String name, String password) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper AdminMapper = sqlSession.getMapper(AdminMapper.class);
        boolean returnData = AdminMapper.updateAdmin(id, name, password);
        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        return returnData;
    }
    

    public boolean deletebyid(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper AdminMapper = sqlSession.getMapper(AdminMapper.class);

        Admin Admin = selectByid(id);

        if (Admin == null) {
            System.out.println("没有这条记录");
            return false;
        } else {
            
            AdminMapper.deletebyid(id);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
    }

    public boolean AddAdmin(String name, String password,Date time) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper artcleMapper = sqlSession.getMapper(AdminMapper.class);
        boolean returnData = artcleMapper.addAdmin(name, password,time);
        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        System.out.println(returnData + "又注册一个");
        return returnData;
    }


    public Admin selectByid(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper AdminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin Admin = AdminMapper.selectByid(id);
        sqlSession.close();
        return Admin;
    }


    public Admin Login(String name, String password) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin Admin = adminMapper.Login(name, password);
        sqlSession.close();
        return Admin;
    }

    public Admin Selectbyname(String name) throws IOException {
        SqlSession sqlSession = getSqlSession();
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        Admin Admin = adminMapper.selectbyname(name);
        sqlSession.close();
        return Admin;
    }


}