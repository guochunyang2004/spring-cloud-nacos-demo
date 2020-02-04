package cn.zipworld.cloud.product.entity.station.delivery;

import cn.zipworld.cloud.common.entity.base.PageReqBase;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StationDeliverySelectReq extends PageReqBase {
    private String code;
    private String codeLike;
    private Long sourceStationId;
    private Long destStationId;
    private String cleanCode;
    private LocalDateTime beginDeliveryTime;
    private LocalDateTime endDeliveryTime;
    private Integer status;
    private Long commodityId;
}
