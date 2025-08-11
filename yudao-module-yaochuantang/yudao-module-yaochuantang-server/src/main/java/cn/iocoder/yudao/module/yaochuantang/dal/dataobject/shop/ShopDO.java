package cn.iocoder.yudao.module.yaochuantang.dal.dataobject.shop;

import lombok.*;
import java.util.*;
import java.time.LocalTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 瑶川堂门店 DO
 *
 * @author young
 */
@TableName("yaochuantang_shop")
@KeySequence("yaochuantang_shop_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 门店名称
     */
    private String name;
    /**
     * 门店简介
     */
    private String introduction;
    /**
     * 门店手机
     */
    private String phone;
    /**
     * 区域编号
     */
    private Integer areaId;
    /**
     * 门店详细地址
     */
    private String detailAddress;
    /**
     * 门店 logo
     */
    private String logo;
    /**
     * 营业开始时间
     */
    private LocalTime openingTime;
    /**
     * 营业结束时间
     */
    private LocalTime closingTime;
    /**
     * 纬度
     */
    private Double latitude;
    /**
     * 经度
     */
    private Double longitude;
    /**
     * 核销用户编号数组
     */
    private String verifyUserIds;
    /**
     * 门店状态
     */
    private Integer status;


}