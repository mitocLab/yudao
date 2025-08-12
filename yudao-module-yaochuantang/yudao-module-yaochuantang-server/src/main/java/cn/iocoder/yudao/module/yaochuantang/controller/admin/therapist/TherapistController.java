package cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist;

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

import cn.iocoder.yudao.module.yaochuantang.controller.admin.therapist.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist.TherapistDO;
import cn.iocoder.yudao.module.yaochuantang.service.therapist.TherapistService;

@Tag(name = "管理后台 - 瑶川堂技师")
@RestController
@RequestMapping("/yaochuantang/therapist")
@Validated
public class TherapistController {

    @Resource
    private TherapistService therapistService;

    @PostMapping("/create")
    @Operation(summary = "创建瑶川堂技师")
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:create')")
    public CommonResult<Long> createTherapist(@Valid @RequestBody TherapistSaveReqVO createReqVO) {
        return success(therapistService.createTherapist(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新瑶川堂技师")
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:update')")
    public CommonResult<Boolean> updateTherapist(@Valid @RequestBody TherapistSaveReqVO updateReqVO) {
        therapistService.updateTherapist(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除瑶川堂技师")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:delete')")
    public CommonResult<Boolean> deleteTherapist(@RequestParam("id") Long id) {
        therapistService.deleteTherapist(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除瑶川堂技师")
                @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:delete')")
    public CommonResult<Boolean> deleteTherapistList(@RequestParam("ids") List<Long> ids) {
        therapistService.deleteTherapistListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得瑶川堂技师")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:query')")
    public CommonResult<TherapistRespVO> getTherapist(@RequestParam("id") Long id) {
        TherapistDO therapist = therapistService.getTherapist(id);
        return success(BeanUtils.toBean(therapist, TherapistRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得瑶川堂技师分页")
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:query')")
    public CommonResult<PageResult<TherapistRespVO>> getTherapistPage(@Valid TherapistPageReqVO pageReqVO) {
        PageResult<TherapistDO> pageResult = therapistService.getTherapistPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, TherapistRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出瑶川堂技师 Excel")
    @PreAuthorize("@ss.hasPermission('yaochuantang:therapist:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportTherapistExcel(@Valid TherapistPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<TherapistDO> list = therapistService.getTherapistPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "瑶川堂技师.xls", "数据", TherapistRespVO.class,
                        BeanUtils.toBean(list, TherapistRespVO.class));
    }

}