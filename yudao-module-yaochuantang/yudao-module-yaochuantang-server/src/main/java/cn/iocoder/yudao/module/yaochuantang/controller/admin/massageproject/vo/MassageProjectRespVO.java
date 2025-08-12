package cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.*;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;

@Schema(description = "管理后台 - 瑶川堂项目 Response VO")
@Data
@ExcelIgnoreUnannotated
public class MassageProjectRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17556")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("项目名称")
    private String name;

    @Schema(description = "项目简介")
    @ExcelProperty("项目简介")
    private String introduction;

    @Schema(description = "项目流程")
    @ExcelProperty("项目流程")
    private String process;

    @Schema(description = "项目 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("项目 logo")
    private String logo;

    @Schema(description = "项目状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty(value = "项目状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 DictTypeConstants 枚举类中
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}