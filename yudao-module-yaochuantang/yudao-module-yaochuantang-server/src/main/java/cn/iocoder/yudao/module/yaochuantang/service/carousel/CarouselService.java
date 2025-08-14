package cn.iocoder.yudao.module.yaochuantang.service.carousel;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.carousel.CarouselDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 瑶川堂轮播图 Service 接口
 *
 * @author young
 */
public interface CarouselService {

    /**
     * 创建瑶川堂轮播图
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCarousel(@Valid CarouselSaveReqVO createReqVO);

    /**
     * 更新瑶川堂轮播图
     *
     * @param updateReqVO 更新信息
     */
    void updateCarousel(@Valid CarouselSaveReqVO updateReqVO);

    /**
     * 删除瑶川堂轮播图
     *
     * @param id 编号
     */
    void deleteCarousel(Long id);

    /**
    * 批量删除瑶川堂轮播图
    *
    * @param ids 编号
    */
    void deleteCarouselListByIds(List<Long> ids);

    /**
     * 获得瑶川堂轮播图
     *
     * @param id 编号
     * @return 瑶川堂轮播图
     */
    CarouselDO getCarousel(Long id);

    /**
     * 获得瑶川堂轮播图分页
     *
     * @param pageReqVO 分页查询
     * @return 瑶川堂轮播图分页
     */
    PageResult<CarouselDO> getCarouselPage(CarouselPageReqVO pageReqVO);

}