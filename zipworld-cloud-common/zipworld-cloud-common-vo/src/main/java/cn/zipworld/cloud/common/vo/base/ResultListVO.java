package cn.zipworld.cloud.common.vo.base;

import java.util.List;
public class ResultListVO<T> extends ResultDataVO<List<T>> {
    public ResultListVO<T> setList(List<T> list){
        this.data = list;
        return this;
    }
}