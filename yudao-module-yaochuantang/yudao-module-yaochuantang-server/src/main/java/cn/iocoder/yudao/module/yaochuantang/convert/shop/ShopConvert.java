package cn.iocoder.yudao.module.yaochuantang.convert.shop;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo.ShopSimpleRespVO;
import cn.iocoder.yudao.module.yaochuantang.convert.shop.ShopConvert;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ShopConvert {
    ShopConvert INSTANCE = Mappers.getMapper(ShopConvert.class);

    List<ShopSimpleRespVO> convertList1(List<ShopDO> list);
}
