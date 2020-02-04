package cn.zipworld.cloud.user.business.user;

import cn.zipworld.cloud.user.business.BusinessAbstract;
import cn.zipworld.cloud.user.dao.user.UserWorkerStationDao;
import cn.zipworld.cloud.user.entity.user.UserWorkerStation;
import org.springframework.stereotype.Service;

@Service
public class UserWorkerStationBusiness extends BusinessAbstract<UserWorkerStation,Long,UserWorkerStationDao> {
}
