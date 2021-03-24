package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:AuthClientDetails构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "AuthClientDetails",value = "AuthClientDetails")
@Table(name="auth_client_details")
public class AuthClientDetails implements Serializable{

	@ApiModelProperty(value = "id",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//id

	@ApiModelProperty(value = "接入的客户端ID",required = false)
    @Column(name = "client_id")
	private String clientId;//接入的客户端ID

	@ApiModelProperty(value = "",required = false)
    @Column(name = "client_name")
	private String clientName;//

	@ApiModelProperty(value = "接入的客户端的密钥",required = false)
    @Column(name = "client_secret")
	private String clientSecret;//接入的客户端的密钥

	@ApiModelProperty(value = "回调地址",required = false)
    @Column(name = "redirect_uri")
	private String redirectUri;//回调地址

	@ApiModelProperty(value = "描述信息",required = false)
    @Column(name = "description")
	private String description;//描述信息

	@ApiModelProperty(value = "创建用户",required = false)
    @Column(name = "create_user")
	private Integer createUser;//创建用户

	@ApiModelProperty(value = "创建时间",required = false)
    @Column(name = "create_time")
	private Date createTime;//创建时间

	@ApiModelProperty(value = "最后更新用户",required = false)
    @Column(name = "update_user")
	private Integer updateUser;//最后更新用户

	@ApiModelProperty(value = "最后更新时间",required = false)
    @Column(name = "update_time")
	private Date updateTime;//最后更新时间

	@ApiModelProperty(value = "0表示未开通；1表示正常使用；2表示已被禁用",required = false)
    @Column(name = "status")
	private Integer status;//0表示未开通；1表示正常使用；2表示已被禁用



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	//get方法
	public String getClientName() {
		return clientName;
	}

	//set方法
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	//get方法
	public String getClientSecret() {
		return clientSecret;
	}

	//set方法
	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}
	//get方法
	public String getRedirectUri() {
		return redirectUri;
	}

	//set方法
	public void setRedirectUri(String redirectUri) {
		this.redirectUri = redirectUri;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}
	//get方法
	public Integer getCreateUser() {
		return createUser;
	}

	//set方法
	public void setCreateUser(Integer createUser) {
		this.createUser = createUser;
	}
	//get方法
	public Date getCreateTime() {
		return createTime;
	}

	//set方法
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	//get方法
	public Integer getUpdateUser() {
		return updateUser;
	}

	//set方法
	public void setUpdateUser(Integer updateUser) {
		this.updateUser = updateUser;
	}
	//get方法
	public Date getUpdateTime() {
		return updateTime;
	}

	//set方法
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	//get方法
	public Integer getStatus() {
		return status;
	}

	//set方法
	public void setStatus(Integer status) {
		this.status = status;
	}


}
