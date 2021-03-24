package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:AuthScope构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "AuthScope",value = "AuthScope")
@Table(name="auth_scope")
public class AuthScope implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "可被访问的用户的权限范围，比如：basic、super",required = false)
    @Column(name = "scope_name")
	private String scopeName;//可被访问的用户的权限范围，比如：basic、super

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getScopeName() {
		return scopeName;
	}

	//set方法
	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}
	//get方法
	public String getDescription() {
		return description;
	}

	//set方法
	public void setDescription(String description) {
		this.description = description;
	}


}
