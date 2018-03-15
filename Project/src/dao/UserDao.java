package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import entity.User;

public interface UserDao {
	public List<User> checkAllByPage(@Param("index")int pageNo,@Param("pageSize")int pageSize); //分页查看所有
	public User findByUserId(int userId); //按Id查询用户
	public int addUser(User user); //增加用户
	public int deleteUser(int userId); //删除用户
	public int updateUser(User user); //修改用户
	public User findByUserCodeAndPwd(@Param("userCode")String userCode,@Param("userPassword")String userPassword); //登陆
	public int getCount(); //总条数
	public List<User> findByProperties(@Param("user")User user);
	public int updatePwdById(@Param("userPassword")String password,@Param("userId")int userId);
	public User findByUserCode(String userCode);
}
