package cn.iocoder.yudao.module.yaochuantang.service.massageproject;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.yaochuantang.dal.mysql.massageproject.MassageProjectMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.module.yaochuantang.enums.ErrorCodeConstants.*;

/**
 * 瑶川堂项目 Service 实现类
 *
 * @author young
 */
@Service
@Validated
public class MassageProjectServiceImpl implements MassageProjectService {

    @Resource
    private MassageProjectMapper massageProjectMapper;

    @Override
    public Long createMassageProject(MassageProjectSaveReqVO createReqVO) {
        // 插入
        MassageProjectDO massageProject = BeanUtils.toBean(createReqVO, MassageProjectDO.class);
        massageProjectMapper.insert(massageProject);

        // 返回
        return massageProject.getId();
    }

    @Override
    public void updateMassageProject(MassageProjectSaveReqVO updateReqVO) {
        // 校验存在
        validateMassageProjectExists(updateReqVO.getId());
        // 更新
        MassageProjectDO updateObj = BeanUtils.toBean(updateReqVO, MassageProjectDO.class);
        massageProjectMapper.updateById(updateObj);
    }

    @Override
    public void deleteMassageProject(Long id) {
        // 校验存在
        validateMassageProjectExists(id);
        // 删除
        massageProjectMapper.deleteById(id);
    }

    @Override
        public void deleteMassageProjectListByIds(List<Long> ids) {
        // 删除
        massageProjectMapper.deleteByIds(ids);
        }


    private void validateMassageProjectExists(Long id) {
        if (massageProjectMapper.selectById(id) == null) {
            throw exception(MASSAGE_PROJECT_NOT_EXISTS);
        }
    }

    @Override
    public MassageProjectDO getMassageProject(Long id) {
        return massageProjectMapper.selectById(id);
    }

    @Override
    public PageResult<MassageProjectDO> getMassageProjectPage(MassageProjectPageReqVO pageReqVO) {
        return massageProjectMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MassageProjectDO> getMassageProjectListByStatus(Integer status) {
        return massageProjectMapper.selectListByStatus(status);
    }

    @Override
    public Map<Long, String> getProjectNameMap(Set<Long> projectIds) {
        if (projectIds.isEmpty()) {
            return Collections.emptyMap();
        }
        // 查询项目列表
        List<MassageProjectDO> projects = massageProjectMapper.selectNameListByIds(projectIds);
        // 转为 ID → 名称的 Map
        return projects.stream()
                .collect(Collectors.toMap(
                        MassageProjectDO::getId,
                        MassageProjectDO::getName,
                        (k1, k2) -> k1
                ));
    }
}