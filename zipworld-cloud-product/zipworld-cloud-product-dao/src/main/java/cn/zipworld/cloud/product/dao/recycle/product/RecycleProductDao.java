package cn.zipworld.cloud.product.dao.recycle.product;

import cn.zipworld.cloud.product.dao.MyBatisBaseDao;
import cn.zipworld.cloud.product.entity.recycle.product.RecycleProduct;
import cn.zipworld.cloud.product.entity.recycle.product.RecycleProductSelectReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface RecycleProductDao extends MyBatisBaseDao<RecycleProduct,Long> {
    List<RecycleProduct> select(RecycleProductSelectReq param);
}
