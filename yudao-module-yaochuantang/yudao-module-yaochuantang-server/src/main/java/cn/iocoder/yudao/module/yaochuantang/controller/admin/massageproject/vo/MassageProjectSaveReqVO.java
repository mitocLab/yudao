package cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 瑶川堂项目新增/修改 Request VO")
@Data
public class MassageProjectSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "17556")
    private Long id;

    @Schema(description = "项目名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "项目名称不能为空")
    private String name;

    @Schema(description = "项目简介")
    private String introduction;

    @Schema(description = "项目流程")
    private String process;

    @Schema(description = "项目 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "项目 logo不能为空")
    private String logo;

    @Schema(description = "项目状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "项目状态不能为空")
    private Integer status;

    @Schema(description = "项目时长", requiredMode = Schema.RequiredMode.REQUIRED, example = "1.5")
    @NotNull(message = "项目时长不能为空")
    private Integer duration;

}