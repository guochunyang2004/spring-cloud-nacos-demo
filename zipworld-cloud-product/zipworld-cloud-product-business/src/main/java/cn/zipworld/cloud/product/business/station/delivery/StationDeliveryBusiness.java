package cn.zipworld.cloud.product.business.station.delivery;

import cn.zipworld.cloud.product.business.BussinessAbstract;
import cn.zipworld.cloud.product.dao.station.StationDeliveryDao;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliverySelectReq;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationDeliveryBusiness extends BussinessAbstract<StationDelivery,Long,StationDeliveryDao> {
    public List<StationDelivery> select(StationDeliverySelectReq req){
        return mapper.select(req);
    }
    public PageInfo<StationDelivery> selectPage(StationDeliverySelectReq req){
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<StationDelivery>  list = mapper.select(req);
        PageInfo<StationDelivery> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
}
