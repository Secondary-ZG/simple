package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.simple.model.SysPrivilege;
import tk.mybatis.simple.provider.PrivilegeProvider;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/7 14:48
 * Description: 权限接口
 */
public interface PrivilegeMapper {

    /**
     * Provider的注解中提供了两个必填的属性type和method.type配置的是包含method属性指定方法的类，
     * 这个类必须有空的构造方法，这个方法的值就是要执行的SQL语句，并且method属性指定的方法的返回值必
     * 须是String类型.
     * @param id
     * @return
     */
    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);

}
