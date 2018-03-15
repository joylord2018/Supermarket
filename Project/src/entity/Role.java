package entity;

import java.io.Serializable;
import java.sql.Date;

public class Role implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6258859664094122824L;
	private int  rid;
	private String roleCode;	
	private String roleName;
	private String createBy;
	private Date creationDate;
	private String modifyBy;
	private Date modifyDate;
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(int rid, String roleCode, String roleName,
			String createBy, Date creationDate, String modifyBy, Date modifyDate) {
		super();
		this.rid = rid;
		this.roleCode = roleCode;
		this.roleName = roleName;
		this.createBy = createBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	public String getRoleCode() {
		return roleCode;
	}
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
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
}
