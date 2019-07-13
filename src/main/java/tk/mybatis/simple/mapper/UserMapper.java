package tk.mybatis.simple.mapper;

import org.apache.ibatis.annotations.Param;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.util.List;

/**
 * Java Interface
 * Created By Secondary
 * On 2019/7/7 14:46
 * Description: 用户接口
 */
public interface UserMapper {

    /**
     * 通过id查询用户
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户信息获取角色信息
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);

    /**
     * 新增用户
     * @param sysUser
     * @return
     */
    int insert3(SysUser sysUser);

    /**
     * 根据主键更新
     * @param sysUser
     * @return
     */
    int updateById(SysUser sysUser);

    /**
     * 通过主键删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据用户的id和角色的enable状态获取用户的角色
     * @param userId
     * @param enabled
     * @return
     */
    List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId") Long userId,
                                                    @Param("enabled") Integer enabled);
}
