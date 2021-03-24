package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:UserRole构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "UserRole",value = "UserRole")
@Table(name="user_role")
public class UserRole implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private Integer userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "role_id")
	private Integer roleId;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getUserId() {
		return userId;
	}

	//set方法
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}


}
