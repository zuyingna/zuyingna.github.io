package com.zyn.shopping.domain;
public class ProductDir {
	private Long id;
	private String dirName;
	private	Long parent_id;
	public Long getId() {
		return id;
	}
	public String getDirName() {
		return dirName;
	}
	public Long getParent_id() {
		return parent_id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setDirName(String dirName) {
		this.dirName = dirName;
	}
	public void setParent_id(Long parent_id) {
		this.parent_id = parent_id;
	}
	
}
