package cn.iocoder.yudao.module.yaochuantang.dal.dataobject.therapist;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 瑶川堂技师 DO
 *
 * @author young
 */
@TableName("yaochuantang_therapist")
@KeySequence("yaochuantang_therapist_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TherapistDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 简介
     */
    private String introduction;
    /**
     * 技师 logo
     */
    private String logo;
    /**
     * 擅长项目
     */
    private String focusProject;
    /**
     * 所属门店
     */
    private String baseShop;
    /**
     * 技师状态
     */
    private Integer status;


}