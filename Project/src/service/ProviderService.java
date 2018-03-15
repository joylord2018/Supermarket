package service;

import java.util.List;
import util.PageUtil;
import entity.Provider;

public interface ProviderService {
	public PageUtil<Provider> checkAllByPage(int pageNo,int pageSize); //分页查看所有
	public Provider findByPid(int Pid); //按Id查询
	public int addProvider(Provider prov); //增加
	public int deleteProvider(int Pid); //删除
	public int updateProvider(Provider prov); //修改
	public List<Provider> findByProperties(Provider prov);
	public int getCount(); //总条数
	public Provider findByProCode(String proCode);
}
