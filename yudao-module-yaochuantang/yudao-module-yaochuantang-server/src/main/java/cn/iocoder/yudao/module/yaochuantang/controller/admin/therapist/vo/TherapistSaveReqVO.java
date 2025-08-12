package cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 瑶川堂技师新增/修改 Request VO")
@Data
public class TherapistSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5277")
    private Long id;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @NotEmpty(message = "姓名不能为空")
    private String name;

    @Schema(description = "简介")
    private String introduction;

    @Schema(description = "技师 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "技师 logo不能为空")
    private String logo;

    @Schema(description = "擅长项目", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "擅长项目不能为空")
    private String focusProject;

    @Schema(description = "所属门店", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "所属门店不能为空")
    private String baseShop;

    @Schema(description = "技师状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotNull(message = "技师状态不能为空")
    private Integer status;

}