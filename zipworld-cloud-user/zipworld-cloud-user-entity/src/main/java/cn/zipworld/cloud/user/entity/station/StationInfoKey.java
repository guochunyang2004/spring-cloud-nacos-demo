package cn.zipworld.cloud.user.entity.station;

import java.io.Serializable;

/**
 * station_info
 * @author 
 */
public class StationInfoKey implements Serializable {
    private Long id;

    /**
     * 编号
     */
    private String code;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}