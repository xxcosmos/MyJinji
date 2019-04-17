package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 性别：0 未知， 1男， 2 女
     */
    private Byte gender;

    /**
     * 生日
     */
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 手机号码
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 微信登录openid
     */
    private String openid;

    /**
     * 0 可用，1 禁用，2 注销
     */
    private Byte status;

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
     * 逻辑删除
     */
    private Boolean deleted;

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
     * 获取性别：0 未知， 1男， 2 女
     *
     * @return gender - 性别：0 未知， 1男， 2 女
     */
    public Byte getGender() {
        return gender;
    }

    /**
     * 设置性别：0 未知， 1男， 2 女
     *
     * @param gender 性别：0 未知， 1男， 2 女
     */
    public void setGender(Byte gender) {
        this.gender = gender;
    }

    /**
     * 获取生日
     *
     * @return date_of_birth - 生日
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * 设置生日
     *
     * @param dateOfBirth 生日
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * 获取用户昵称
     *
     * @return nickname - 用户昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置用户昵称
     *
     * @param nickname 用户昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取手机号码
     *
     * @return phone_number - 手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号码
     *
     * @param phoneNumber 手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取用户头像
     *
     * @return avatar - 用户头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置用户头像
     *
     * @param avatar 用户头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取微信登录openid
     *
     * @return openid - 微信登录openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置微信登录openid
     *
     * @param openid 微信登录openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 获取0 可用，1 禁用，2 注销
     *
     * @return status - 0 可用，1 禁用，2 注销
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0 可用，1 禁用，2 注销
     *
     * @param status 0 可用，1 禁用，2 注销
     */
    public void setStatus(Byte status) {
        this.status = status;
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

    /**
     * 获取逻辑删除
     *
     * @return deleted - 逻辑删除
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * 设置逻辑删除
     *
     * @param deleted 逻辑删除
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}