package cn.zipworld.cloud.product.entity.recycle.product;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RecycleProduct implements Serializable {
    private Long id;

    /**
     * 站点
     */
    private Long stationId;

    /**
     * 成品编号
     */
    private String code;

    /**
     * 商品id
     */
    private Long commodityId;

    /**
     * sku
     */
    private Long skuId;

    private String skuName; //sku名称

    /**
     * 单位
     */
    private Long specificationId;

    /**
     * 单位名称
     */
    private String specificationName;

    /**
     * 长
     */
    private Long lengths;

    /**
     * 宽
     */
    private Long width;

    /**
     * 高
     */
    private Long height;

    /**
     * 重量
     */
    private BigDecimal weight;

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
    private String remark;

    /**
     * 删除
     */
    private String delFlag;

    /**
     * 版本
     */
    private Long version;

    private static final long serialVersionUID = 1L;
}
