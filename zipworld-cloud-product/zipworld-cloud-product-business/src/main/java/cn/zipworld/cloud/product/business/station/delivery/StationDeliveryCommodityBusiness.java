package cn.zipworld.cloud.product.business.station.delivery;

import cn.zipworld.cloud.product.business.BussinessAbstract;
import cn.zipworld.cloud.product.dao.station.StationDeliveryCommodityDao;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommodity;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommoditySelectReq;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationDeliveryCommodityBusiness extends BussinessAbstract<StationDeliveryCommodity,Long,StationDeliveryCommodityDao> {
    public List<StationDeliveryCommodity> select(StationDeliveryCommoditySelectReq req){
        return mapper.select(req);
    }

    public PageInfo<StationDeliveryCommodity> selectPage(StationDeliveryCommoditySelectReq req){
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<StationDeliveryCommodity>  list = mapper.select(req);
        PageInfo<StationDeliveryCommodity> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
