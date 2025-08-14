package cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment;

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

import cn.iocoder.yudao.module.yaochuantang.controller.admin.appointment.vo.*;
import cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment.AppointmentDO;
import cn.iocoder.yudao.module.yaochuantang.service.appointment.AppointmentService;

@Tag(name = "管理后台 - 瑶川堂预约记录")
@RestController
@RequestMapping("/yaochuantang/appointment")
@Validated
public class AppointmentController {

    @Resource
    private AppointmentService appointmentService;

    @PostMapping("/create")
    @Operation(summary = "创建瑶川堂预约记录")
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:create')")
    public CommonResult<Long> createAppointment(@Valid @RequestBody AppointmentSaveReqVO createReqVO) {
        return success(appointmentService.createAppointment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新瑶川堂预约记录")
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:update')")
    public CommonResult<Boolean> updateAppointment(@Valid @RequestBody AppointmentSaveReqVO updateReqVO) {
        appointmentService.updateAppointment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除瑶川堂预约记录")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:delete')")
    public CommonResult<Boolean> deleteAppointment(@RequestParam("id") Long id) {
        appointmentService.deleteAppointment(id);
        return success(true);
    }

    @DeleteMapping("/delete-list")
    @Parameter(name = "ids", description = "编号", required = true)
    @Operation(summary = "批量删除瑶川堂预约记录")
                @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:delete')")
    public CommonResult<Boolean> deleteAppointmentList(@RequestParam("ids") List<Long> ids) {
        appointmentService.deleteAppointmentListByIds(ids);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得瑶川堂预约记录")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:query')")
    public CommonResult<AppointmentRespVO> getAppointment(@RequestParam("id") Long id) {
        AppointmentDO appointment = appointmentService.getAppointment(id);
        return success(BeanUtils.toBean(appointment, AppointmentRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得瑶川堂预约记录分页")
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:query')")
    public CommonResult<PageResult<AppointmentRespVO>> getAppointmentPage(@Valid AppointmentPageReqVO pageReqVO) {
        PageResult<AppointmentRespVO> pageResult = appointmentService.getAppointmentPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, AppointmentRespVO.class));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出瑶川堂预约记录 Excel")
    @PreAuthorize("@ss.hasPermission('yaochuantang:appointment:export')")
    @ApiAccessLog(operateType = EXPORT)
    public void exportAppointmentExcel(@Valid AppointmentPageReqVO pageReqVO,
              HttpServletResponse response) throws IOException {
        pageReqVO.setPageSize(PageParam.PAGE_SIZE_NONE);
        List<AppointmentRespVO> list = appointmentService.getAppointmentPage(pageReqVO).getList();
        // 导出 Excel
        ExcelUtils.write(response, "瑶川堂预约记录.xls", "数据", AppointmentRespVO.class,
                        BeanUtils.toBean(list, AppointmentRespVO.class));
    }

}