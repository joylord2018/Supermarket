package service;


import java.util.List;
import util.PageUtil;
import entity.User;

public interface UserService {
	public PageUtil<User> checkAllByPage(int pageNo,int pageSize); //查看所有
	public User findByUserId(int userId); //按Id查询用户
	public int addUser(User user); //增加用户
	public int deleteUser(int userId); //删除用户
	public int updateUser(User user); //修改用户
	public User findByUserCodeAndPwd(String Code,String userPassword); //登陆
	public int getCount();//总条数
	public List<User> findByProperties(User user);
	public int updatePwdById(String password,int userId);
	public User findByUserCode(String userCode);
}
