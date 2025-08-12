package cn.iocoder.yudao.module.yaochuantang.service.massageproject;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 瑶川堂项目 Service 接口
 *
 * @author young
 */
public interface MassageProjectService {

    /**
     * 创建瑶川堂项目
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMassageProject(@Valid MassageProjectSaveReqVO createReqVO);

    /**
     * 更新瑶川堂项目
     *
     * @param updateReqVO 更新信息
     */
    void updateMassageProject(@Valid MassageProjectSaveReqVO updateReqVO);

    /**
     * 删除瑶川堂项目
     *
     * @param id 编号
     */
    void deleteMassageProject(Long id);

    /**
    * 批量删除瑶川堂项目
    *
    * @param ids 编号
    */
    void deleteMassageProjectListByIds(List<Long> ids);

    /**
     * 获得瑶川堂项目
     *
     * @param id 编号
     * @return 瑶川堂项目
     */
    MassageProjectDO getMassageProject(Long id);

    /**
     * 获得瑶川堂项目分页
     *
     * @param pageReqVO 分页查询
     * @return 瑶川堂项目分页
     */
    PageResult<MassageProjectDO> getMassageProjectPage(MassageProjectPageReqVO pageReqVO);

    /**
     * 根据状态获取项目列表数据
     *
     * @param status 状态
     * @return 自提门店列表
     */
    List<MassageProjectDO> getMassageProjectListByStatus(Integer status);

}