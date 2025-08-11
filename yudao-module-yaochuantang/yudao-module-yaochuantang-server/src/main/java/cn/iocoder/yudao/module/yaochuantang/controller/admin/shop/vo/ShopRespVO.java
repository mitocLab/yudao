package cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import cn.idev.excel.annotation.*;

@Schema(description = "管理后台 - 瑶川堂门店 Response VO")
@Data
@ExcelIgnoreUnannotated
public class ShopRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12089")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "门店名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("门店名称")
    private String name;

    @Schema(description = "门店简介")
    @ExcelProperty("门店简介")
    private String introduction;

    @Schema(description = "门店手机", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("门店手机")
    private String phone;

    @Schema(description = "区域编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "22011")
    @ExcelProperty("区域编号")
    private Integer areaId;

    @Schema(description = "门店详细地址", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("门店详细地址")
    private String detailAddress;

    @Schema(description = "门店 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("门店 logo")
    private String logo;

    @Schema(description = "营业开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("营业开始时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime openingTime;

    @Schema(description = "营业结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("营业结束时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
    private LocalTime closingTime;

    @Schema(description = "纬度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("纬度")
    private Double latitude;

    @Schema(description = "经度", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("经度")
    private Double longitude;

    @Schema(description = "核销用户编号数组")
    @ExcelProperty("核销用户编号数组")
    private String verifyUserIds;

    @Schema(description = "门店状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("门店状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}