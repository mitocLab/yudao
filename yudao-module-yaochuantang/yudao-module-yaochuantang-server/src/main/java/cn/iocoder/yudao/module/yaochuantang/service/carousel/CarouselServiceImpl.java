package cn.iocoder.yudao.module.yaochuantang.service.carousel;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.carousel.CarouselDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.yaochuantang.dal.mysql.carousel.CarouselMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.yaochuantang.enums.ErrorCodeConstants.*;

/**
 * 瑶川堂轮播图 Service 实现类
 *
 * @author young
 */
@Slf4j
@Service
@Validated
public class CarouselServiceImpl implements CarouselService {

    @Resource
    private CarouselMapper carouselMapper;

    @Override
    public Long createCarousel(CarouselSaveReqVO createReqVO) {
        // 插入
        CarouselDO carousel = BeanUtils.toBean(createReqVO, CarouselDO.class);
        carouselMapper.insert(carousel);

        // 返回
        return carousel.getId();
    }

    @Override
    public void updateCarousel(CarouselSaveReqVO updateReqVO) {
        // 校验存在
        validateCarouselExists(updateReqVO.getId());
        // 更新
        CarouselDO updateObj = BeanUtils.toBean(updateReqVO, CarouselDO.class);
        carouselMapper.updateById(updateObj);
    }

    @Override
    public void deleteCarousel(Long id) {
        // 校验存在
        validateCarouselExists(id);
        // 删除
        carouselMapper.deleteById(id);
    }

    @Override
        public void deleteCarouselListByIds(List<Long> ids) {
        // 删除
        carouselMapper.deleteByIds(ids);
        }


    private void validateCarouselExists(Long id) {
        if (carouselMapper.selectById(id) == null) {
            throw exception(CAROUSEL_NOT_EXISTS);
        }
    }

    @Override
    public CarouselDO getCarousel(Long id) {
        return carouselMapper.selectById(id);
    }

    @Override
    public PageResult<CarouselDO> getCarouselPage(CarouselPageReqVO pageReqVO) {
        return carouselMapper.selectPage(pageReqVO);
    }

}