package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

public class User {
    /**
     * 用户id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * openid
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    @Column(name = "avatar_url")
    private String avatarUrl;

    /**
     * 性别：0未知，1男，2女
     */
    private Integer gender;

    /**
     * 城市
     */
    private String city;

    /**
     * 省份
     */
    private String province;

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
     * 赞的数量
     */
    @Column(name = "like_num")
    private Integer likeNum;

    /**
     * 个人简介
     */
    private String introduction;

    /**
     * 真实姓名
     */
    @Column(name = "real_name")
    private String realName;

    /**
     * 学号
     */
    @Column(name = "student_id")
    private String studentId;

    /**
     * 教务处密码
     */
    @Column(name = "jwc_password")
    private String jwcPassword;

    /**
     * 手机号
     */
    @Column(name = "phone_number")
    private String phoneNumber;

    /**
     * 0 正常，1 正常且认证 -1 删除 -2 违规
     */
    private Integer status;

    /**
     * 获取用户id
     *
     * @return id - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取openid
     *
     * @return openid - openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 设置openid
     *
     * @param openid openid
     */
    public void setOpenid(String openid) {
        this.openid = openid;
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
     * 获取用户头像
     *
     * @return avatar_url - 用户头像
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * 设置用户头像
     *
     * @param avatarUrl 用户头像
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * 获取性别：0未知，1男，2女
     *
     * @return gender - 性别：0未知，1男，2女
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 设置性别：0未知，1男，2女
     *
     * @param gender 性别：0未知，1男，2女
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 获取城市
     *
     * @return city - 城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置城市
     *
     * @param city 城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取省份
     *
     * @return province - 省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省份
     *
     * @param province 省份
     */
    public void setProvince(String province) {
        this.province = province;
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
     * 获取赞的数量
     *
     * @return like_num - 赞的数量
     */
    public Integer getLikeNum() {
        return likeNum;
    }

    /**
     * 设置赞的数量
     *
     * @param likeNum 赞的数量
     */
    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    /**
     * 获取个人简介
     *
     * @return introduction - 个人简介
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * 设置个人简介
     *
     * @param introduction 个人简介
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * 获取真实姓名
     *
     * @return real_name - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

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
     * 获取教务处密码
     *
     * @return jwc_password - 教务处密码
     */
    public String getJwcPassword() {
        return jwcPassword;
    }

    /**
     * 设置教务处密码
     *
     * @param jwcPassword 教务处密码
     */
    public void setJwcPassword(String jwcPassword) {
        this.jwcPassword = jwcPassword;
    }

    /**
     * 获取手机号
     *
     * @return phone_number - 手机号
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 设置手机号
     *
     * @param phoneNumber 手机号
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 获取0 正常，1 正常且认证 -1 删除 -2 违规
     *
     * @return status - 0 正常，1 正常且认证 -1 删除 -2 违规
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0 正常，1 正常且认证 -1 删除 -2 违规
     *
     * @param status 0 正常，1 正常且认证 -1 删除 -2 违规
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}