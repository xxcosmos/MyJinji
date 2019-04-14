package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "major_info")
public class MajorInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学院code
     */
    @Column(name = "college_code")
    private String collegeCode;

    /**
     * 专业代码
     */
    @Column(name = "major_code")
    private String majorCode;

    /**
     * 专业名称
     */
    @Column(name = "major_name")
    private String majorName;

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
//
//    /**
//     * 设置id
//     *
//     * @param id id
//     */
//    public void setId(Integer id) {
//        this.id = id;
//    }

    /**
     * 获取学院code
     *
     * @return college_code - 学院code
     */
    public String getCollegeCode() {
        return collegeCode;
    }

    /**
     * 设置学院code
     *
     * @param collegeCode 学院Code
     */
    public void setCollegeCode(String collegeCode) {
        this.collegeCode = collegeCode;
    }

    /**
     * 获取专业代码
     *
     * @return major_code - 专业代码
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * 设置专业代码
     *
     * @param majorCode 专业代码
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    /**
     * 获取专业名称
     *
     * @return major_name - 专业名称
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置专业名称
     *
     * @param majorName 专业名称
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

//    /**
//     * 设置创建时间
//     *
//     * @param createTime 创建时间
//     */
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }

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