package entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3168359580547962917L;
	private Integer userId;
	@NotEmpty(message="账号不能为空")
	private String userCode;
	@NotEmpty(message="用户名不能为空")
	private String userName;
	@NotEmpty(message="密码不能为空")
	private String userPassword;
	private String sex;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	/*@JSONField(format="yyyy-MM-dd")*/
	private Date birthday;
	private int userRole;
	private String address;
	private String phone;
	private String idPic;
	private Integer createBy;
	private Date creationDate;
	private String modifyBy;
	private Date modifyDate;
	private int age;
	
	
	public User(Integer userId, String userCode, String userName,
			String userPassword, String sex, Date birthday, String address,
			String phone, String idPic, Integer createBy, Date creationDate,
			String modifyBy, Date modifyDate, String roleName) {
		super();
		this.userId = userId;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
		this.birthday = birthday;
		this.address = address;
		this.phone = phone;
		this.idPic = idPic;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
		this.roleName = roleName;
	}

	public int getAge() {
		SimpleDateFormat year=new SimpleDateFormat("yyyy");
		SimpleDateFormat mon=new SimpleDateFormat("MM");
		java.util.Date now=new java.util.Date();
		String bir_year=year.format(birthday);
		String bir_mon=mon.format(birthday);
		String this_year=year.format(now);
		String this_mon=mon.format(now);
		age=Integer.parseInt(this_year)-Integer.parseInt(bir_year);
		if(this_mon.compareTo(bir_mon)<0){
			age-=1;
		}
		if(age<0){
			age=0;
		}
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	private String roleName;
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public String getIdPic() {
		return idPic;
	}

	public void setIdPic(String idPic) {
		this.idPic = idPic;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public int getUserRole() {
		return userRole;
	}

	public void setUserRole(int userRole) {
		this.userRole = userRole;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getModifyBy() {
		return modifyBy;
	}

	public void setModifyBy(String modifyBy) {
		this.modifyBy = modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
