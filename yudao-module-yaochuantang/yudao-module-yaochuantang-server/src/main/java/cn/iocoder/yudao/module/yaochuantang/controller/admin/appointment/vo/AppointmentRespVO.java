package cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.*;

@Schema(description = "管理后台 - 瑶川堂预约记录 Response VO")
@Data
@ExcelIgnoreUnannotated
public class AppointmentRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28907")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "预约ID", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("预约ID")
    private String orderNumber;

    @Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @ExcelProperty("用户名称")
    private String clientName;

    @Schema(description = "预约项目", requiredMode = Schema.RequiredMode.REQUIRED, example = "28645")
    private Long projectId;
    @Schema(description = "预约项目", requiredMode = Schema.RequiredMode.REQUIRED, example = "28645")
    @ExcelProperty("预约项目")
    private String projectName;

    @Schema(description = "门店", requiredMode = Schema.RequiredMode.REQUIRED, example = "6458")
    private Long shopId;
    @Schema(description = "门店", requiredMode = Schema.RequiredMode.REQUIRED, example = "6458")
    @ExcelProperty("门店")
    private String shopName;

    @Schema(description = "健康管理师", requiredMode = Schema.RequiredMode.REQUIRED, example = "2235")
    private Long therapistId;
    @Schema(description = "健康管理师", requiredMode = Schema.RequiredMode.REQUIRED, example = "2235")
    @ExcelProperty("健康管理师")
    private String therapistName;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("开始时间")
    private LocalDateTime startTime;

    @Schema(description = "预计结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("预计结束时间")
    private LocalDateTime estimatedEndTime;

    @Schema(description = "预约状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;
    @Schema(description = "预约状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("预约状态")
    private String statusDesc;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}