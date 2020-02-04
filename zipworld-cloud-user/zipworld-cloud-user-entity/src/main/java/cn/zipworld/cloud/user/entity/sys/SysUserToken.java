package cn.zipworld.cloud.user.entity.sys;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SysUserToken  implements Serializable {
    private Long id;

    private Long userId;

    private String token;

    private Integer appId;

    private LocalDateTime expireTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer delFlag;
}
