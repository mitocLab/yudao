package cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.apilog.core.annotation.ApiAccessLog;
import static cn.iocoder.yudao.framework.apilog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.yaochuantang.controller.admin.carousel.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.carousel.CarouselDO;
import cn.iocoder.yudao.module.yaochuantang.service.carousel.CarouselService;

@Tag(name = "管理后台 - 瑶川堂轮播图")
@RestController
@RequestMapping("/yaochuantang/carousel")
@Validated
public class CarouselController {

    @Resource
    private CarouselService carouselService;

    @PostMapping("/create")
    @Operation(summary = "创建瑶川堂轮播图")
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:create')")
    public CommonResult<Long> createCarousel(@Valid @RequestBody CarouselSaveReqVO createReqVO) {
        return success(carouselService.createCarousel(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新瑶川堂轮播图")
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:update')")
    public CommonResult<Boolean> updateCarousel(@Valid @RequestBody CarouselSaveReqVO updateReqVO) {
        carouselService.updateCarousel(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除瑶川堂轮播图")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:delete')")
    public CommonResult<Boolean> deleteCarousel(@RequestParam("id") Long id) {
        carouselService.deleteCarousel(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除瑶川堂轮播图")
                @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:delete')")
    public CommonResult<Boolean> deleteCarouselList(@RequestParam("ids") List<Long> ids) {
        carouselService.deleteCarouselListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得瑶川堂轮播图")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:query')")
    public CommonResult<CarouselRespVO> getCarousel(@RequestParam("id") Long id) {
        CarouselDO carousel = carouselService.getCarousel(id);
        return success(BeanUtils.toBean(carousel, CarouselRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得瑶川堂轮播图分页")
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:query')")
    public CommonResult<PageResult<CarouselRespVO>> getCarouselPage(@Valid CarouselPageReqVO pageReqVO) {
        PageResult<CarouselDO> pageResult = carouselService.getCarouselPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CarouselRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出瑶川堂轮播图 Excel")
    @PreAuthorize("@ss.hasPermission('yaochuantang:carousel:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportCarouselExcel(@Valid CarouselPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<CarouselDO> list = carouselService.getCarouselPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "瑶川堂轮播图.xls", "数据", CarouselRespVO.class,
                        BeanUtils.toBean(list, CarouselRespVO.class));
    }

}