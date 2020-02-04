package cn.zipworld.cloud.product.entity.station.delivery;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * station_delivery
 * @author 
 */
public class StationDelivery implements Serializable {
    private Long id;

    /**
     * 出货单号
     */
    private String code;

    /**
     * 发货地
     */
    private Long sourceStationId;

    /**
     * 目的地
     */
    private Long destStationId;

    /**
     * 清运单号
     */
    private String cleanCode;

    /**
     * 计划清运数量
     */
    private Integer planAmount;

    /**
     * 计划清运重量
     */
    private BigDecimal planWeight;

    /**
     * 品类数
     */
    private Integer commodityAmount;

    /**
     * 出货数量
     */
    private Integer deliveryAmount;

    /**
     * 出货重量
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
     * 出货时间
     */
    private LocalDateTime deliveryTime;

    /**
     * 出货人
     */
    private Long deliveryBy;

    /**
     * 状态
     */
    private Integer status;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Long getSourceStationId() {
        return sourceStationId;
    }

    public void setSourceStationId(Long sourceStationId) {
        this.sourceStationId = sourceStationId;
    }

    public Long getDestStationId() {
        return destStationId;
    }

    public void setDestStationId(Long destStationId) {
        this.destStationId = destStationId;
    }

    public String getCleanCode() {
        return cleanCode;
    }

    public void setCleanCode(String cleanCode) {
        this.cleanCode = cleanCode;
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

    public Integer getCommodityAmount() {
        return commodityAmount;
    }

    public void setCommodityAmount(Integer commodityAmount) {
        this.commodityAmount = commodityAmount;
    }

    public Integer getDeliveryAmount() {
        return deliveryAmount;
    }

    public void setDeliveryAmount(Integer deliveryAmount) {
        this.deliveryAmount = deliveryAmount;
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

    public LocalDateTime getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDateTime deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Long getDeliveryBy() {
        return deliveryBy;
    }

    public void setDeliveryBy(Long deliveryBy) {
        this.deliveryBy = deliveryBy;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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