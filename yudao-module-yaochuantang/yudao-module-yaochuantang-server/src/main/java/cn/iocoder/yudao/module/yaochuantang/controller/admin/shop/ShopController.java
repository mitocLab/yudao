package cn.iocoder.yudao.module.yaochuantang.controller.admin.shop;

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

import cn.iocoder.yudao.module.yaochuantang.controller.admin.shop.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop.ShopDO;
import cn.iocoder.yudao.module.yaochuantang.service.shop.ShopService;
import lombok.extern.slf4j.Slf4j;

@Tag(name = "管理后台 - 瑶川堂门店")
@RestController
@RequestMapping("/yaochuantang/shop")
@Validated
@Slf4j
public class ShopController {

    @Resource
    private ShopService shopService;

    @PostMapping("/create")
    @Operation(summary = "创建瑶川堂门店")
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:create')")
    public CommonResult<Long> createShop(@Valid @RequestBody ShopSaveReqVO createReqVO) {
        return success(shopService.createShop(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新瑶川堂门店")
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:update')")
    public CommonResult<Boolean> updateShop(@Valid @RequestBody ShopSaveReqVO updateReqVO) {
        shopService.updateShop(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除瑶川堂门店")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:delete')")
    public CommonResult<Boolean> deleteShop(@RequestParam("id") Long id) {
        shopService.deleteShop(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除瑶川堂门店")
                @PreAuthorize("@ss.hasPermission('yaochuantang:shop:delete')")
    public CommonResult<Boolean> deleteShopList(@RequestParam("ids") List<Long> ids) {
        shopService.deleteShopListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得瑶川堂门店")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:query')")
    public CommonResult<ShopRespVO> getShop(@RequestParam("id") Long id) {
        ShopDO shop = shopService.getShop(id);
        return success(BeanUtils.toBean(shop, ShopRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得瑶川堂门店分页")
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:query')")
    public CommonResult<PageResult<ShopRespVO>> getShopPage(@Valid ShopPageReqVO pageReqVO) {
        PageResult<ShopDO> pageResult = shopService.getShopPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, ShopRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出瑶川堂门店 Excel")
    @PreAuthorize("@ss.hasPermission('yaochuantang:shop:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportShopExcel(@Valid ShopPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<ShopDO> list = shopService.getShopPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "瑶川堂门店.xls", "数据", ShopRespVO.class,
                        BeanUtils.toBean(list, ShopRespVO.class));
    }

}