package tk.mybatis.simple.proxy;

import org.apache.ibatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Java Class
 * Created By Secondary
 * On 2019/7/15 21:56
 * Description: 代理类
 */
//TODO 有待从0到1学习Java动态代理
public class MyMapperProxy<T> implements InvocationHandler {
    private Class<T> mapperInterface;
    private SqlSession sqlSession;

    public MyMapperProxy(Class<T> mapperInterface, SqlSession sqlSession) {
        this.mapperInterface = mapperInterface;
        this.sqlSession = sqlSession;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //针对不同的Sql类型，需要调用不用的SqlSession方法
        //接口方法中的参数也有很多情况，这里只考虑没有参数的情况
        List<T> list = sqlSession
                .selectList(mapperInterface.getCanonicalName() + "." + method.getName());
        //返回值也有很多情况，这里不做处理直接返回
        return list;
    }

}
