package cn.zipworld.cloud.user.business.user;

import cn.zipworld.cloud.user.business.BusinessAbstract;
import cn.zipworld.cloud.user.dao.user.UserWorkerDao;
import cn.zipworld.cloud.user.entity.user.UserWorker;
import org.springframework.stereotype.Service;

@Service
public class UserWorkerBusiness extends BusinessAbstract<UserWorker,Long,UserWorkerDao> {
}
