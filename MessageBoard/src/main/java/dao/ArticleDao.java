package dao;

import mapper.ArticleMapper;
import model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class ArticleDao {
    public static List<Article> selectAll() throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> Article = articleMapper.selectALL();
        sqlSession.close();
        return Article;
    }

    private static SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //自动提交事务 开关
        SqlSession sqlSession = sqlSessionFactory.openSession(false);
        return sqlSession;
    }

    public boolean UpdateArticle(int id, String name, String text, String image) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper ArticleMapper = sqlSession.getMapper(ArticleMapper.class);
        boolean returnData = ArticleMapper.updateArticle(id, name, text, image);
        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        return returnData;
    }

    public boolean delect(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper ArticleMapper = sqlSession.getMapper(ArticleMapper.class);

        Article article = selectByid(id);

        if (article == null) {
            System.out.println("没有这条记录");
            return false;
        } else {

            ArticleMapper articleMapper = sqlSession.getMapper(ArticleMapper.class);
            articleMapper.delectByid(id);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
    }

    public boolean AddArticle(String articlename, Date time, String author, int authorid, String text, String Image, int likecount) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper artcleMapper = sqlSession.getMapper(ArticleMapper.class);
        boolean returnData = artcleMapper.AddArticle(articlename, time, author, authorid, text, Image, likecount);

        //向数据库提交数据
        sqlSession.commit();
        sqlSession.close();
        System.out.println(returnData + "又注册一个");
        return returnData;
    }

    public List<Article> selectLikeData(String articlename) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper ArticleMapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> Article = (List<model.Article>) ArticleMapper.selectarticlename(articlename);
        sqlSession.close();
        return Article;
    }

    public Article selectByid(int id) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper ArticleMapper = sqlSession.getMapper(ArticleMapper.class);
        Article Article = ArticleMapper.selectByid(id);
        sqlSession.close();
        return Article;
    }

    public List<Article> selectByauthor(String author) throws IOException {
        SqlSession sqlSession = getSqlSession();
        ArticleMapper ArticleMapper = sqlSession.getMapper(ArticleMapper.class);
        List<Article> Article = ArticleMapper.Selectarticlebyauthor(author);
        sqlSession.close();
        return Article;
    }


}
