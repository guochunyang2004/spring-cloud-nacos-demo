package cn.zipworld.cloud.product.entity.station.delivery;

import cn.zipworld.cloud.common.entity.base.PageReqBase;
import lombok.Data;

@Data
public class StationDeliveryCommoditySelectReq extends PageReqBase {
    private Long deliveryId;
    private Long commodityId;
    private String productCode;
}
