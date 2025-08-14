package cn.iocoder.yudao.module.yaochuantang.convert.massageProject;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo.MassageProjectSimpleRespVO;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MassageProjectConvert {

    MassageProjectConvert INSTANCE = Mappers.getMapper(MassageProjectConvert.class);

    List<MassageProjectSimpleRespVO> convertList1(List<MassageProjectDO> list);
}
