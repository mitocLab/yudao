package cn.iocoder.yudao.module.yaochuantang.enums.appointment;

import cn.hutool.core.util.ObjUtil;
import cn.iocoder.yudao.framework.common.core.ArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum AppointmentStatusEnum implements ArrayValuable<Integer> {
    NEW(0, "待服务"),
    IN_PROGRESS(1, "服务中"),
    COMPLETED(2, "已完成"),
    CANCELLED(3, "已取消");

    public static final Integer[] ARRAYS = Arrays.stream(values()).map(AppointmentStatusEnum::getStatus).toArray(Integer[]::new);


    /**
     * 状态
     */
    private final Integer status;
    /**
     * 状态名
     */
    private final String name;

    @Override
    public Integer[] array() {
        return ARRAYS;
    }

    public static boolean isNew(Integer status) {
        return ObjUtil.equal(NEW.status, status);
    }
    public static boolean isPROGRESS(Integer status) {
        return ObjUtil.equal(IN_PROGRESS.status, status);
    }
    public static boolean isCOMPLETED(Integer status) {
        return ObjUtil.equal(COMPLETED.status, status);
    }
    public static boolean isCANCELLED(Integer status) {
        return ObjUtil.equal(CANCELLED.status, status);
    }

    public static AppointmentStatusEnum getByStatus(Integer status) {
        if (status == null) {
            return null;
        }
        for (AppointmentStatusEnum value : values()) {
            if (value.status.equals(status)) {
                return value;
            }
        }
        return null;
    }

    /**
     * 根据状态码获取名称（用于状态码转描述）
     */
    public static String getNameByStatus(Integer status) {
        AppointmentStatusEnum enumValue = getByStatus(status);
        return enumValue != null ? enumValue.getName() : "未知状态";
    }
}
