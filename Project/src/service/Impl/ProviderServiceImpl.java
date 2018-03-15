package service.Impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.ProviderService;
import util.PageUtil;
import dao.ProviderDao;
import entity.Provider;

@Service("ProviderService")
public class ProviderServiceImpl implements ProviderService{
@Autowired
	private ProviderDao pd;

	public ProviderDao getPd() {
		return pd;
	}

	public void setPd(ProviderDao pd) {
		this.pd = pd;
	}

	public Provider findByPid(int Pid) {
		// TODO Auto-generated method stub
		return pd.findByPid(Pid);
	}

	public int addProvider(Provider prov) {
		// TODO Auto-generated method stub
		Provider p=pd.findByProCode(prov.getProcode());
		if(p!=null){
			return -1;	
		}	
		return pd.addProvider(prov);
	}

	public int deleteProvider(int Pid) {
		// TODO Auto-generated method stub
		return pd.deleteProvider(Pid);
	}

	public int updateProvider(Provider prov) {
		// TODO Auto-generated method stub
		return pd.updateProvider(prov);
	}

	public List<Provider> findByProperties(Provider prov) {
		// TODO Auto-generated method stub
		return pd.findByProperties(prov);
	}

	public int getCount() {
		// TODO Auto-generated method stub
		return pd.getCount();
	}

	public PageUtil<Provider> checkAllByPage(int pageNo, int pageSize) {
		PageUtil<Provider> pu=new PageUtil<Provider>();
		List<Provider> userLi=new ArrayList<Provider>();
		pu.setPageNo(pageNo);
		pu.setPageSize(pageSize);
		userLi=pd.checkAllByPage((pageNo-1)*pageSize, pageSize);
		pu.setList(userLi);
		pu.setMaxCount(pd.getCount());
		return pu;
	}

	public Provider findByProCode(String proCode) {
		// TODO Auto-generated method stub
		return pd.findByProCode(proCode);
	}

}
