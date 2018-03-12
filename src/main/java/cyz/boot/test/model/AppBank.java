package cyz.boot.test.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "app_bank")
public class AppBank {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "bank_type")
    private String bankType;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "bank_remark")
    private String bankRemark;

    private BigDecimal enable;

    @Column(name = "city_code")
    private String cityCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "img_path")
    private String imgPath;

    @Column(name = "pay_limit")
    private Long payLimit;

    @Column(name = "use_flag")
    private String useFlag;

    @Column(name = "create_time")
    private Date createTime;

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
     * @return bank_type
     */
    public String getBankType() {
        return bankType;
    }

    /**
     * @param bankType
     */
    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    /**
     * @return bank_name
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * @param bankName
     */
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    /**
     * @return bank_remark
     */
    public String getBankRemark() {
        return bankRemark;
    }

    /**
     * @param bankRemark
     */
    public void setBankRemark(String bankRemark) {
        this.bankRemark = bankRemark;
    }

    /**
     * @return enable
     */
    public BigDecimal getEnable() {
        return enable;
    }

    /**
     * @param enable
     */
    public void setEnable(BigDecimal enable) {
        this.enable = enable;
    }

    /**
     * @return city_code
     */
    public String getCityCode() {
        return cityCode;
    }

    /**
     * @param cityCode
     */
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    /**
     * @return city_name
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * @return img_path
     */
    public String getImgPath() {
        return imgPath;
    }

    /**
     * @param imgPath
     */
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    /**
     * @return pay_limit
     */
    public Long getPayLimit() {
        return payLimit;
    }

    /**
     * @param payLimit
     */
    public void setPayLimit(Long payLimit) {
        this.payLimit = payLimit;
    }

    /**
     * @return use_flag
     */
    public String getUseFlag() {
        return useFlag;
    }

    /**
     * @param useFlag
     */
    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}