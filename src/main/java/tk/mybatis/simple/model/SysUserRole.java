package tk.mybatis.simple.model;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/7 12:59
 * Description: 用户角色实体类
 */
public class SysUserRole {

    private Long userId;

    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
