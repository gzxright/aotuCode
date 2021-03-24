package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:AuthClientUser构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "AuthClientUser",value = "AuthClientUser")
@Table(name="auth_client_user")
public class AuthClientUser implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "auth_client_id")
	private Integer authClientId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "user_id")
	private Integer userId;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "auth_scope_id")
	private Integer authScopeId;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public Integer getAuthClientId() {
		return authClientId;
	}

	//set方法
	public void setAuthClientId(Integer authClientId) {
		this.authClientId = authClientId;
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
	public Integer getAuthScopeId() {
		return authScopeId;
	}

	//set方法
	public void setAuthScopeId(Integer authScopeId) {
		this.authScopeId = authScopeId;
	}


}
