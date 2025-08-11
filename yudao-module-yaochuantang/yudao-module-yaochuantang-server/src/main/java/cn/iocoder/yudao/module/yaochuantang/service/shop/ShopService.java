package cn.iocoder.yudao.module.yaochuantang.service.shop;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

/**
 * 瑶川堂门店 Service 接口
 *
 * @author young
 */
public interface ShopService {

    /**
     * 创建瑶川堂门店
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createShop(@Valid ShopSaveReqVO createReqVO);

    /**
     * 更新瑶川堂门店
     *
     * @param updateReqVO 更新信息
     */
    void updateShop(@Valid ShopSaveReqVO updateReqVO);

    /**
     * 删除瑶川堂门店
     *
     * @param id 编号
     */
    void deleteShop(Long id);

    /**
    * 批量删除瑶川堂门店
    *
    * @param ids 编号
    */
    void deleteShopListByIds(List<Long> ids);

    /**
     * 获得瑶川堂门店
     *
     * @param id 编号
     * @return 瑶川堂门店
     */
    ShopDO getShop(Long id);

    /**
     * 获得瑶川堂门店分页
     *
     * @param pageReqVO 分页查询
     * @return 瑶川堂门店分页
     */
    PageResult<ShopDO> getShopPage(ShopPageReqVO pageReqVO);

}