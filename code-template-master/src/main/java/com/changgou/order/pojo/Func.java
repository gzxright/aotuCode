package com.changgou.order.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.*;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
/****
 * @Author:shenkunlin
 * @Description:Func构建
 * @Date 2019/6/14 19:13
 *****/
@ApiModel(description = "Func",value = "Func")
@Table(name="func")
public class Func implements Serializable{

	@ApiModelProperty(value = "",required = false)
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Integer id;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "name")
	private String name;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "description")
	private String description;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "code")
	private String code;//

	@ApiModelProperty(value = "",required = false)
    @Column(name = "url")
	private String url;//

	@ApiModelProperty(value = "1表示正常使用；2表示已被禁用",required = false)
    @Column(name = "status")
	private Integer status;//1表示正常使用；2表示已被禁用



	//get方法
	public Integer getId() {
		return id;
	}

	//set方法
	public void setId(Integer id) {
		this.id = id;
	}
	//get方法
	public String getName() {
		return name;
	}

	//set方法
	public void setName(String name) {
		this.name = name;
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
	public String getCode() {
		return code;
	}

	//set方法
	public void setCode(String code) {
		this.code = code;
	}
	//get方法
	public String getUrl() {
		return url;
	}

	//set方法
	public void setUrl(String url) {
		this.url = url;
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
