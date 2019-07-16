package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.base.BaseMapperTest;
import tk.mybatis.simple.model.SysRole;

import java.util.List;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/16 21:39
 * Description: 角色Mapper测试类
 */
public class RoleMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //调用selectById方法，查询id=1的角色
            SysRole sysRole = roleMapper.selectById(1L);
            //role不为空
            Assert.assertNotNull(sysRole);
            //roleName=管理员
            Assert.assertEquals("管理员", sysRole.getRoleName());
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectById2(){
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //调用selectById方法，查询id=1的角色
            SysRole sysRole = roleMapper.selectById2(1L);
            //role不为空
            Assert.assertNotNull(sysRole);
            //roleName=管理员
            Assert.assertEquals("管理员", sysRole.getRoleName());
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectALL() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //调用roleMapper中selectAll方法
            List<SysRole> roleList = roleMapper.selectAll();
            //roleList结果不为空
            Assert.assertNotNull(roleList);
            //roleList数量大于0
            Assert.assertTrue(roleList.size() > 0);
            //验证下划线字段是否验证成功
            Assert.assertNotNull(roleList.get(0).getRoleName());
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

}
