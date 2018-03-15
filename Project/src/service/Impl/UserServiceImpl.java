package service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dao.UserDao;
import entity.User;
import service.UserService;
import util.PageUtil;

@Service("UserService")
public class UserServiceImpl implements UserService{
@Autowired
	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return ud.findByUserId(userId);
	}

	public int addUser(User user) {
		// TODO Auto-generated method stub
		User u=ud.findByUserCode(user.getUserCode());
		if(u!=null){
			return -1;	
		}	
		return ud.addUser(user);
	}

	public int deleteUser(int userId) {
		// TODO Auto-generated method stub
		return ud.deleteUser(userId);
	}

	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return ud.updateUser(user);
	}

	public User findByUserCodeAndPwd(String userCode, String userPassword) {
		// TODO Auto-generated method stub
		return ud.findByUserCodeAndPwd(userCode, userPassword);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return ud.getCount();
	}

	public List<User> findByProperties(User user) {
		// TODO Auto-generated method stub
		return ud.findByProperties(user);
	}

	public int updatePwdById(String password, int userId) {
		// TODO Auto-generated method stub
		return ud.updatePwdById(password, userId);
	}

	public PageUtil<User> checkAllByPage(int pageNo, int pageSize) {
		PageUtil<User> pu=new PageUtil<User>();
		List<User> userLi=new ArrayList<User>();
		pu.setPageNo(pageNo);
		pu.setPageSize(pageSize);
		userLi=ud.checkAllByPage((pageNo-1)*pageSize, pageSize);
		pu.setList(userLi);
		pu.setMaxCount(ud.getCount());
		return pu;
	}

	public User findByUserCode(String userCode) {
		// TODO Auto-generated method stub
		return ud.findByUserCode(userCode);
	}
}