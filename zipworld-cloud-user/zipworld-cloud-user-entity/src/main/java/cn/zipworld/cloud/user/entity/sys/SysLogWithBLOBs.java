package cn.zipworld.cloud.user.entity.sys;

import java.io.Serializable;

/**
 * sys_log
 * @author 
 */
public class SysLogWithBLOBs extends SysLog implements Serializable {
    /**
     * 操作提交的数据
     */
    private String params;

    /**
     * 异常信息
     */
    private String exception;

    private static final long serialVersionUID = 1L;

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }
}