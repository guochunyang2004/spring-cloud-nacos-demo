# 注意
本项目不得引入businuss层，否则其他引用此接口的RPC会报错：
```
org.springframework.context.annotation.ConflictingBeanDefinitionException: Annotation-specified bean name 'myBatisBaseDao' for bean class [cn.zipworld.cloud.product.dao.MyBatisBaseDao] conflicts with existing, non-compatible bean definition of same name and class [org.mybatis.spring.mapper.MapperFactoryBean]
	at org.springframework.context.annotation.ClassPathBeanDefinitionScanner.checkCandidate(ClassPathBeanDefinitionScanner.java:348) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.mybatis.spring.mapper.ClassPathMapperScanner.checkCandidate(ClassPathMapperScanner.java:256) ~[mybatis-spring-2.0.3.jar:2.0.3]
	at org.springframework.context.annotation.ClassPathBeanDefinitionScanner.doScan(ClassPathBeanDefinitionScanner.java:286) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.mybatis.spring.mapper.ClassPathMapperScanner.doScan(ClassPathMapperScanner.java:181) ~[mybatis-spring-2.0.3.jar:2.0.3]
	at org.springframework.context.annotation.ClassPathBeanDefinitionScanner.scan(ClassPathBeanDefinitionScanner.java:253) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.mybatis.spring.mapper.MapperScannerConfigurer.postProcessBeanDefinitionRegistry(MapperScannerConfigurer.java:356) ~[mybatis-spring-2.0.3.jar:2.0.3]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanDefinitionRegistryPostProcessors(PostProcessorRegistrationDelegate.java:275) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.context.support.PostProcessorRegistrationDelegate.invokeBeanFactoryPostProcessors(PostProcessorRegistrationDelegate.java:125) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.invokeBeanFactoryPostProcessors(AbstractApplicationContext.java:691) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:528) ~[spring-context-5.1.4.RELEASE.jar:5.1.4.RELEASE]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:142) ~[spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:775) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:397) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:316) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) [spring-boot-2.1.2.RELEASE.jar:2.1.2.RELEASE]
	at cn.zipworld.cloud.product.web.ZipworldCloudProductWebApplication.main(ZipworldCloudProductWebApplication.java:14) [classes/:na]
```