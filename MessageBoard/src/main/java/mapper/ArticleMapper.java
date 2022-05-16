package mapper;


import model.Article;
import org.apache.ibatis.annotations.Param;

import java.sql.Blob;
import java.util.Date;
import java.util.List;

public interface ArticleMapper {



 boolean AddArticle(@Param("articlename") String articlename,
                    @Param("time") Date time,
                    @Param("author") String author,
                    @Param("authorid") int authorid,
                    @Param("text") String text,
                    @Param("Image") String Image,
                    @Param("likecount") int likecount);



    List<Article> selectALL();

    Article selectByid(int id);



   List<Article> Selectarticlebyauthor(String author);

    Article SelectarticlenameOrauthor(@Param("articlename") String articlename, @Param("author") String author);

    boolean updateArticle(@Param("id") int id, @Param("articlename") String articlename,  @Param("text") String text, @Param("Image") String Image);

    boolean delectByid(@Param("id") int id);


}
