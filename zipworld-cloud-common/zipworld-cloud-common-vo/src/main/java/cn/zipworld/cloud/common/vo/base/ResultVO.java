package cn.zipworld.cloud.common.vo.base;


import lombok.Data;

@Data
public class ResultVO {
    protected boolean ok ;
    protected String msg;
    protected int code;
    /**
     * 错误详情
     */
    protected  String error;
    public ResultVO(){

    }
    public ResultVO(boolean ok){
        this.ok = ok;
    }

    public ResultVO(boolean ok,String msg){
        this.ok = ok;
        this.msg = msg;
    }

    public static ResultVO newInstance(boolean ok,String msg) {
        ResultVO resultVO = new ResultVO(ok,msg);
        return resultVO;
    }

    public static ResultVO newInstance(boolean isOK ){
        return ResultVO.newInstance(isOK,null);
    }

    public static <T> ResultVO newInstanceIsOKMsg(String msg){
        return ResultVO.newInstance(true,msg);
    }

    public static <T> ResultVO newInstanceIsFailMsg(String msg){
        return ResultVO.newInstance(false,msg);
    }


}