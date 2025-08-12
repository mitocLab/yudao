package cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.module.yaochuantang.convert.massageProject.MassageProjectConvert;
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

import cn.iocoder.yudao.module.yaochuantang.controller.admin.massageproject.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject.MassageProjectDO;
import cn.iocoder.yudao.module.yaochuantang.service.massageproject.MassageProjectService;

@Tag(name = "管理后台 - 瑶川堂项目")
@RestController
@RequestMapping("/yaochuantang/massage-project")
@Validated
public class MassageProjectController {

    @Resource
    private MassageProjectService massageProjectService;

    @PostMapping("/create")
    @Operation(summary = "创建瑶川堂项目")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:create')")
    public CommonResult<Long> createMassageProject(@Valid @RequestBody MassageProjectSaveReqVO createReqVO) {
        return success(massageProjectService.createMassageProject(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新瑶川堂项目")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:update')")
    public CommonResult<Boolean> updateMassageProject(@Valid @RequestBody MassageProjectSaveReqVO updateReqVO) {
        massageProjectService.updateMassageProject(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除瑶川堂项目")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:delete')")
    public CommonResult<Boolean> deleteMassageProject(@RequestParam("id") Long id) {
        massageProjectService.deleteMassageProject(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除瑶川堂项目")
                @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:delete')")
    public CommonResult<Boolean> deleteMassageProjectList(@RequestParam("ids") List<Long> ids) {
        massageProjectService.deleteMassageProjectListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得瑶川堂项目")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:query')")
    public CommonResult<MassageProjectRespVO> getMassageProject(@RequestParam("id") Long id) {
        MassageProjectDO massageProject = massageProjectService.getMassageProject(id);
        return success(BeanUtils.toBean(massageProject, MassageProjectRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得瑶川堂项目分页")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:query')")
    public CommonResult<PageResult<MassageProjectRespVO>> getMassageProjectPage(@Valid MassageProjectPageReqVO pageReqVO) {
        PageResult<MassageProjectDO> pageResult = massageProjectService.getMassageProjectPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, MassageProjectRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出瑶川堂项目 Excel")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportMassageProjectExcel(@Valid MassageProjectPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<MassageProjectDO> list = massageProjectService.getMassageProjectPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "瑶川堂项目.xls", "数据", MassageProjectRespVO.class,
                        BeanUtils.toBean(list, MassageProjectRespVO.class));
    }

    @GetMapping("/simple-list")
    @Operation(summary = "获取项目简要信息列表")
    @PreAuthorize("@ss.hasPermission('yaochuantang:massage-project:query')")
    public CommonResult<List<MassageProjectSimpleRespVO>> getSimpleMassageProjectList() {
        List<MassageProjectDO> list = massageProjectService.getMassageProjectListByStatus(
                CommonStatusEnum.ENABLE.getStatus());
        return success(MassageProjectConvert.INSTANCE.convertList1(list));
    }

}