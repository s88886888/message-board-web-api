package mapper;

import model.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface AdminMapper {

    List<Admin> selectALL();

    Admin selectByid(int id);

    boolean addAdmin(@Param("name") String name, @Param("password") String password, @Param("time") Date time);

    boolean updateAdmin(@Param("id") int id, @Param("name") String name, @Param("password") String password);

    Admin Login(@Param("name") String name, @Param("password") String Password);

    boolean deletebyid(int id);

    Admin selectbyname(String name);

}
