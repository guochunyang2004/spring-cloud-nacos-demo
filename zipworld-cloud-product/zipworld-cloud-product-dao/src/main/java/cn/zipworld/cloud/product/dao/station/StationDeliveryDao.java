package cn.zipworld.cloud.product.dao.station;

import cn.zipworld.cloud.product.dao.MyBatisBaseDao;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliverySelectReq;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StationDeliveryDao extends MyBatisBaseDao<StationDelivery,Long> {
    List<StationDelivery> select(StationDeliverySelectReq req);
}
