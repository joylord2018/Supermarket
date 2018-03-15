package util;

import java.util.List;

public class PageUtil<T> {
	private int pageNo;// 当前页，默认为1
	private int pageSize;// 每页数据量
	private int maxCount;// 数据总条数
	private int maxPage;// 最大页数
	private int ago;// 上一页
	private int after;// 下一页
	private List<T> list;// 封装数据的list集合T为泛型

	/**
	 * 得到当前页
	 * 
	 * @return
	 */

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * 每页数据条数
	 * 
	 * @return
	 */
	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 数据总条数
	 * 
	 * @return
	 */
	public int getMaxCount() {
		return maxCount;
	}

	public void setMaxCount(int maxCount) {
		this.maxCount = maxCount;
	}

	/**
	 * 最大页数
	 * 
	 * @return
	 */
	public int getMaxPage() {
	
		return maxCount % pageSize > 0 ? (maxCount / pageSize) + 1 : maxCount
				/ pageSize < 1 ? 1 : maxCount / pageSize;
	}

	public void setMaxPage(int maxPage) {
		this.maxPage = maxPage;
	}

	/**
	 * 上一页
	 * 
	 * @return
	 */
	public int getAgo() {
		return pageNo - 1 < 1 ? 1 : pageNo - 1;
	}

	public void setAgo(int ago) {
		this.ago = ago;
	}

	/**
	 * 下一页
	 * 
	 * @return
	 */
	public int getAfter() {
		return pageNo + 1 > this.getMaxPage() ? this.getMaxPage() : pageNo + 1;
	}

	public void setAfter(int after) {
		this.after = after;
	}

	/**
	 * 封装的list集合
	 * 
	 * @return
	 */
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	/**
	 * 判断是否是首页
	 * 
	 * @return
	 */
	public boolean isFirst() {
		return (this.getPageNo() == 1) ? true : false;
	}

	/**
	 * 判断是否是最后一页
	 * 
	 * @return
	 */
	public boolean isLast() {
		return (this.getPageNo() == this.getMaxPage()) ? true : false;
	}

}
