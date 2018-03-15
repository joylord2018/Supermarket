package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import entity.Provider;


public interface ProviderDao {
	public List<Provider> checkAllByPage(@Param("index")int pageNo,@Param("pageSize")int pageSize); //分页查看所有
	public Provider findByPid(int Pid); //按Id查询
	public int addProvider(Provider prov); //增加
	public int deleteProvider(int Pid); //删除
	public int updateProvider(Provider prov); //修改
	public List<Provider> findByProperties(@Param("provider")Provider prov);
	public int getCount(); //总条数
	public Provider findByProCode(String proCode);
}
