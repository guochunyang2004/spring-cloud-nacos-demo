package cn.zipworld.cloud.common.auth;

import cn.zipworld.cloud.common.entity.auth.AuthToken;
import cn.zipworld.cloud.common.entity.auth.NoAuthToken;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import io.micrometer.core.instrument.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthenticationInterceptor implements HandlerInterceptor {
    @Autowired
    private UserContextService userContextService;
//    @Autowired
//    UserInfoService userInfoService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {

        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(NoAuthToken.class)) {
            NoAuthToken noAuthToken = method.getAnnotation(NoAuthToken.class);
            if (noAuthToken.required()) {
                return true;
            }
        }
        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(AuthToken.class)) {
            String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
            if (StringUtils.isBlank(token))
                token = httpServletRequest.getParameter("token");
            AuthToken authToken = method.getAnnotation(AuthToken.class);
            if (authToken.required()) {
                // 执行认证
                if (StringUtils.isBlank(token)) {
                    throw new RuntimeException("Invalid token!");
                }
                // 获取 token 中的 user id
                UserContext userContext = null;
                try {
                    userContext = userContextService.getUserContext(token);
                    if (userContext==null || userContext.getId()==null || userContext.getId()<1){
                        throw new RuntimeException("Invalid token !");
                    }
                    userContextService.tokenRefresh(userContext,token);
                } catch (Exception ex) {
                    throw ex;
                    // throw new RuntimeException("401");
                }
//                UserInfoEntity userInfoEntity = (UserInfoEntity) userInfoService.selectByPrimaryKey(userContext.getId());
//                if (userInfoEntity == null || userInfoEntity.getId() == null || userInfoEntity.getId() < 1) {
//                    throw new RuntimeException("用户不存在，请重新登录");
//                }
                httpServletRequest.setAttribute("userContext", userContext);
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }
}
