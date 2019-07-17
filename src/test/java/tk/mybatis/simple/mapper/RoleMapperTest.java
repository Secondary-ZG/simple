package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.base.BaseMapperTest;
import tk.mybatis.simple.model.SysRole;

import java.util.Date;
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

    @Test
    public void testInsert() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //创建一个新的SysRole
            SysRole sysRole = new SysRole();
            sysRole.setId(3L);
            sysRole.setRoleName("test_role");
            sysRole.setCreateBy(1L);
            sysRole.setEnabled(1);
            sysRole.setCreateTime(new Date());
            //调用insert方法
            int result = roleMapper.insert(sysRole);
            //只插入一条数据
            Assert.assertEquals(1, result);
            //id为null，没有给id赋值，并且没有配置回写id的值
            Assert.assertNotNull(sysRole.getId());
        } finally {
            //为了不影响其他的测试，这里选择回滚
            //由于SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //创建一个新的SysRole
            SysRole sysRole = new SysRole();
            sysRole.setId(3L);
            sysRole.setRoleName("test_role");
            sysRole.setCreateBy(1L);
            sysRole.setEnabled(1);
            sysRole.setCreateTime(new Date());
            //调用insert方法
            int result = roleMapper.insert2(sysRole);
            //只插入一条数据
            Assert.assertEquals(1, result);
            //id不为null，给id赋值，并且配置回写id的值
            Assert.assertNotNull(sysRole.getId());
        } finally {
            //为了不影响其他的测试，这里选择回滚
            //由于SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert3() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取RoleMapper接口
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            //创建一个新的SysRole
            SysRole sysRole = new SysRole();
            sysRole.setId(3L);
            sysRole.setRoleName("test_role");
            sysRole.setCreateBy(1L);
            sysRole.setEnabled(1);
            sysRole.setCreateTime(new Date());
            //调用insert方法
            int result = roleMapper.insert3(sysRole);
            //只插入一条数据
            Assert.assertEquals(1, result);
        } finally {
            //为了不影响其他的测试，这里选择回滚
            //由于SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

}
