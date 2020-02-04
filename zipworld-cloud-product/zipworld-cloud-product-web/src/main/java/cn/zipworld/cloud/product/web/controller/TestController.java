package cn.zipworld.cloud.product.web.controller;

import cn.zipworld.cloud.common.auth.UserContextService;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.product.business.recycle.product.RecycleProductBusiness;
import cn.zipworld.cloud.user.entity.user.UserWorker;
import cn.zipworld.cloud.user.service.user.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private RecycleProductBusiness recycleProductBusiness;

    @Reference(retries = 0, check = false)
    private UserService userService;

    @Autowired
    private UserContextService userContextService;

    @GetMapping("/test/{p}")
    public String test( @PathVariable String p){
        return userService.test(p);
    }
    /**
     * rpc获取工人信息
     * @param id
     * @return
     */
    @GetMapping("/getUserWorker/{id}")
    public UserWorker getUserWorker(Long id){
        return recycleProductBusiness.getUserWorker(id);
    }
    @GetMapping("/createToken")
    public UserContext createToken(){
        UserContext userContext = new UserContext();
        userContext.setUsername("admin");
        userContext.setId(1L);
        String token = "test";
        userContextService.tokenRefresh(userContext,token);
        return  userContext;
    }

}
