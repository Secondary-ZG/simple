package tk.mybatis.simple.model;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/7 13:03
 * Description: 权限实体类
 */
public class SysPrivilege {

    private Long id;

    private String privilegeName;

    private String privilegeUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrivilegeName() {
        return privilegeName;
    }

    public void setPrivilegeName(String privilegeName) {
        this.privilegeName = privilegeName;
    }

    public String getPrivilegeUrl() {
        return privilegeUrl;
    }

    public void setPrivilegeUrl(String privilegeUrl) {
        this.privilegeUrl = privilegeUrl;
    }
}
