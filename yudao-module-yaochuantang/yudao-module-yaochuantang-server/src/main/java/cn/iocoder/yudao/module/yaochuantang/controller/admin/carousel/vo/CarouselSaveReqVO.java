package cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 瑶川堂轮播图新增/修改 Request VO")
@Data
public class CarouselSaveReqVO {

    @Schema(description = "编号", requiredMode = Schema.RequiredMode.REQUIRED, example = "13828")
    private Long id;

    @Schema(description = "轮播图 logo", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotEmpty(message = "轮播图 logo不能为空")
    private String logo;

    @Schema(description = "轮播图跳转地址", requiredMode = Schema.RequiredMode.REQUIRED, example = "https://www.iocoder.cn")
    @NotEmpty(message = "轮播图跳转地址不能为空")
    private String redirectUrl;

    @Schema(description = "轮播图状态", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotNull(message = "轮播图状态不能为空")
    private Integer status;

}