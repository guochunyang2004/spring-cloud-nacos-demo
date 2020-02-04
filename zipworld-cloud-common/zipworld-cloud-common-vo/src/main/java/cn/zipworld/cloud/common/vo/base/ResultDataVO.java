package cn.zipworld.cloud.common.vo.base;


import lombok.Data;

@Data
public class ResultDataVO<T> extends ResultVO{
    protected T data;

    public ResultDataVO(){

    }

    public ResultDataVO<T> isOK(T data){
        this.ok = true;
        this.data = data;
        return this;
    }

    public ResultDataVO isFail(String msg){
        this.ok = false;
        this.msg = msg;
        return  this;
    }

    public ResultDataVO<T> setData(T data){
        this.data = data;
        return  this;
    }

    private static <T> ResultDataVO newInstance(boolean ok, T t) {
        ResultDataVO resultDataVO = new ResultDataVO<T>();
        resultDataVO.setData(t);
        resultDataVO.setOk(ok);
        return resultDataVO;
    }

    /**
     * 返回成功数据
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultDataVO newInstanceIsOK(T t){
        return ResultDataVO.newInstance(true,t);
    }

    /**
     * 返回失败数据
     * @param t
     * @param <T>
     * @return
     */
    public static <T> ResultDataVO newInstanceIsFail(T t){
        return ResultDataVO.newInstance(false,t);
    }

    public static <T> ResultDataVO newInstanceIsFailMsg(String msg){
        T data = null;
        ResultDataVO resultDataVO = ResultDataVO.newInstance(false,data);
        resultDataVO.setMsg(msg);
        return resultDataVO;
    }

    public static <T> ResultDataVO newInstanceIsFailMsg(String msg, T t){
        T data = t;
        ResultDataVO resultDataVO = ResultDataVO.newInstance(false,data);
        resultDataVO.setMsg(msg);
        return resultDataVO;
    }

    public static <T> ResultDataVO newInstanceIsFailMsg(String msg,String error){
        T data = null;
        ResultDataVO resultDataVO = ResultDataVO.newInstance(false,data);
        resultDataVO.setMsg(msg);
        resultDataVO.setError(error);
        return resultDataVO;
    }
}