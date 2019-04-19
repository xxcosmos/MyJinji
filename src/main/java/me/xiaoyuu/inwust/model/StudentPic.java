package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "student_pic")
public class StudentPic {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 对应学号
     */
    @Column(name = "student_id")
    private String studentId;

    /**
     * 图片URL
     */
    private String url;

    /**
     * 删除图片url
     */
    @Column(name = "delete_url")
    private String deleteUrl;

    /**
     * 图片返回hash
     */
    private String hash;

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
     * 获取对应学号
     *
     * @return student_id - 对应学号
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * 设置对应学号
     *
     * @param studentId 对应学号
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
     * 获取图片URL
     *
     * @return url - 图片URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片URL
     *
     * @param url 图片URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取删除图片url
     *
     * @return delete_url - 删除图片url
     */
    public String getDeleteUrl() {
        return deleteUrl;
    }

    /**
     * 设置删除图片url
     *
     * @param deleteUrl 删除图片url
     */
    public void setDeleteUrl(String deleteUrl) {
        this.deleteUrl = deleteUrl;
    }

    /**
     * 获取图片返回hash
     *
     * @return hash - 图片返回hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * 设置图片返回hash
     *
     * @param hash 图片返回hash
     */
    public void setHash(String hash) {
        this.hash = hash;
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

    @Override
    public String toString() {
        return "StudentPic{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", url='" + url + '\'' +
                ", deleteUrl='" + deleteUrl + '\'' +
                ", hash='" + hash + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}