package cn.zipworld.cloud.product.web.controller.recycle;

import cn.zipworld.cloud.common.entity.auth.AuthToken;
import cn.zipworld.cloud.common.entity.auth.CurrentUser;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.common.vo.base.ResultDataVO;
import cn.zipworld.cloud.product.business.recycle.product.RecycleProductBusiness;

import cn.zipworld.cloud.product.entity.recycle.product.RecycleProduct;
import cn.zipworld.cloud.product.entity.recycle.product.RecycleProductSelectReq;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Api(description = "成品接口",tags = "recycle/product")
@RestController("recycle/product")
@RequestMapping("recycle/product")
public class RecycleProductController {

    @Autowired
    private RecycleProductBusiness recycleProductBussiness;

    @ApiOperation(value = "测试")
    @GetMapping("/test")
    public String test() {
        //return "outline当前时间："+  DateTimeUtil.getDateTime()+"，端口：" + port;
        return "test1122333";
    }

    @ApiOperation(value = "获取")
    @AuthToken
    @GetMapping("{id}")
    public ResultDataVO<RecycleProduct> get(@PathVariable Long id){
        RecycleProduct recycleProduct = (RecycleProduct)recycleProductBussiness.selectByPrimaryKey(id);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }
    @ApiOperation(value = "通过成品编号获取商品信息（扫描出库）")
    @AuthToken
    @GetMapping("getByCode/{code}")
    public ResultDataVO<RecycleProduct> getByCode(@PathVariable String code){
        RecycleProductSelectReq req = new RecycleProductSelectReq();
        req.setCode(code);
        List<RecycleProduct> list = recycleProductBussiness.select(req);
        if (list!=null && list.size()>0)
            return ResultDataVO.newInstanceIsOK(list.get(0));
        else
            return ResultDataVO.newInstanceIsOK(null);
    }
    @ApiOperation(value = "获取列表")
    @AuthToken
    @GetMapping("list")
    public ResultDataVO<PageInfo<RecycleProduct>> list( RecycleProductSelectReq req,
                                               @ApiIgnore @CurrentUser UserContext userContext){
        PageInfo<RecycleProduct> recycleProduct = recycleProductBussiness.selectPage(req);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }

    @ApiOperation(value = "添加")
    @AuthToken
    @PostMapping
    public ResultDataVO<RecycleProduct> insertSelective(@RequestBody RecycleProduct req,
                                                        @ApiIgnore @CurrentUser UserContext userContext){
        req.setCreateBy(userContext.getId().toString());
        req.setCreateDate(LocalDateTime.now());
        recycleProductBussiness.insertSelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }

    @ApiOperation(value = "修改")
    @AuthToken
    @PutMapping
    public ResultDataVO<RecycleProduct> updateByPrimaryKeySelective(@RequestBody RecycleProduct req,
                                                                    @ApiIgnore @CurrentUser UserContext userContext){
        req.setUpdateBy(userContext.getId().toString());
        req.setUpdateDate(LocalDateTime.now());
        recycleProductBussiness.updateByPrimaryKeySelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }
}
