package cn.iocoder.yudao.module.yaochuantang.dal.mysql.therapist;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist.TherapistDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo.*;

/**
 * 瑶川堂技师 Mapper
 *
 * @author young
 */
@Mapper
public interface TherapistMapper extends BaseMapperX<TherapistDO> {

    default PageResult<TherapistDO> selectPage(TherapistPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<TherapistDO>()
                .likeIfPresent(TherapistDO::getName, reqVO.getName())
                .likeIfPresent(TherapistDO::getFocusProject, reqVO.getFocusProject())
                .likeIfPresent(TherapistDO::getBaseShop, reqVO.getBaseShop())
                .eqIfPresent(TherapistDO::getStatus, reqVO.getStatus())
                .orderByDesc(TherapistDO::getId));
    }

    default List<TherapistDO> selectByStatus(Integer status) {
        return selectList(TherapistDO::getStatus, status);
    }

    default List<TherapistDO> selectNameListByIds(Set<Long> Ids) {
        return  selectList(
                new LambdaQueryWrapperX<TherapistDO>()
                        .in(TherapistDO::getId, Ids)
                        .select(TherapistDO::getId, TherapistDO::getName) // 只查必要字段
        );
    }

}