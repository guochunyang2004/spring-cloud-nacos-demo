package cn.zipworld.cloud.user.web.controller.station;


import cn.zipworld.cloud.common.vo.base.ResultDataVO;
import cn.zipworld.cloud.user.business.station.StationInfoBusiness;
import cn.zipworld.cloud.user.entity.station.StationInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(description = "",tags = "stationinfo")
@Slf4j
@RestController()
@RequestMapping("/stationinfo")
public class StationInfoController {

    @Autowired
    private StationInfoBusiness stationInfoBusiness;

    @ApiOperation(value = "获取当前登录人的站点列表")
    @GetMapping("/select")
    public ResultDataVO<List<StationInfo>> select() {
        List<StationInfo> list = (List<StationInfo>)stationInfoBusiness.selectByPrimaryKey(1L);
        return ResultDataVO.newInstanceIsOK(list);
    }
}
