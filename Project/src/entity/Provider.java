package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;


public class Provider {
	private Integer Pid;
	
	@NotEmpty(message="供应商编码不能为空")
	private String procode;
	@NotEmpty(message="供应商姓名不能为空")
	private String proname;
	private String procontact;
	private String prophone;
	private String proaddress;
	private String profax;
	private String prodesc;
	private Integer createBy;
	private Date createtionDate;
	private String modifyBy;
	private Date modifyDate;
	public Provider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Provider(Integer pid, String procode, String proname,
			String procontact, String prophone, String proaddress,
			String profax, String prodesc, Integer createBy,
			Date createtionDate, String modifyBy, Date modifyDate) {
		super();
		Pid = pid;
		this.procode = procode;
		this.proname = proname;
		this.procontact = procontact;
		this.prophone = prophone;
		this.proaddress = proaddress;
		this.profax = profax;
		this.prodesc = prodesc;
		this.createBy = createBy;
		this.createtionDate = createtionDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}
	public Integer getPid() {
		return Pid;
	}
	public void setPid(Integer pid) {
		Pid = pid;
	}
	public String getProcode() {
		return procode;
	}
	public void setProcode(String procode) {
		this.procode = procode;
	}
	public String getProname() {
		return proname;
	}
	public void setProname(String proname) {
		this.proname = proname;
	}
	public String getProcontact() {
		return procontact;
	}
	public void setProcontact(String procontact) {
		this.procontact = procontact;
	}
	public String getProphone() {
		return prophone;
	}
	public void setProphone(String prophone) {
		this.prophone = prophone;
	}
	public String getProaddress() {
		return proaddress;
	}
	public void setProaddress(String proaddress) {
		this.proaddress = proaddress;
	}
	public String getProfax() {
		return profax;
	}
	public void setProfax(String profax) {
		this.profax = profax;
	}
	public String getProdesc() {
		return prodesc;
	}
	public void setProdesc(String prodesc) {
		this.prodesc = prodesc;
	}
	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public String getCreatetionDate() {
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String dateString=format.format(createtionDate);
		return dateString;
	}
	public void setCreatetionDate(Date createtionDate) {
		this.createtionDate = createtionDate;
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
