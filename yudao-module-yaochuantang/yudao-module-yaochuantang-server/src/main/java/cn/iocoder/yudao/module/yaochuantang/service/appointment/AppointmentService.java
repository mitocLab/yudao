package cn.iocoder.yudao.module.yaochuantang.service.appointment;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 瑶川堂预约记录 Service 接口
 *
 * @author young
 */
public interface AppointmentService {

    /**
     * 创建瑶川堂预约记录
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAppointment(@Valid AppointmentSaveReqVO createReqVO);

    /**
     * 更新瑶川堂预约记录
     *
     * @param updateReqVO 更新信息
     */
    void updateAppointment(@Valid AppointmentSaveReqVO updateReqVO);

    /**
     * 删除瑶川堂预约记录
     *
     * @param id 编号
     */
    void deleteAppointment(Long id);

    /**
    * 批量删除瑶川堂预约记录
    *
    * @param ids 编号
    */
    void deleteAppointmentListByIds(List<Long> ids);

    /**
     * 获得瑶川堂预约记录
     *
     * @param id 编号
     * @return 瑶川堂预约记录
     */
    AppointmentDO getAppointment(Long id);

    /**
     * 获得瑶川堂预约记录分页
     *
     * @param pageReqVO 分页查询
     * @return 瑶川堂预约记录分页
     */
    PageResult<AppointmentRespVO> getAppointmentPage(AppointmentPageReqVO pageReqVO);

}