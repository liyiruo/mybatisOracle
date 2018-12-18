package dao;

import org.apache.ibatis.session.SqlSession;
import servlet.SessionBean;
import servlet.MyUser;

import java.util.List;

public class MyUserDao {
    private static SqlSession session;//设置成静态就不用每次就new了

    static {
        session = SessionBean.getSession();
    }

    public static MyUser findUserById(int id)//通过id来查找User
    {
        return session.selectOne("test.findUserById", 1);
    }

    public static List<MyUser> findUserByName(String n)//通过name来查找所有User
    {
        return session.selectList("test.findUserByName", n);
    }

    public static void insertUser(MyUser user)//插入一个User
    {
        session.insert("test.insertUser", user);
    }

    public static void deleteUser(int i)//删除id为i的User
    {
        session.delete("test.deleteUser", i);
    }

    public static void updateUser(MyUser user)//根据id更新User信息
    {
        session.update("test.updateUser", user);
        session.commit();//注意必须要commit
    }
}
