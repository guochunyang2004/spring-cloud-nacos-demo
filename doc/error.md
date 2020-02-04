# pom错误


    rg.springframework.beans.factory.BeanCreationException: Error creating bean with name 'feignTargeter'
##原因：spring-boot-devtools问题，放到具体启动项目里
##可能原因：
     缺少properties配置，导致自动装配属性失败导致的异常，深层次的原因没有进一步跟踪
参考：https://github.com/alibaba/spring-cloud-alibaba/issues/678



    
    