package cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.*;

@Schema(description = "管理后台 - 瑶川堂技师 Response VO")
@Data
@ExcelIgnoreUnannotated
public class TherapistRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "5277")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "芋艿")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "简介")
    @ExcelProperty("简介")
    private String introduction;

    @Schema(description = "技师 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("技师 logo")
    private String logo;

    @Schema(description = "擅长项目", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("擅长项目")
    private String focusProject;

    @Schema(description = "所属门店", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("所属门店")
    private String baseShop;

    @Schema(description = "技师状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("技师状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}