package cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo;


import cn.idev.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Schema(description = "管理后台 - 自提门店精简信息 Response VO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MassageProjectSimpleRespVO {
    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17556")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "项目状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "项目状态", converter = DictConvert.class)
    private Integer status;
}
