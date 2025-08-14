package cn.iocoder.yudao.module.yaochuantang.service.shop;

import cn.hutool.core.collection.CollUtil;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.yaochuantang.dal.mysql.shop.ShopMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.convertList;
import static cn.iocoder.yudao.framework.common.util.collection.CollectionUtils.diffList;
import static cn.iocoder.yudao.module.yaochuantang.enums.ErrorCodeConstants.*;

/**
 * 瑶川堂门店 Service 实现类
 *
 * @author young
 */
@Service
@Validated
public class ShopServiceImpl implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Override
    public Long createShop(ShopSaveReqVO createReqVO) {
        // 插入
        ShopDO shop = BeanUtils.toBean(createReqVO, ShopDO.class);
        shopMapper.insert(shop);

        // 返回
        return shop.getId();
    }

    @Override
    public void updateShop(ShopSaveReqVO updateReqVO) {
        // 校验存在
        validateShopExists(updateReqVO.getId());
        // 更新
        ShopDO updateObj = BeanUtils.toBean(updateReqVO, ShopDO.class);
        shopMapper.updateById(updateObj);
    }

    @Override
    public void deleteShop(Long id) {
        // 校验存在
        validateShopExists(id);
        // 删除
        shopMapper.deleteById(id);
    }

    @Override
        public void deleteShopListByIds(List<Long> ids) {
        // 删除
        shopMapper.deleteByIds(ids);
        }


    private void validateShopExists(Long id) {
        if (shopMapper.selectById(id) == null) {
            throw exception(SHOP_NOT_EXISTS);
        }
    }

    @Override
    public ShopDO getShop(Long id) {
        return shopMapper.selectById(id);
    }

    @Override
    public PageResult<ShopDO> getShopPage(ShopPageReqVO pageReqVO) {
        return shopMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ShopDO> getShopListByStatus(Integer status) {
        return shopMapper.selectByStatus(status);
    }

    @Override
    public Map<Long, String> getShopNameMap(Set<Long> shopIds) {
        if (shopIds.isEmpty()) {
            return Collections.emptyMap();
        }
        // 查询项目列表
        List<ShopDO> shops = shopMapper.selectNameListByIds(shopIds);
        // 转为 ID → 名称的 Map
        return shops.stream()
                .collect(Collectors.toMap(
                        ShopDO::getId,
                        ShopDO::getName,
                        (k1, k2) -> k1
                ));
    }

}