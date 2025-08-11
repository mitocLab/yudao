package cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import java.time.LocalTime;

@Schema(description = "管理后台 - 瑶川堂门店新增/修改 Request VO")
@Data
public class ShopSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12089")
    private Long id;

    @Schema(description = "门店名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @NotEmpty(message = "门店名称不能为空")
    private String name;

    @Schema(description = "门店简介")
    private String introduction;

    @Schema(description = "门店手机", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "门店手机不能为空")
    private String phone;

    @Schema(description = "区域编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "22011")
    @NotNull(message = "区域编号不能为空")
    private Integer areaId;

    @Schema(description = "门店详细地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "门店详细地址不能为空")
    private String detailAddress;

    @Schema(description = "门店 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "门店 logo不能为空")
    private String logo;

    @Schema(description = "营业开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "营业开始时间不能为空")
    private LocalTime openingTime;

    @Schema(description = "营业结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "营业结束时间不能为空")
    private LocalTime closingTime;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "纬度不能为空")
    private Double latitude;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "经度不能为空")
    private Double longitude;

    @Schema(description = "核销用户编号数组")
    private String verifyUserIds;

    @Schema(description = "门店状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "门店状态不能为空")
    private Integer status;

}