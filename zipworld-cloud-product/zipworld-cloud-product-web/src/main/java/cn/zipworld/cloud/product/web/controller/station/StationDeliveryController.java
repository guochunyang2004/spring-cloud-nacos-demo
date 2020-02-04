package cn.zipworld.cloud.product.web.controller.station;


import cn.zipworld.cloud.common.entity.auth.AuthToken;
import cn.zipworld.cloud.common.entity.auth.CurrentUser;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.common.vo.base.ResultDataVO;
import cn.zipworld.cloud.product.business.station.delivery.StationDeliveryBusiness;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliverySelectReq;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
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
@Api(description = "出货接口",tags = "station/delivery")
@RestController("station/delivery")
@RequestMapping("station/delivery")
public class StationDeliveryController {
    @Autowired
    private StationDeliveryBusiness stationDeliveryBussiness;


    @ApiOperation(value = "获取")
    @AuthToken
    @GetMapping("{id}")
    public ResultDataVO<StationDelivery> get(@PathVariable Long id){
        StationDelivery recycleProduct = (StationDelivery)stationDeliveryBussiness.selectByPrimaryKey(id);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }


    @ApiOperation(value = "获取列表")
    @AuthToken
    @GetMapping("selectPage")
    public ResultDataVO<PageInfo<StationDelivery>> selectPage(StationDeliverySelectReq req,
                                                       @ApiIgnore @CurrentUser UserContext userContext){
        PageInfo<StationDelivery> recycleProduct = stationDeliveryBussiness.selectPage(req);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }

    @ApiOperation(value = "添加")
    @AuthToken
    @PostMapping
    public ResultDataVO<StationDelivery> insertSelective(@RequestBody StationDelivery req,
                                                        @ApiIgnore @CurrentUser UserContext userContext){
        req.setCreateBy(userContext.getId().toString());
        req.setCreateDate(LocalDateTime.now());
        stationDeliveryBussiness.insertSelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }

    @ApiOperation(value = "修改")
    @AuthToken
    @PutMapping
    public ResultDataVO<StationDelivery> updateByPrimaryKeySelective(@RequestBody StationDelivery req,
                                                                    @ApiIgnore @CurrentUser UserContext userContext){
        req.setUpdateBy(userContext.getId().toString());
        req.setUpdateDate(LocalDateTime.now());
        stationDeliveryBussiness.updateByPrimaryKeySelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }
}
