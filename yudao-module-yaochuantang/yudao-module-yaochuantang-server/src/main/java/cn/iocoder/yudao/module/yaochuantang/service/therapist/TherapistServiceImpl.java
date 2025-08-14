package cn.iocoder.yudao.module.yaochuantang.service.therapist;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist.TherapistDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.yaochuantang.dal.mysql.therapist.TherapistMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.yaochuantang.enums.ErrorCodeConstants.*;

/**
 * 瑶川堂技师 Service 实现类
 *
 * @author young
 */
@Service
@Validated
public class TherapistServiceImpl implements TherapistService {

    @Resource
    private TherapistMapper therapistMapper;

    @Override
    public Long createTherapist(TherapistSaveReqVO createReqVO) {
        // 插入
        TherapistDO therapist = BeanUtils.toBean(createReqVO, TherapistDO.class);
        therapistMapper.insert(therapist);

        // 返回
        return therapist.getId();
    }

    @Override
    public void updateTherapist(TherapistSaveReqVO updateReqVO) {
        // 校验存在
        validateTherapistExists(updateReqVO.getId());
        // 更新
        TherapistDO updateObj = BeanUtils.toBean(updateReqVO, TherapistDO.class);
        therapistMapper.updateById(updateObj);
    }

    @Override
    public void deleteTherapist(Long id) {
        // 校验存在
        validateTherapistExists(id);
        // 删除
        therapistMapper.deleteById(id);
    }

    @Override
    public void deleteTherapistListByIds(List<Long> ids) {
        // 删除
        therapistMapper.deleteByIds(ids);
    }


    private void validateTherapistExists(Long id) {
        if (therapistMapper.selectById(id) == null) {
            throw exception(THERAPIST_NOT_EXISTS);
        }
    }

    @Override
    public TherapistDO getTherapist(Long id) {
        return therapistMapper.selectById(id);
    }

    @Override
    public PageResult<TherapistDO> getTherapistPage(TherapistPageReqVO pageReqVO) {
        return therapistMapper.selectPage(pageReqVO);
    }

    @Override
    public List<TherapistDO> getTherapistListByStatus(Integer status) {
        return therapistMapper.selectByStatus(status);
    }

    @Override
    public Map<Long, String> getTherapistNameMap(Set<Long> therapistIds) {
        if (therapistIds.isEmpty()) {
            return Collections.emptyMap();
        }
        // 查询项目列表
        List<TherapistDO> therapists = therapistMapper.selectNameListByIds(therapistIds);
        // 转为 ID → 名称的 Map
        return therapists.stream()
                .collect(Collectors.toMap(
                        TherapistDO::getId,
                        TherapistDO::getName,
                        (k1, k2) -> k1
                ));
    }

}