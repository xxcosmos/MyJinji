package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "college_info")
public class CollegeInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学院代码
     */
    @Column(name = "college_code")
    private String collegeCode;

    /**
     * 学院名称
     */
    @Column(name = "college_name")
    private String collegeName;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 获取id
     *
     * @return id - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取学院代码
     *
     * @return college_code - 学院代码
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * 设置学院代码
     *
     * @param collegeCode 学院代码
     */
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * 获取学院名称
     *
     * @return college_name - 学院名称
     */
    public String getCollegeName() {
        return collegeName;
    }

    /**
     * 设置学院名称
     *
     * @param collegeName 学院名称
     */
    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return update_time - 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置修改时间
     *
     * @param updateTime 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}