package service.Impl;


import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.BillService;
import util.PageUtil;
import dao.BillDao;
import entity.Bill;

@Service("BillService")
public class BillServiceImpl implements BillService{
@Autowired
	private BillDao bd;
	public BillDao getBd() {
	return bd;
	}

	public void setBd(BillDao bd) {
	this.bd = bd;
	}

	public PageUtil<Bill> checkAllByPage(int pageNo,int pageSize){
		// TODO Auto-generated method stub
		PageUtil<Bill>pubi =new PageUtil<Bill>();
		List<Bill> bili=new ArrayList<Bill>();
		pubi.setPageNo(pageNo);
		pubi.setPageSize(pageSize);
		bili=bd.checkAllByPage((pageNo-1)*pageSize, pageSize);
		pubi.setList(bili);
		pubi.setMaxCount(bd.getCount());
		return pubi;
	}

	public Bill findByBId(int Bid) {
		// TODO Auto-generated method stub
		return bd.findByBId(Bid);
	}

	public int addBill(Bill bill) {
		// TODO Auto-generated method stub
		return bd.addBill(bill);
	}

	public int deleteBill(int Bid) {
		// TODO Auto-generated method stub
		return bd.deleteBill(Bid);
	}

	public int updateBill(Bill bill) {
		// TODO Auto-generated method stub
		return bd.updateBill(bill);
	}

	public List<Bill> findByProperties(Bill bill) {
		// TODO Auto-generated method stub
		return bd.findByProperties(bill);
	}

	public List<Bill> checkProName() {
		// TODO Auto-generated method stub
		return bd.checkProName();
	}	
}
