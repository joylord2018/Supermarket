package dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import entity.Bill;

public interface BillDao {
	public List<Bill> checkAllByPage(@Param("index")int pageNo,@Param("pageSize")int pageSize); //查看所有
	public Bill findByBId(int Bid); //按Id查询
	public int addBill(Bill bill); //增加
	public int deleteBill(int Bid); //删除
	public int updateBill(Bill bill); //修改
	public List<Bill> findByProperties(@Param("bill")Bill bill);
	public int getCount();
	public List<Bill> checkProName();//查供应商名
}
