package service;

import java.util.List;
import util.PageUtil;
import entity.Bill;

public interface BillService {
	public PageUtil<Bill> checkAllByPage(int pageNo,int pageSize);; //查看所有
	public Bill findByBId(int Bid); //按Id查询
	public int addBill(Bill bill); //增加
	public int deleteBill(int Bid); //删除
	public int updateBill(Bill bill); //修改
	public List<Bill> findByProperties(Bill bill);
	public List<Bill> checkProName();
}
