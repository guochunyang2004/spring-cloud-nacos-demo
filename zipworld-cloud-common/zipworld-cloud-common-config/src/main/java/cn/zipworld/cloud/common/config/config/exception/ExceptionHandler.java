package cn.zipworld.cloud.common.config.config.exception;

import cn.zipworld.cloud.common.vo.base.ResultVO;
import io.micrometer.core.instrument.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
@Slf4j
public class ExceptionHandler {
    //    @org.springframework.web.bind.annotation.ExceptionHandler(StudentException.class)
//    @ResponseBody
//    public Response handleStudentException(HttpServletRequest request, StudentException ex) {
//        Response response;
//        log.error("StudentException code:{},msg:{}",ex.getResponse().getCode(),ex.getResponse().getMsg());
//        response = new Response(ex.getResponse().getCode(),ex.getResponse().getMsg());
//        return response;
//    }
    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultVO handleException(HttpServletRequest request, Exception ex) {
        ResultVO resultVO;
        log.error("exception error:{}",ex);

        resultVO = new ResultVO(false,
                ex.getMessage());
        String debug = request.getParameter("debug");
        if (StringUtils.isNotBlank(debug))
            resultVO.setError(getExceptionAllinformation(ex));
        return resultVO;
    }

    public static String getExceptionAllinformation(Exception ex){
        StringBuilder sOut = new StringBuilder();
        if (ex==null) return "";
        StackTraceElement[] trace = ex.getStackTrace();
        if (trace==null || trace.length==0) return ex.getMessage();
        sOut.append(ex.toString()).append("\r\n");
        for (StackTraceElement s : trace) {
            sOut.append("\tat " + s + "\r\n");
        }
        return sOut.toString();
    }
}