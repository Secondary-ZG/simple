package tk.mybatis.simple.model;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/7 13:05
 * Description:角色权限实体类
 */
public class SysRolePrivilege {

    private Long role_id;

    private Long privilegeId;

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPrivilegeId() {
        return privilegeId;
    }

    public void setPrivilegeId(Long privilegeId) {
        this.privilegeId = privilegeId;
    }
}
