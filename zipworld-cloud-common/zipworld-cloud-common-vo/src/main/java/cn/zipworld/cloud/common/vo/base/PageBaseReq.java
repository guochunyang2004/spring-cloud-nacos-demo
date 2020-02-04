package cn.zipworld.cloud.common.vo.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 分页参数
 */
@ApiModel(value="分页参数",description="分页参数基类")
@Data
public abstract class PageBaseReq {
    /**
     * 当前页
     */
    @ApiModelProperty(value="当前页",example="1",position = 1)
    protected Integer pageNum = 1;

    /**
     * 每页大小
     */
    @ApiModelProperty(value="每页大小",example="10",position = 0)
    protected Integer pageSize = 10;
}
