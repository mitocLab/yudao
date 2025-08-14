package cn.iocoder.yudao.module.yaochuantang.dal.dataobject.massageproject;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 瑶川堂项目 DO
 *
 * @author young
 */
@TableName("yaochuantang_massage_project")
@KeySequence("yaochuantang_massage_project_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MassageProjectDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 项目名称
     */
    private String name;
    /**
     * 项目简介
     */
    private String introduction;
    /**
     * 项目流程
     */
    private String process;
    /**
     * 项目 logo
     */
    private String logo;
    /**
     * 项目状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Integer status;
    /**
     * 项目时长
     *
     */
    private Integer duration;


}