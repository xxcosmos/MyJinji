package me.xiaoyuu.inwust.model;

import java.util.Date;
import javax.persistence.*;

public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    private String title;

    private String content;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "sub_category_id")
    private Integer subCategoryId;

    /**
     * 产品主图,url相对地址
     */
    @Column(name = "main_image")
    private String mainImage;

    /**
     * 图片地址,json格式,扩展用
     */
    @Column(name = "sub_images")
    private String subImages;

    private Integer price;

    /**
     * 1-在售，2-卖出，3-删除
     */
    private Integer state;

    /**
     * 浏览次数
     */
    @Column(name = "view_count")
    private Integer viewCount;

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
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return category_id
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * @return sub_category_id
     */
    public Integer getSubCategoryId() {
        return subCategoryId;
    }

    /**
     * @param subCategoryId
     */
    public void setSubCategoryId(Integer subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    /**
     * 获取产品主图,url相对地址
     *
     * @return main_image - 产品主图,url相对地址
     */
    public String getMainImage() {
        return mainImage;
    }

    /**
     * 设置产品主图,url相对地址
     *
     * @param mainImage 产品主图,url相对地址
     */
    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    /**
     * 获取图片地址,json格式,扩展用
     *
     * @return sub_images - 图片地址,json格式,扩展用
     */
    public String getSubImages() {
        return subImages;
    }

    /**
     * 设置图片地址,json格式,扩展用
     *
     * @param subImages 图片地址,json格式,扩展用
     */
    public void setSubImages(String subImages) {
        this.subImages = subImages;
    }

    /**
     * @return price
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 获取1-在售，2-卖出，3-删除
     *
     * @return state - 1-在售，2-卖出，3-删除
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置1-在售，2-卖出，3-删除
     *
     * @param state 1-在售，2-卖出，3-删除
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取浏览次数
     *
     * @return view_count - 浏览次数
     */
    public Integer getViewCount() {
        return viewCount;
    }

    /**
     * 设置浏览次数
     *
     * @param viewCount 浏览次数
     */
    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
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