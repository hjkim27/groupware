package hjkim27.dev.util.common;

import hjkim27.dev.exception.WrongParamException;

import java.lang.reflect.Field;

/**
 * <pre>
 *     paramter 유효성 검사 관련 util 클래스
 * </pre>
 *
 * @since 2025.08
 */
public class ValidParamUtil {

    /**
     * <pre>
     *     객체 내 모든 필드가 null 또는 "" 인지 검사
     *     - Boolean, Integer : null 체크
     *     - String : null, empty 체크
     * </pre>
     *
     * @param obj 검사할 객체
     * @return 모든 필드 값 존재: true, 빈 필드가 존재 false
     * @since 2025.08
     */
    public static boolean isValidParam(Object obj) {
        if (obj == null) {
            return false;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);
                if (value == null) {
                    return false;
                }
                if (value instanceof String && String.valueOf(value).trim().isEmpty()) {
                    return false;
                }
            }
        } catch (IllegalAccessException e) {
            throw new WrongParamException(e.getMessage());
        }
        return true;
    }
}
