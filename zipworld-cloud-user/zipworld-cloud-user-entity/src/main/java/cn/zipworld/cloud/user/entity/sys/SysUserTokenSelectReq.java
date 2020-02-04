package cn.zipworld.cloud.user.entity.sys;

import cn.zipworld.cloud.common.entity.base.PageReqBase;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysUserTokenSelectReq extends PageReqBase {
    private Long userId;
    private String token;
    private Integer appId;
    private LocalDateTime expireTimeBegin;
    private LocalDateTime expireTimeEnd;

}
