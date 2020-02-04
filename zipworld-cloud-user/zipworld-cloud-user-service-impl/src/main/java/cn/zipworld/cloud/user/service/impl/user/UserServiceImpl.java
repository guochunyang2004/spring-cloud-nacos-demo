package cn.zipworld.cloud.user.service.impl.user;

import cn.zipworld.cloud.user.entity.user.UserWorker;
import cn.zipworld.cloud.user.service.user.UserService;
import org.apache.dubbo.config.annotation.Service;

/*
demo
 */
@Service
public class UserServiceImpl implements UserService<UserWorker, Long> {

    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(UserWorker record) {
        return 0;
    }

    @Override
    public int insertSelective(UserWorker record) {
        return 0;
    }

    @Override
    public UserWorker selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(UserWorker record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(UserWorker record) {
        return 0;
    }

    @Override
    public String test(String req) {
        return "测试非标准方法";
    }
}
