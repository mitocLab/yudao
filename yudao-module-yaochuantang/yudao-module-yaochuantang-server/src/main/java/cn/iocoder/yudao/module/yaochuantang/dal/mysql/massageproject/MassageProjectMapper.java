package cn.iocoder.yudao.module.yaochuantang.dal.mysql.massageproject;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo.*;

/**
 * 瑶川堂项目 Mapper
 *
 * @author young
 */
@Mapper
public interface MassageProjectMapper extends BaseMapperX<MassageProjectDO> {

    default PageResult<MassageProjectDO> selectPage(MassageProjectPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MassageProjectDO>()
                .likeIfPresent(MassageProjectDO::getName, reqVO.getName())
                .eqIfPresent(MassageProjectDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(MassageProjectDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MassageProjectDO::getId));
    }

    default List<MassageProjectDO> selectListByStatus(Integer status) {
        return selectList(MassageProjectDO::getStatus, status);
    }

}