package cn.iocoder.yudao.module.yaochuantang.service.appointment;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.iocoder.yudao.module.yaochuantang.convert.Appointment.AppointmentConvert;
import cn.iocoder.yudao.module.yaochuantang.convert.massageProject.MassageProjectConvert;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import cn.iocoder.yudao.module.yaochuantang.service.massageproject.MassageProjectService;
import cn.iocoder.yudao.module.yaochuantang.service.shop.ShopService;
import cn.iocoder.yudao.module.yaochuantang.service.therapist.TherapistService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.yaochuantang.dal.mysql.appointment.AppointmentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.yaochuantang.enums.ErrorCodeConstants.*;

/**
 * 瑶川堂预约记录 Service 实现类
 *
 * @author young
 */
@Service
@Validated
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private MassageProjectService massageProjectService; // 项目 Service
    @Resource
    private ShopService shopService; // 门店 Service
    @Resource
    private TherapistService therapistService; // 技师 Service

    @Override
    public Long createAppointment(AppointmentSaveReqVO createReqVO) {
        if (createReqVO.getStartTime() == null || createReqVO.getProjectId() == null) {
            throw exception(APPOINTMENT_TIME_OR_PROJECT_REQUIRED);
        }

        // 生成预约ID
        String prefix = "AP" + DateTime.now().toString("yyyyMMddHHmmss");
        String appointmentId = prefix + RandomUtil.randomNumbers(4);

        // 处理预计结束时间
        MassageProjectDO massageProject = massageProjectService.getMassageProject(createReqVO.getProjectId());
        if (massageProject.getId() == null) {
            throw exception(MASSAGE_PROJECT_NOT_EXISTS);
        }
        if (massageProject.getDuration() == null) {
            throw exception(MASSAGE_PROJECT_DURATION_NOT_EXISTS);
        }
        // 根据项目的开始时间，计算结束时间
        LocalDateTime endTime = createReqVO.getStartTime().plusMinutes(massageProject.getDuration());


        // 插入
        AppointmentDO appointment = BeanUtils.toBean(createReqVO, AppointmentDO.class);
        appointment.setOrderNumber(appointmentId);
        appointment.setEstimatedEndTime(endTime);
        appointment.setStatus(0);
        appointmentMapper.insert(appointment);

        // 返回
        return appointment.getId();
    }

    @Override
    public void updateAppointment(AppointmentSaveReqVO updateReqVO) {
        // 校验存在
        validateAppointmentExists(updateReqVO.getId());
        // 更新
        AppointmentDO updateObj = BeanUtils.toBean(updateReqVO, AppointmentDO.class);
        appointmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteAppointment(Long id) {
        // 校验存在
        validateAppointmentExists(id);
        // 删除
        appointmentMapper.deleteById(id);
    }

    @Override
    public void deleteAppointmentListByIds(List<Long> ids) {
        // 删除
        appointmentMapper.deleteByIds(ids);
    }


    private void validateAppointmentExists(Long id) {
        if (appointmentMapper.selectById(id) == null) {
            throw exception(APPOINTMENT_NOT_EXISTS);
        }
    }

    @Override
    public AppointmentDO getAppointment(Long id) {
        return appointmentMapper.selectById(id);
    }

    @Override
    public PageResult<AppointmentRespVO> getAppointmentPage(AppointmentPageReqVO pageReqVO) {
        PageResult<AppointmentDO> appointmentPage =  appointmentMapper.selectPage(pageReqVO);
        List<AppointmentDO> appointmentList = appointmentPage.getList();
        if (appointmentList.isEmpty()) {
            return PageResult.empty(); // 无数据，直接返回空分页
        }

        Set<Long> projectIds = appointmentList.stream()
                .map(AppointmentDO::getProjectId)
                .collect(Collectors.toSet());
        Map<Long, String> projectId2NameMap = massageProjectService.getProjectNameMap(projectIds);

        Set<Long> shopIds = appointmentList.stream()
                .map(AppointmentDO::getShopId)
                .collect(Collectors.toSet());
        Map<Long, String> shopId2NameMap = shopService.getShopNameMap(shopIds);

        Set<Long> therapistIds = appointmentList.stream()
                .map(AppointmentDO::getTherapistId)
                .collect(Collectors.toSet());
        Map<Long, String> therapistId2NameMap = therapistService.getTherapistNameMap(therapistIds);

        // 4. 构建分页结果
        return new PageResult<>(
                AppointmentConvert.INSTANCE.convertListWithRelation(appointmentList, projectId2NameMap, shopId2NameMap, therapistId2NameMap),
                appointmentPage.getTotal()
        );
    }

}