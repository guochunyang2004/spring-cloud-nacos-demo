package cn.zipworld.cloud.product.business;

import cn.zipworld.cloud.product.dao.MyBatisBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public abstract class BussinessAbstract<Model, PK extends Serializable, Mapper extends MyBatisBaseDao> {
    @Autowired
    protected Mapper mapper;

    //@Override
    public int deleteByPrimaryKey(PK id) {
        return mapper.deleteByPrimaryKey(id);
    }

    //@Override
    public int insert(Model record) {
        return mapper.insert(record);
    }

    //@Override
    public int insertSelective(Model record) {
        return mapper.insertSelective(record);
    }


    //@Override
    public Model selectByPrimaryKey(PK id) {
        return (Model)mapper.selectByPrimaryKey(id);
    }

    //@Override
    public int updateByPrimaryKeySelective(Model record) {
        return mapper.updateByPrimaryKeySelective(record);
    }

    //@Override
    public int updateByPrimaryKey(Model record) {
        return mapper.updateByPrimaryKey(record);
    }
}
