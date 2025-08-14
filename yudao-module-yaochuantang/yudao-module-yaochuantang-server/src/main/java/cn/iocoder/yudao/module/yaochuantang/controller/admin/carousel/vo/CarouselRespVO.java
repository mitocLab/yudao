package cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;
import cn.idev.excel.annotation.*;

@Schema(description = "管理后台 - 瑶川堂轮播图 Response VO")
@Data
@ExcelIgnoreUnannotated
public class CarouselRespVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13828")
    @ExcelProperty("编号")
    private Long id;

    @Schema(description = "轮播图 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("轮播图 logo")
    private String logo;

    @Schema(description = "轮播图跳转地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @ExcelProperty("轮播图跳转地址")
    private String redirectUrl;

    @Schema(description = "轮播图状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @ExcelProperty("轮播图状态")
    private Integer status;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}