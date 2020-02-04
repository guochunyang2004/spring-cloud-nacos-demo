package cn.zipworld.cloud.user.service.impl.user;

import cn.zipworld.cloud.user.business.user.UserWorkerBusiness;
import cn.zipworld.cloud.user.entity.user.UserWorker;
import cn.zipworld.cloud.user.service.user.UserWorkerService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserWorkerServiceImpl implements UserWorkerService<UserWorker, Long> {

    @Autowired
    private UserWorkerBusiness business;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return business.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserWorker record) {
        return business.insert(record);
    }

    @Override
    public int insertSelective(UserWorker record) {
        return business.insertSelective(record);
    }

    @Override
    public UserWorker selectByPrimaryKey(Long id) {
        return business.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserWorker record) {
        return business.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserWorker record) {
        return business.updateByPrimaryKey(record);
    }

    @Override
    public String select() {
        return "自定义方法例子";
    }
}
