package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.base.BaseMapperTest;
import tk.mybatis.simple.proxy.MyMapperProxy;
import tk.mybatis.simple.model.SysRole;
import tk.mybatis.simple.model.SysUser;

import java.lang.reflect.Proxy;
import java.util.Date;
import java.util.List;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/7 16:09
 * Description: 用户mapper测试类
 */
public class UserMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectById方法，查询用户id = 1的用户
            SysUser sysUser = userMapper.selectById(1l);
            //sysUser 不为空
            Assert.assertNotNull(sysUser);
            //userName = admin
            Assert.assertEquals("admin", sysUser.getUserName());
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectAll() {
        //获取Sqlssesion
        SqlSession sqlSession = getSqlSession();
        //获取UserMapper接口
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectAll方法查询所有用户
            List<SysUser> sysUserList = userMapper.selectAll();
            //结果不为空
            Assert.assertNotNull(sysUserList);
            //用户数量大于零
            Assert.assertTrue(sysUserList.size() > 0);
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectRolesByUserId方法查询用户的角色
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色数量大于0个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //获取UserMapper接口
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个SysUser对象
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("testInfo");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());
            //调用UserMapper中的insert方法添加用户
            int result = userMapper.insert(sysUser);
            //直插入一条数据
            Assert.assertEquals(1, result);
            //id为null，没有给id赋值，并且没有配置回写id的值
            Assert.assertNotNull(sysUser.getId());
        } finally {
            //为了不影响其他的测试，这里选择回滚
            //由于默认的SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        //获取UserMapper接口
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个SysUser对象
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test1");
            sysUser.setUserPassword("123456");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUser.setUserInfo("testInfo");
            sysUser.setHeadImg(new byte[]{1, 2, 3});
            sysUser.setCreateTime(new Date());
            //调用UserMapper中的insert方法添加用户
            int result = userMapper.insert2(sysUser);
            //直插入一条数据
            Assert.assertEquals(1, result);
            //id为null，没有给id赋值，并且没有配置回写id的值
            Assert.assertNotNull(sysUser.getId());
        } finally {
            //为了不影响其他的测试，这里选择回滚
            //由于默认的SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            //数据存在于Session中，随着程序的关闭而消失
            sqlSession.rollback();
            //提交到数据库
            sqlSession.commit();
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateById() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询一个user对象、
            SysUser sysUser = userMapper.selectById(1L);
            //当前userName为admin
            Assert.assertEquals("admin", sysUser.getUserName());
            //修改用户名
            sysUser.setUserName("admin_test");
            //修改邮箱
            sysUser.setUserEmail("test@mybatis.tk");
            //更新数据，特别注意，这里的返回值result是执行的SQL影响的行数
            int result = userMapper.updateById(sysUser);
            //只更新一条数据
            Assert.assertEquals(1, result);
            //根据当前id查询修改后的数据
            sysUser = userMapper.selectById(1L);
            //修改后的名字是admin_test
            Assert.assertEquals("admin_test", sysUser.getUserName());

        } finally {
            //为了不影响其他测试这里选择回滚
            //因为SqlSessionFactory.openSession()是不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteById(){
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //从数据库查询一个sysUser对象了，根据id=1查询
            SysUser sysUser1 = userMapper.selectById(1L);
            //现在还能查询出sysUser对象
            Assert.assertNotNull(sysUser1);
            //调用方法删除
            Assert.assertEquals(1, userMapper.deleteById(1L));
            //再次查询时，此时的值应该为null
            Assert.assertNull(userMapper.selectById(1L));
        } finally {
            //为了不影响其他测试，这里选择回滚
            //由于默认的SqlSessionFactory.openSqlSession是不自动提交的
            //因此不手动commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserIdAndRoleEnabled(){
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectRolesByUserIdAndRoleEnable方法查询用户的角色
            List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L, 1);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色大于0个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testMyMapperProxy() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            MyMapperProxy userMapperProxy = new MyMapperProxy(UserMapper.class, sqlSession);
            UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(
                    Thread.currentThread().getContextClassLoader(), new Class[]{UserMapper.class},
                    userMapperProxy);
            //调用selectAll方法
            List<SysUser> userList = userMapper.selectAll();
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectByUser() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用selectByUser方法只查询用户名时
            SysUser sysUser = new SysUser();
            sysUser.setUserName("ad");
            List<SysUser> sysUserList = userMapper.selectByUser(sysUser);
            Assert.assertTrue(sysUserList.size() > 0);

            //调用selectByUser方法只查询邮箱时
            sysUser = new SysUser();
            sysUser.setUserEmail("test@mybatis.tk");
            sysUserList = userMapper.selectByUser(sysUser);
            Assert.assertTrue(sysUserList.size() > 0);

            //调用selectByUser方法查询用户名和邮箱时
            sysUser = new SysUser();
            sysUser.setUserName("ad");
            sysUser.setUserEmail("test@mybatis.tk");
            sysUserList = userMapper.selectByUser(sysUser);
            //由于没有符合这个要求的，所以查询结果数为0
            Assert.assertEquals(0, sysUserList.size());
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateByIdSelective() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个新的SysUser对象
            SysUser sysUser = new SysUser();
            //更新id = 1的用户
            sysUser.setId(1L);
            //修改邮箱
            sysUser.setUserEmail("test@mybatis.tk");
            //更新邮箱，result返回的时操作数据库的行数
            int result = userMapper.updateByIdSelective(sysUser);
            //只更新一条数据
            Assert.assertEquals(1, result);
            //根据当前id查询修改后的数据
            sysUser = userMapper.selectById(1L);
            //修改后的用户名保持不变，但是邮箱变成了新的
            Assert.assertEquals("admin", sysUser.getUserName());
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
        }finally {
            //为了不影响之后的测试这选择回滚
            //因为SqlSessionFactory.openSqlSession()方法是不自动提交的
            //因此不手动执行commit是不会提交到数据库的
            sqlSession.rollback();
            //最后不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2Selective() {
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取UserMapper接口
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个SysUser对象
            SysUser sysUser = new SysUser();
            sysUser.setUserName("test-selective");
            sysUser.setUserPassword("123456");
            sysUser.setUserInfo("test info");
            sysUser.setCreateTime(new Date());
            //插入数据库
            userMapper.insert2Selective(sysUser);
            //获取插入的这条数据
            sysUser = userMapper.selectById(sysUser.getId());
            //因为邮箱没有修改所以邮箱的值没有改变
            Assert.assertEquals("test@mybatis.tk", sysUser.getUserEmail());
        } finally {
            //为了不影响以后的测试，这里选择回滚
            //因为SqlSessionFactory.openSqlSession()方法不自动提交的
            //因此不手动执行commit也不会提交到数据库
            sqlSession.rollback();
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }
}
