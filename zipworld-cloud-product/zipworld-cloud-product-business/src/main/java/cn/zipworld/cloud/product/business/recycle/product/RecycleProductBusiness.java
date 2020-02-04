package cn.zipworld.cloud.product.business.recycle.product;

import cn.zipworld.cloud.product.business.BussinessAbstract;
import cn.zipworld.cloud.product.dao.recycle.product.RecycleProductDao;
import cn.zipworld.cloud.product.entity.recycle.product.RecycleProduct;
import cn.zipworld.cloud.product.entity.recycle.product.RecycleProductSelectReq;
import cn.zipworld.cloud.user.entity.user.UserWorker;
import cn.zipworld.cloud.user.service.user.UserWorkerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecycleProductBusiness extends BussinessAbstract<RecycleProduct, Long, RecycleProductDao> {

    @Reference(retries = 0, check = false)
    private UserWorkerService userWorkerService;

    public List<RecycleProduct> select(RecycleProductSelectReq req){
        return mapper.select(req);
    }

    public PageInfo<RecycleProduct> selectPage(RecycleProductSelectReq req){
        // 开启分页插件,放在查询语句上面 帮助生成分页语句
        PageHelper.startPage(req.getPageNum(), req.getPageSize());
        List<RecycleProduct>  list = mapper.select(req);
        PageInfo<RecycleProduct> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 事务保存例子
     * @param record
     * @return
     */
    @Transactional(readOnly = false)
    public RecycleProduct save(RecycleProduct record){
        if (record.getId()!=null && record.getId()>0){
            mapper.updateByPrimaryKeySelective(record);
        }
        else {
            mapper.insertSelective(record);
        }
        return record;
    }

    /**
     * rpc获取工人信息
     * @param id
     * @return
     */
    public UserWorker getUserWorker(Long id){
       return (UserWorker)userWorkerService.selectByPrimaryKey(id);
    }
}
