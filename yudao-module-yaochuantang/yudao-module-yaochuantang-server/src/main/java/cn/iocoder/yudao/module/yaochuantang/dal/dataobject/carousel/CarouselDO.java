package cn.iocoder.yudao.module.yaochuantang.dal.dataobject.carousel;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 瑶川堂轮播图 DO
 *
 * @author young
 */
@TableName("yaochuantang_carousel")
@KeySequence("yaochuantang_carousel_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarouselDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 轮播图 logo
     */
    private String logo;
    /**
     * 轮播图跳转地址
     */
    private String redirectUrl;
    /**
     * 轮播图状态
     */
    private Integer status;


}