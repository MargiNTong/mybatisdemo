package com.tong.demo.mapper;

import com.tong.demo.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMappers {
    @Select("select *from users")
    List<User> getUsers();

    @Insert("insert into users values(null,#{username},#{userpass},#{nickname},null,#{gender},null,null,null,null,null,null,null)")
    void addUser(User user);
}
