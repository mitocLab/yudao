package cn.iocoder.yudao.module.yaochuantang.dal.dataobject.appointment;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 瑶川堂预约记录 DO
 *
 * @author young
 */
@TableName("yaochuantang_appointment")
@KeySequence("yaochuantang_appointment_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 预约ID
     */
    private String orderNumber;
    /**
     * 用户名称
     */
    private String clientName;
    /**
     * 预约项目
     */
    private Long projectId;
    /**
     * 门店
     */
    private Long shopId;
    /**
     * 健康管理师
     */
    private Long therapistId;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 预计结束时间
     */
    private LocalDateTime estimatedEndTime;
    /**
     * 预约状态
     */
    private Integer status;


}