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
 * @Description:SsoRefreshToken构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SsoRefreshToken",value = "SsoRefreshToken")
@Table(name="sso_refresh_token")
public class SsoRefreshToken implements Serializable{

	@ApiModelProperty(value = "id",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//id

	@ApiModelProperty(value = "表sso_access_token对应的Access Token记录",required = false)
    @Column(name = "token_id")
	private Integer tokenId;//表sso_access_token对应的Access Token记录

	@ApiModelProperty(value = "Refresh Token",required = false)
    @Column(name = "refresh_token")
	private String refreshToken;//Refresh Token

	@ApiModelProperty(value = "过期时间戳",required = false)
    @Column(name = "expires_in")
	private Long expiresIn;//过期时间戳

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
	public Integer getTokenId() {
		return tokenId;
	}

	//set方法
	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}
	//get方法
	public String getRefreshToken() {
		return refreshToken;
	}

	//set方法
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
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
