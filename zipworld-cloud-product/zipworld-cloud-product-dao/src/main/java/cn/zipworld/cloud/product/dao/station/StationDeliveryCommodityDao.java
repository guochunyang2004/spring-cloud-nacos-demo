package cn.zipworld.cloud.product.dao.station;

import cn.zipworld.cloud.product.dao.MyBatisBaseDao;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommodity;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommoditySelectReq;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliverySelectReq;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * StationDeliveryCommodityDao继承基类
 */
@Repository
public interface StationDeliveryCommodityDao extends MyBatisBaseDao<StationDeliveryCommodity, Long> {
    List<StationDeliveryCommodity> select(StationDeliveryCommoditySelectReq req);
}