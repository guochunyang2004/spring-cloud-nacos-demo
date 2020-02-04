package cn.zipworld.cloud.product.entity.station.delivery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * station_delivery_commodity
 * @author 
 */
public class StationDeliveryCommodity implements Serializable {
    private Long id;

    /**
     * 出货单id
     */
    private Long deliveryId;

    /**
     * 出货商品
     */
    private Long commodityId;

    /**
     * 出货商品
     */
    private String commodityName;

    /**
     * 计划商品单位
     */
    private Long planSpecificationId;

    /**
     * 计划商品单位
     */
    private String planSpecificationName;

    /**
     * 计划数量
     */
    private Integer planAmount;

    /**
     * 计划重量
     */
    private BigDecimal planWeight;

    /**
     * 出货商品数量
     */
    private Integer deliveryAmount;

    /**
     * 出货商品单位
     */
    private Long deliverySpecificationId;

    /**
     * 出货商品单位
     */
    private String deliverySpecificationName;

    /**
     * 出货商品重量
     */
    private BigDecimal deliveryWeight;

    /**
     * 差异数量
     */
    private Integer differAmount;

    /**
     * 差异重量
     */
    private BigDecimal differWeight;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private LocalDateTime updateDate;

    /**
     * 备注
     */
    private String remarks;

    private String delFlag;

    private Long version;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
    }

    public Long getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(Long commodityId) {
        this.commodityId = commodityId;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public Long getPlanSpecificationId() {
        return planSpecificationId;
    }

    public void setPlanSpecificationId(Long planSpecificationId) {
        this.planSpecificationId = planSpecificationId;
    }

    public String getPlanSpecificationName() {
        return planSpecificationName;
    }

    public void setPlanSpecificationName(String planSpecificationName) {
        this.planSpecificationName = planSpecificationName;
    }

    public Integer getPlanAmount() {
        return planAmount;
    }

    public void setPlanAmount(Integer planAmount) {
        this.planAmount = planAmount;
    }

    public BigDecimal getPlanWeight() {
        return planWeight;
    }

    public void setPlanWeight(BigDecimal planWeight) {
        this.planWeight = planWeight;
    }

    public Integer getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
    }

    public Long getDeliverySpecificationId() {
        return deliverySpecificationId;
    }

    public void setDeliverySpecificationId(Long deliverySpecificationId) {
        this.deliverySpecificationId = deliverySpecificationId;
    }

    public String getDeliverySpecificationName() {
        return deliverySpecificationName;
    }

    public void setDeliverySpecificationName(String deliverySpecificationName) {
        this.deliverySpecificationName = deliverySpecificationName;
    }

    public BigDecimal getDeliveryWeight() {
        return deliveryWeight;
    }

    public void setDeliveryWeight(BigDecimal deliveryWeight) {
        this.deliveryWeight = deliveryWeight;
    }

    public Integer getDifferAmount() {
        return differAmount;
    }

    public void setDifferAmount(Integer differAmount) {
        this.differAmount = differAmount;
    }

    public BigDecimal getDifferWeight() {
        return differWeight;
    }

    public void setDifferWeight(BigDecimal differWeight) {
        this.differWeight = differWeight;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}