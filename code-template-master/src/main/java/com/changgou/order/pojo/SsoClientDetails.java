package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:SsoClientDetails构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "SsoClientDetails",value = "SsoClientDetails")
@Table(name="sso_client_details")
public class SsoClientDetails implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "接入单点登录的系统名称",required = false)
    @Column(name = "client_name")
	private String clientName;//接入单点登录的系统名称

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "请求Token的回调URL",required = false)
    @Column(name = "redirect_url")
	private String redirectUrl;//请求Token的回调URL

	@ApiModelProperty(value = "注销URL",required = false)
    @Column(name = "logout_url")
	private String logoutUrl;//注销URL

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
	public String getClientName() {
		return clientName;
	}

	//set方法
	public void setClientName(String clientName) {
		this.clientName = clientName;
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
	public String getRedirectUrl() {
		return redirectUrl;
	}

	//set方法
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	//get方法
	public String getLogoutUrl() {
		return logoutUrl;
	}

	//set方法
	public void setLogoutUrl(String logoutUrl) {
		this.logoutUrl = logoutUrl;
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
