package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:RoleFunc构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "RoleFunc",value = "RoleFunc")
@Table(name="role_func")
public class RoleFunc implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "role_id")
	private Integer roleId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "func_id")
	private Integer funcId;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getRoleId() {
		return roleId;
	}

	//set方法
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	//get方法
	public Integer getFuncId() {
		return funcId;
	}

	//set方法
	public void setFuncId(Integer funcId) {
		this.funcId = funcId;
	}


}
