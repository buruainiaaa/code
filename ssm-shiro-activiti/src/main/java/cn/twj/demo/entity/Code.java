/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package cn.twj.demo.entity;

/**
 * 合同生成Entity
 * 
 * @author Cody
 * @version 2017-04-12
 */
public class Code {

	private static final long serialVersionUID = 1L;
	private String id;
	private String areacode; // 城市区号
	private Integer code; // 合同序号
	private String date; // 日期
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