package cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 瑶川堂预约记录新增/修改 Request VO")
@Data
public class AppointmentSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "28907")
    private Long id;

    @Schema(description = "预约ID", requiredMode = Schema.RequiredMode.REQUIRED)
    private String orderNumber;

    @Schema(description = "用户名称", requiredMode = Schema.RequiredMode.REQUIRED, example = "赵六")
    @NotEmpty(message = "用户名称不能为空")
    private String clientName;

    @Schema(description = "预约项目", requiredMode = Schema.RequiredMode.REQUIRED, example = "28645")
    @NotNull(message = "预约项目不能为空")
    private Long projectId;

    @Schema(description = "门店", requiredMode = Schema.RequiredMode.REQUIRED, example = "6458")
    @NotNull(message = "门店不能为空")
    private Long shopId;

    @Schema(description = "健康管理师", requiredMode = Schema.RequiredMode.REQUIRED, example = "2235")
    @NotNull(message = "健康管理师不能为空")
    private Long therapistId;

    @Schema(description = "开始时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "开始时间不能为空")
    private LocalDateTime startTime;

    @Schema(description = "预计结束时间", requiredMode = Schema.RequiredMode.REQUIRED)
    private LocalDateTime estimatedEndTime;

    @Schema(description = "预约状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    private Integer status;

}