package me.xiaoyuu.inwust.model;

import javax.persistence.*;

@Table(name = "project_info")
public class ProjectInfo {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String image;

    private String introduction;

    private String field;

    private String local;

    @Column(name = "is_company")
    private Boolean isCompany;

    private String status;

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
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return introduction
     */
    public String getIntroduction() {
        return introduction;
    }

    /**
     * @param introduction
     */
    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    /**
     * @return field
     */
    public String getField() {
        return field;
    }

    /**
     * @param field
     */
    public void setField(String field) {
        this.field = field;
    }

    /**
     * @return local
     */
    public String getLocal() {
        return local;
    }

    /**
     * @param local
     */
    public void setLocal(String local) {
        this.local = local;
    }

    /**
     * @return is_compny
     */
    public Boolean getIsCompany() {
        return isCompany;
    }

    /**
     * @param isCompany
     */
    public void setIsCompany(Boolean isCompany) {
        this.isCompany = isCompany;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}