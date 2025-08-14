package cn.iocoder.yudao.module.yaochuantang.convert.therapist;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo.TherapistSimpleRespVO;
import cn.iocoder.yudao.module.yaochuantang.convert.therapist.TherapistConvert;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist.TherapistDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TherapistConvert {
    TherapistConvert INSTANCE = Mappers.getMapper(TherapistConvert.class);

    List<TherapistSimpleRespVO> convertList1(List<TherapistDO> list);
}
