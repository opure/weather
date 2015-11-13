package com.vanvalt.util.mybatis.dialect;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页参数类
 * 
 */
public class PageParameter {

	public static final int DEFAULT_PAGE_SIZE = 10;
	public static final int DEFAULT_PAGE = 1;
	private static Logger logger = Logger.getLogger(PageParameter.class);
	private int pageSize;
	private int currentPage;
	// Jackson生成json忽略该字段
    @JsonIgnore
	private int prePage;
    // Jackson生成json忽略该字段
    @JsonIgnore
	private int nextPage;
	private int totalPage;
	private int totalCount;

	public PageParameter() {
		this.currentPage = DEFAULT_PAGE;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}
	

	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 */
	public PageParameter(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		if (this.currentPage < 1) {
			this.currentPage = 1;
		}
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
	/**
	 * Get the offset recorded pursuant to the current page. 
	 * @return int 
	 */
	// Jackson生成json忽略该字段
    @JsonIgnore
	public int getOffset(){
		
		int offset = 0 ;
		
		if (getCurrentPage() > 1) {
			
			offset = (getCurrentPage() -1) * getPageSize();
			
		}
		
		if (offset < 0) {
			offset = 0;
		}
		return offset;
	}
	
	public void initPage(int totalCount){
		
		this.totalCount = totalCount;
	
		this.totalPage = (totalCount / getPageSize()) + 1;
		if(totalCount==(totalPage-1)*getPageSize()){
			totalPage=totalPage-1;
		}
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PageParameter [pageSize=");
		builder.append(pageSize);
		builder.append(", currentPage=");
		builder.append(currentPage);
		builder.append(", prePage=");
		builder.append(prePage);
		builder.append(", nextPage=");
		builder.append(nextPage);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
