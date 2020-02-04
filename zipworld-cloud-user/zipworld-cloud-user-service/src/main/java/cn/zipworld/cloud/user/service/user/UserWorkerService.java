package cn.zipworld.cloud.user.service.user;


import cn.zipworld.cloud.user.service.ServiceBase;

import java.io.Serializable;

public interface UserWorkerService <Model, PK extends Serializable>
        extends ServiceBase<Model, PK>  {
    String select();//自定义方法例子
}
