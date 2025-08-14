package cn.iocoder.yudao.module.yaochuantang.dal.mysql.carousel;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.carousel.CarouselDO;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo.*;

/**
 * 瑶川堂轮播图 Mapper
 *
 * @author young
 */
@Mapper
public interface CarouselMapper extends BaseMapperX<CarouselDO> {

    default PageResult<CarouselDO> selectPage(CarouselPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CarouselDO>()
                .eqIfPresent(CarouselDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CarouselDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CarouselDO::getId));
    }

}