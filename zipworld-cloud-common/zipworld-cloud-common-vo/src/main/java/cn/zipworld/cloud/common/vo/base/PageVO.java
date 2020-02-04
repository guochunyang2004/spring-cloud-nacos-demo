package cn.zipworld.cloud.common.vo.base;

import lombok.Data;

import java.util.List;

@Data
public class PageVO<T> {
    // 当前页
    private Integer index = 1;
    // 每页显示的总条数
    private Integer size = 10;
    // 总条数
    private Integer total;
    // 是否有下一页
    private Boolean isMore;
    // 总页数
    private Integer pages;
    // 开始索引
    private Integer startIndex;
    // 分页结果
    private List<T> list;

    public PageVO() {
        super();
    }
    public PageVO(Integer index, Integer size, Integer total) {
        super();
        this.index = index;
        this.size = size;
        this.total = total;
        this.pages = (this.total+this.size-1)/this.size;
        this.startIndex = (this.index-1)*this.size;
        this.isMore = this.index >= this.pages?false:true;
    }
}
