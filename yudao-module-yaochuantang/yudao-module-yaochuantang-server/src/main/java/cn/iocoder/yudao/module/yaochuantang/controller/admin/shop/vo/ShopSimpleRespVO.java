package cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;


@Schema(description = "管理后台 - 瑶川堂门店 简要信息 Response VO")
@Data
public class ShopSimpleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "12089")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "门店名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "王五")
    @ExcelProperty("门店名称")
    private String name;

    @Schema(description = "门店状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("门店状态")
    private Integer status;
}
