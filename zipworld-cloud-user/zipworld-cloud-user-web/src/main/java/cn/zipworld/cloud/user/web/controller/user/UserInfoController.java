package cn.zipworld.cloud.user.web.controller.user;

import cn.zipworld.cloud.user.service.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "用户",tags = "user")
@Slf4j
@RestController()
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        return "当前时间："+ userService.test(" ");
    }
}
