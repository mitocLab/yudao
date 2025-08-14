package cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 瑶川堂预约记录分页 Request VO")
@Data
public class AppointmentPageReqVO extends PageParam {

    @Schema(description = "预约ID")
    private String orderNumber;

    @Schema(description = "用户名称", example = "赵六")
    private String clientName;

    @Schema(description = "预约项目", example = "28645")
    private Long projectId;

    @Schema(description = "门店", example = "6458")
    private Long shopId;

    @Schema(description = "健康管理师", example = "2235")
    private Long therapistId;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "预计结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] estimatedEndTime;

    @Schema(description = "预约状态", example = "2")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}