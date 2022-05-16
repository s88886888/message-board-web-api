package mapper;
import model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {



    boolean AddUser(@Param("name") String name, @Param("phone") String phone, @Param("password") String password, @Param("email") String email);
    List<User> selectALL();

    User selectByphone(String phone);

    User SelectUsernamOrphone(@Param("name") String name, @Param("phone") String Password);

    boolean updateUser(@Param("id") int id, @Param("name") String name, @Param("password") String password, @Param("email") String email);

    User Login(@Param("phone")String Phone , @Param("password")String Password);


}
