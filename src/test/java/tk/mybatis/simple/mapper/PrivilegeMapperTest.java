package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import tk.mybatis.simple.mapper.base.BaseMapperTest;
import tk.mybatis.simple.model.SysPrivilege;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/17 22:08
 * Description: 权限测试接口
 */
public class PrivilegeMapperTest extends BaseMapperTest {

    @Test
    public void testSelectById(){
        //获取SqlSession
        SqlSession sqlSession = getSqlSession();
        try {
            //获取PrivilegeMapper接口
            PrivilegeMapper privilegeMapper = sqlSession.getMapper(PrivilegeMapper.class);
            //调用selectById
            SysPrivilege sysPrivilege = privilegeMapper.selectById(1L);
            //结果不为空
            Assert.assertNotNull(sysPrivilege);
            //privilegeName = 用户管理
            Assert.assertEquals("用户管理", sysPrivilege.getPrivilegeName());
        } finally {
            //不要忘记关闭SqlSession
            sqlSession.close();
        }
    }

}
