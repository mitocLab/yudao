package cn.iocoder.yudao.module.yaochuantang.dal.mysql.shop;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo.*;

/**
 * 瑶川堂门店 Mapper
 *
 * @author young
 */
@Mapper
public interface ShopMapper extends BaseMapperX<ShopDO> {

    default PageResult<ShopDO> selectPage(ShopPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ShopDO>()
                .likeIfPresent(ShopDO::getName, reqVO.getName())
                .eqIfPresent(ShopDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(ShopDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ShopDO::getId));
    }

    default List<ShopDO> selectByStatus(Integer status) {
        return selectList(ShopDO::getStatus, status);
    }

}