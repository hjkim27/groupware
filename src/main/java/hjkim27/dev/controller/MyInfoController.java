package hjkim27.dev.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     내정보 관리
 * </pre>
 */
public class MyInfoController {

    @ResponseBody
    @RequestMapping(
            value = "menu/{menuId}",
            method = {RequestMethod.POST, RequestMethod.PATCH, RequestMethod.DELETE}
    )
    public Map<String, Object> temp(HttpServletRequest request, HttpServletResponse response,
                                    @PathVariable(name = "menuId", value = "-1", required = false) Long menuId) {

        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();

        try {
            if (request.getMethod().equals(RequestMethod.POST)) {
                // 여기는 생성
                /// 필수값들이 있어서 validation 별도 확인 필요!!!!!
            } else {
                if (menuId < 0) {/// menuId 가 기본값이면 -1 >> 실패!
                    return null;
                }
                if (request.getMethod().equals(RequestMethod.PATCH)) {
                    // 여기는 수정
                } else if (request.getMethod().equals(RequestMethod.DELETE)) {
                    // 여기는 삭제
                }
            }
        } catch (Exception e) {
            ///  뭐 대충 뭔 에런데요
            data.put("message", e.getMessage());
        } finally {
            result.put("data", data);
        }
        return result;
    }

}
