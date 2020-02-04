package cn.zipworld.cloud.product.entity.recycle.product;

import cn.zipworld.cloud.common.entity.base.PageReqBase;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class RecycleProductSelectReq extends PageReqBase {
    /**
     * 站点
     */
    private Long stationId;

    private Long workerId;
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
     * 开始创建时间
     */
    private LocalDateTime startDate;
    /**
     * 开始创建时间
     */
    private LocalDateTime endDate;

    /**
     * 更新人
     */
    private String updateBy;

}
