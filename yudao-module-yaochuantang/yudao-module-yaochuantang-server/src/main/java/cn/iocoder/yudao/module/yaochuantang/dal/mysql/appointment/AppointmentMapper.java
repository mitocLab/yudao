package cn.iocoder.yudao.module.yaochuantang.dal.mysql.appointment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment.AppointmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo.*;

/**
 * 瑶川堂预约记录 Mapper
 *
 * @author young
 */
@Mapper
public interface AppointmentMapper extends BaseMapperX<AppointmentDO> {

    default PageResult<AppointmentDO> selectPage(AppointmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AppointmentDO>()
                .eqIfPresent(AppointmentDO::getOrderNumber, reqVO.getOrderNumber())
                .likeIfPresent(AppointmentDO::getClientName, reqVO.getClientName())
                .eqIfPresent(AppointmentDO::getProjectId, reqVO.getProjectId())
                .eqIfPresent(AppointmentDO::getShopId, reqVO.getShopId())
                .eqIfPresent(AppointmentDO::getTherapistId, reqVO.getTherapistId())
                .betweenIfPresent(AppointmentDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(AppointmentDO::getEstimatedEndTime, reqVO.getEstimatedEndTime())
                .eqIfPresent(AppointmentDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AppointmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AppointmentDO::getId));
    }

}