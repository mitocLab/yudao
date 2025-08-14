package cn.iocoder.yudao.module.yaochuantang.enums;
import cn.iocoder.yudao.framework.common.exception.ErrorCode;


public interface ErrorCodeConstants {
    ErrorCode SHOP_NOT_EXISTS = new ErrorCode(2_001_001_000, "门店不存在");

    ErrorCode MASSAGE_PROJECT_NOT_EXISTS = new ErrorCode(2_002_001_000, "项目不存在");
    ErrorCode MASSAGE_PROJECT_DURATION_NOT_EXISTS = new ErrorCode(2_002_001_001, "项目时长不存在");

    ErrorCode THERAPIST_NOT_EXISTS = new ErrorCode(2_003_001_000, "技师不存在");

    ErrorCode CAROUSEL_NOT_EXISTS = new ErrorCode(2_004_001_000, "轮播图不存在");

    ErrorCode APPOINTMENT_NOT_EXISTS = new ErrorCode(2_005_001_000, "预约记录不存在");
    ErrorCode APPOINTMENT_TIME_OR_PROJECT_REQUIRED = new ErrorCode(2_005_001_001, "预约记录开始时间与项目参数异常");
}