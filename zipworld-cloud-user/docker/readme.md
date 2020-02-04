新建一个Dockerfile

    vi Dockerfile

编写Dockerfile

    FROM openjdk:8-jre-alpine
    
    MAINTAINER luoliang
    
    ENV DUBBO_IP_TO_REGISTRY 192.168.0.101
    ENV DUBBO_PORT_TO_REGISTRY 12345
    
    ADD target/dubbo-provider.jar app.jar
    
    ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar","/app.jar"]
    
    EXPOSE 12345


构建镜像

    docker build -t dubbo-provider .

运行Provider容器

    docker run -d -p 12345:12345 --name dubbo-provider dubbo-provider

也可以不修改Dockerfile，通过run命令传入参数
    docker run -d -p 12345:12345 -e DUBBO_IP_TO_REGISTRY=192.168.1.7 -e DUBBO_PORT_TO_REGISTRY

在pom中加入插件的依赖

    <plugin>
        <groupId>com.spotify</groupId>
        <artifactId>dockerfile-maven-plugin</artifactId>
        <executions>
            <execution>
                <id>default</id>
                <goals>
                    <goal>build</goal>
                    <goal>push</goal>
                </goals>
            </execution>
        </executions>
        <configuration>
            <repository>dubbo-provider</repository>
            <tag>latest</tag>
            <buildArgs>
                <JAR_FILE>${project.build.finalName}.jar</JAR_FILE>
            </buildArgs>
        </configuration>
    </plugin>
复制代码
把dockerfile放在和pom.xml同级的目录下

    project/
      Dockerfile
      pom.xml
复制代码
使用maven命令进行打包

    mvn package 或者 mvn dockerfile:build

命令执行完成，可以使用docker images查看镜像，剩余步骤同上。
经测试，容器运行正常

作者：逗猫攻城狮
来源：掘金
链接： 
    https://juejin.im/post/5b2072016fb9a01e2d704431


    
    
    