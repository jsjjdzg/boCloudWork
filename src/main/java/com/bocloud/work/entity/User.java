package com.bocloud.work.entity;

/*
 * 用户实体类
 * 
 */

@SuppressWarnings("serial")
public class User extends SuperEntity<User>{
	
	private String name;
	private Long pwd;
	private Long department_id;
	private Boolean status; //状态 1在职 0离职
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPwd() {
		return pwd;
	}
	public void setPwd(Long pwd) {
		this.pwd = pwd;
	}
	public Long getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Long department_id) {
		this.department_id = department_id;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", pwd=" + pwd + ", department_id=" + department_id + ", status=" + status + "]";
	}
	
	
	
	

}
