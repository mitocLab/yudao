package cn.iocoder.yudao.module.yaochuantang.enums;
import cn.iocoder.yudao.framework.common.exception.ErrorCode;


public interface ErrorCodeConstants {
    ErrorCode SHOP_NOT_EXISTS = new ErrorCode(2_001_001_000, "瑶川堂门店不存在");
    ErrorCode MASSAGE_PROJECT_NOT_EXISTS = new ErrorCode(2_002_001_000, "瑶川堂项目不存在");
    ErrorCode THERAPIST_NOT_EXISTS = new ErrorCode(2_003_001_000, "瑶川堂技师不存在");
}