package cn.zipworld.cloud.product.web.controller.station;


import cn.zipworld.cloud.common.entity.auth.AuthToken;
import cn.zipworld.cloud.common.entity.auth.CurrentUser;
import cn.zipworld.cloud.common.entity.auth.UserContext;
import cn.zipworld.cloud.common.vo.base.ResultDataVO;
import cn.zipworld.cloud.product.business.station.delivery.StationDeliveryBusiness;
import cn.zipworld.cloud.product.business.station.delivery.StationDeliveryCommodityBusiness;
import cn.zipworld.cloud.product.entity.station.delivery.StationDelivery;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommodity;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliveryCommoditySelectReq;
import cn.zipworld.cloud.product.entity.station.delivery.StationDeliverySelectReq;
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
@Api(description = "出货商品接口",tags = "station/deliveryCommodity")
@RestController("station/deliveryCommodity")
@RequestMapping("station/deliveryCommodity")
public class StationDeliveryCommodityController {
    @Autowired
    private StationDeliveryCommodityBusiness stationDeliveryCommodityBusiness;


    @ApiOperation(value = "获取")
    @AuthToken
    @GetMapping("{id}")
    public ResultDataVO<StationDeliveryCommodity> get(@PathVariable Long id){
        StationDeliveryCommodity recycleProduct = (StationDeliveryCommodity)stationDeliveryCommodityBusiness.selectByPrimaryKey(id);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }


    @ApiOperation(value = "获取列表")
    @AuthToken
    @GetMapping("selectPage")
    public ResultDataVO<PageInfo<StationDeliveryCommodity>> selectPage(StationDeliveryCommoditySelectReq req,
                                                              @ApiIgnore @CurrentUser UserContext userContext){
        PageInfo<StationDeliveryCommodity> recycleProduct = stationDeliveryCommodityBusiness.selectPage(req);
        return ResultDataVO.newInstanceIsOK(recycleProduct);
    }

    @ApiOperation(value = "添加")
    @AuthToken
    @PostMapping
    public ResultDataVO<StationDeliveryCommodity> insertSelective(@RequestBody StationDeliveryCommodity req,
                                                         @ApiIgnore @CurrentUser UserContext userContext){
        req.setCreateBy(userContext.getId().toString());
        req.setCreateDate(LocalDateTime.now());
        stationDeliveryCommodityBusiness.insertSelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }

    @ApiOperation(value = "修改")
    @AuthToken
    @PutMapping
    public ResultDataVO<StationDeliveryCommodity> updateByPrimaryKeySelective(@RequestBody StationDeliveryCommodity req,
                                                                     @ApiIgnore @CurrentUser UserContext userContext){
        req.setUpdateBy(userContext.getId().toString());
        req.setUpdateDate(LocalDateTime.now());
        stationDeliveryCommodityBusiness.updateByPrimaryKeySelective(req);
        return ResultDataVO.newInstanceIsOK(req);
    }
}
