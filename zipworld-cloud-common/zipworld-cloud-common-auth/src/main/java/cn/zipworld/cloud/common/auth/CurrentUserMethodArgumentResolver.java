package cn.zipworld.cloud.common.auth;


import cn.zipworld.cloud.common.entity.auth.CurrentUser;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserContext.class) && parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        UserContext userContext = (UserContext) webRequest.getAttribute("userContext", RequestAttributes.SCOPE_REQUEST);
        if (userContext != null) {
            return userContext;
        }
        throw new MissingServletRequestPartException("userContext");
    }
}