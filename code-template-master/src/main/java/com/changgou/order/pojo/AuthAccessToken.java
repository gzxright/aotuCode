package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:AuthAccessToken构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "AuthAccessToken",value = "AuthAccessToken")
@Table(name="auth_access_token")
public class AuthAccessToken implements Serializable{

	@ApiModelProperty(value = "id",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//id

	@ApiModelProperty(value = "Access Token",required = false)
    @Column(name = "access_token")
	private String accessToken;//Access Token

	@ApiModelProperty(value = "关联的用户ID",required = false)
    @Column(name = "user_id")
	private Integer userId;//关联的用户ID

	@ApiModelProperty(value = "用户名",required = false)
    @Column(name = "user_name")
	private String userName;//用户名

	@ApiModelProperty(value = "接入的客户端ID",required = false)
    @Column(name = "client_id")
	private Integer clientId;//接入的客户端ID

	@ApiModelProperty(value = "过期时间戳",required = false)
    @Column(name = "expires_in")
	private Long expiresIn;//过期时间戳

	@ApiModelProperty(value = "授权类型，比如：authorization_code",required = false)
    @Column(name = "grant_type")
	private String grantType;//授权类型，比如：authorization_code

	@ApiModelProperty(value = "可被访问的用户的权限范围，比如：basic、super",required = false)
    @Column(name = "scope")
	private String scope;//可被访问的用户的权限范围，比如：basic、super

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



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getAccessToken() {
		return accessToken;
	}

	//set方法
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
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
	public String getUserName() {
		return userName;
	}

	//set方法
	public void setUserName(String userName) {
		this.userName = userName;
	}
	//get方法
	public Integer getClientId() {
		return clientId;
	}

	//set方法
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	//get方法
	public Long getExpiresIn() {
		return expiresIn;
	}

	//set方法
	public void setExpiresIn(Long expiresIn) {
		this.expiresIn = expiresIn;
	}
	//get方法
	public String getGrantType() {
		return grantType;
	}

	//set方法
	public void setGrantType(String grantType) {
		this.grantType = grantType;
	}
	//get方法
	public String getScope() {
		return scope;
	}

	//set方法
	public void setScope(String scope) {
		this.scope = scope;
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


}
