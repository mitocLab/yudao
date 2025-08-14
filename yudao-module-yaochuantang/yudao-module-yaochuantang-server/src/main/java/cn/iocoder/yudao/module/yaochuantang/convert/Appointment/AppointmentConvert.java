package cn.iocoder.yudao.module.yaochuantang.convert.Appointment;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo.AppointmentRespVO;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.module.yaochuantang.enums.appointment.AppointmentStatusEnum;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.stream.Collectors;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppointmentConvert {
    AppointmentConvert INSTANCE = Mappers.getMapper(AppointmentConvert.class);

    AppointmentRespVO convert(AppointmentDO bean);

    default AppointmentRespVO convertWithRelation(
            AppointmentDO appointmentDO,
            Map<Long, String> projectId2NameMap,
            Map<Long, String> shopId2NameMap,
            Map<Long, String> therapistId2NameMap) {
        AppointmentRespVO respVO = convert(appointmentDO);
        // 填充关联名称
        respVO.setProjectName(projectId2NameMap.getOrDefault(appointmentDO.getProjectId(), "未知项目"));
        respVO.setShopName(shopId2NameMap.getOrDefault(appointmentDO.getShopId(), "未知门店"));
        respVO.setTherapistName(therapistId2NameMap.getOrDefault(appointmentDO.getTherapistId(), "未知技师"));
        // 状态码转描述
        respVO.setStatusDesc(AppointmentStatusEnum.getNameByStatus(appointmentDO.getStatus()));
        return respVO;
    }

    default List<AppointmentRespVO> convertListWithRelation(
            List<AppointmentDO> appointmentList,
            Map<Long, String> projectId2NameMap,
            Map<Long, String> shopId2NameMap,
            Map<Long, String> therapistId2NameMap) {
        return appointmentList.stream()
                .map(appointment -> convertWithRelation(
                        appointment,
                        projectId2NameMap,
                        shopId2NameMap,
                        therapistId2NameMap
                ))
                .collect(Collectors.toList());
    }
}
