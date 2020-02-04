package cn.zipworld.cloud.user.service.user;

import cn.zipworld.cloud.user.service.ServiceBase;

import java.io.Serializable;

public interface UserService  <Model, PK extends Serializable>
        extends ServiceBase<Model, PK> {
    String test(String req);
}
