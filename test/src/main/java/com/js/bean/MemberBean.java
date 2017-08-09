/**
 * 
 */
package com.js.bean;

import java.io.Serializable;

/**
 * @author oa_wenzongyuan
 */
public class MemberBean implements Serializable {

    /**
     */
    private static final long serialVersionUID = 4282572742718394132L;

    private Long id; // 主键

    private String name;// 名称

    private Long age;// 年纪

    /**
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public Long getAge() {
        return this.age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(Long age) {
        this.age = age;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "MemberBean [id=" + this.id + ", name=" + this.name + ", age=" + this.age + "]";
    }

}
