package cn.iocoder.yudao.module.yaochuantang.service.therapist;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist.TherapistDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 瑶川堂技师 Service 接口
 *
 * @author young
 */
public interface TherapistService {

    /**
     * 创建瑶川堂技师
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createTherapist(@Valid TherapistSaveReqVO createReqVO);

    /**
     * 更新瑶川堂技师
     *
     * @param updateReqVO 更新信息
     */
    void updateTherapist(@Valid TherapistSaveReqVO updateReqVO);

    /**
     * 删除瑶川堂技师
     *
     * @param id 编号
     */
    void deleteTherapist(Long id);

    /**
    * 批量删除瑶川堂技师
    *
    * @param ids 编号
    */
    void deleteTherapistListByIds(List<Long> ids);

    /**
     * 获得瑶川堂技师
     *
     * @param id 编号
     * @return 瑶川堂技师
     */
    TherapistDO getTherapist(Long id);

    /**
     * 获得瑶川堂技师分页
     *
     * @param pageReqVO 分页查询
     * @return 瑶川堂技师分页
     */
    PageResult<TherapistDO> getTherapistPage(TherapistPageReqVO pageReqVO);

    /**
     * 获取技师简要信息列表
     *
     * @param status 状态
     * @return 简要信息列表
     */
     List<TherapistDO> getTherapistListByStatus(Integer status);

    /**
     *
     * @param therapistIds
     * @return id->name Mapping
     */
    Map<Long, String> getTherapistNameMap(Set<Long> therapistIds);
}