/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同生成Entity
 * 
 * @author Cody
 * @version 2017-04-12
 */
@ApiModel("代码对象")
public class Code {

	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value="主键ID",required=true)
	private String id;
	@ApiModelProperty(value="城市区号",required=true)
	private String areacode; // 城市区号
	@ApiModelProperty(value="合同序号",required=true)
	private Integer code; // 合同序号
	@ApiModelProperty(value="日期",required=true)
	private String date; // 日期
	@ApiModelProperty(value="年限",required=true)
	private Integer ycode;

	public Integer getYcode() {
		return ycode;
	}

	public void setYcode(Integer ycode) {
		this.ycode = ycode;
	}

	public Code() {
		super();
	}

	public String getAreacode() {
		return areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}