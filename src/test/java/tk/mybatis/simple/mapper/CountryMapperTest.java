package tk.mybatis.simple.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import tk.mybatis.simple.mapper.base.BaseMapperTest;
import tk.mybatis.simple.model.Country;

import java.util.List;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/3 22:00
 * Description:MyBatis测试类
 */
public class CountryMapperTest extends BaseMapperTest {



    @Test
    public void testSelectALL() {
        //使用时通过SqlSessionFactory工厂对象获取一个SqlSession。
        SqlSession sqlSession = getSqlSession();
        try {
            //通过SqlSession的selectList方法找到CountryMapper.xml中的id="selectAll"的方法，执行SQL查询
            //MyBatis底层使用JDBC执行SQL，获取查询结果集ResultSet后，根据resultType的配置将结果映射为Country
            //类型的集合，返回查询结果。这样就得到了最后的查询结果countryList，简单见结果输出到控制台。
            //最后一定要记得关闭SqlSession，否则会因为连接没有关闭导致数据库连接数过多导致系统崩溃.
            List<Country> countryList = sqlSession.selectList("tk.mybatis.simple.mapper" +
                    ".CountryMapper.selectAll");
            printCountryList(countryList);
        } finally {
            //不要忘记关闭sqlSession
            sqlSession.close();
        }
    }

    private void printCountryList(List<Country> countryList) {
        for (Country country : countryList) {
            System.out.printf("%-4d%4s%4s\n",
                    country.getId(), country.getCountryname(), country.getCountrycode());
        }
    }

}
