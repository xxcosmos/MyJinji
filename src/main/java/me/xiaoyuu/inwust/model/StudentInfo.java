package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "student_info")
public class StudentInfo {
    public StudentInfo() {
    }

    public StudentInfo(String studentId, String studentName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }

    /**
     * 专业code
     */
    @Column(name = "major_code")
    private String majorCode;

    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学号
     */
    @Column(name = "student_id")
    private String studentId;

    /**
     * 姓名
     */
    @Column(name = "student_name")
    private String studentName;


    public StudentInfo(String studentId, String studentName, String majorCode) {
        this.studentId = studentId;
        this.studentName = studentName;

        this.majorCode = majorCode;
    }

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

//    /**
//     * 设置id
//     *
//     * @param id id
//     */
//    public void setId(Integer id) {
//        this.id = id;
//    }

    /**
     * 获取学号
     *
     * @return student_id - 学号
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置学号
     *
     * @param studentId 学号
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取姓名
     *
     * @return student_name - 姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 设置姓名
     *
     * @param studentName 姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 获取专业code
     *
     * @return major_code - 专业code
     */
    public String getMajorCode() {
        return majorCode;
    }

    /**
     * 设置专业code
     *
     * @param majorCode 专业code
     */
    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
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

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", majorCode=" + majorCode +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}