package cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo;

import cn.idev.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;


@Schema(description = "管理后台 - 瑶川堂技师简要信息 Response VO")
@Data
public class TherapistSimpleRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5277")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "技师状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("技师状态")
    private Integer status;
}
