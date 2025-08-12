package cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 瑶川堂技师分页 Request VO")
@Data
public class TherapistPageReqVO extends PageParam {

    @Schema(description = "姓名", example = "芋艿")
    private String name;

    @Schema(description = "擅长项目")
    private String focusProject;

    @Schema(description = "所属门店")
    private String baseShop;

    @Schema(description = "技师状态", example = "2")
    private Integer status;

}