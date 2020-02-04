package cn.zipworld.cloud.user.entity.sys;

import cn.zipworld.cloud.common.entity.base.PageReqBase;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserSelectReq extends PageReqBase {
    /**
     * 登录名
     */
    private String loginName;
    /**
     * 姓名
     */
    private String name;
}
