package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.simple.model.SysRole;

import java.util.List;

/**
 * Java Interface
 * Created By Secondary
 * On 2019/7/7 14:47
 * Description:角色接口
 */
public interface RoleMapper {

    @Select({"select " +
                "id, role_name AS roleName, " +
                "enabled, create_by AS createBy, " +
                "create_time AS createTime " +
             "from " +
                "sys_role " +
             "where id = #{id}"})
    SysRole selectById(Long id);

    @Results(id = "roleResultMap", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "roleName", column = "role_name"),
            @Result(property = "enabled", column = "enabled"),
            @Result(property = "createBy", column = "create_by"),
            @Result(property = "createTime", column = "create_time")
    })
    @Select("select id, role_name, enabled, create_by, create_time from sys_role where id = #{id}")
    SysRole selectById2(Long id);

    //使用@ResultMap
    @ResultMap("roleResultMap")
    @Select("select * from sys_role")
    List<SysRole> selectAll();
}
