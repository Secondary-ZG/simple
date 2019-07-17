package tk.mybatis.simple.provider;

import org.apache.ibatis.jdbc.SQL;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/17 21:59
 * Description:权限Provider
 */
public class PrivilegeProvider {

    public String selectById(final Long id) {
        return new SQL() {
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();

        //也可以直接返回SQL
        //return "select id, privilege_name, privilege_url from sys_privilege where id = #{id}";
    }

}
