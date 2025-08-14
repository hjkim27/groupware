package hjkim27.dev.util.common;

import hjkim27.dev.exception.WrongParamException;

import java.lang.reflect.Field;
import java.util.List;

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
     *     - 제외필드 없음
     * </pre>
     *
     * @param obj
     * @return
     */
    public static boolean isValidParam(Object obj) {
        return isValidParam(obj, null);
    }

    /**
     * <pre>
     *     객체 내 모든 필드가 null 또는 "" 인지 검사
     *     - Boolean, Integer : null 체크
     *     - String : null, empty 체크
     *     - ignoreFields에 포함된 필드는 검사하지 않음
     * </pre>
     *
     * @param obj          검사할 객체
     * @param ignoreFields 필수값이 아닌 경우 제외하기 위한 필드 목록
     * @return 모든 필드 값 존재: true, 빈 필드가 존재 false
     */
    public static boolean isValidParam(Object obj, List<String> ignoreFields) {
        if (obj == null) {
            return false;
        }

        Field[] fields = obj.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = field.get(obj);

                // ignoreFields에 포함된 필드는 검사하지 않음
                boolean isIgnored = false;
                if (ignoreFields != null && !ignoreFields.isEmpty()) {
                    if (ignoreFields.contains(field.getName())) {
                        isIgnored = true;
                    }
                }

                if (!isIgnored) {
                    if (value == null || (value instanceof String && String.valueOf(value).trim().isEmpty())) {
                        return false;
                    }
                }
            }
        } catch (IllegalAccessException e) {
            throw new WrongParamException(e.getMessage());
        }
        return true;
    }
}
