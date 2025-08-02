package hjkim27.dev.bean.user;

import hjkim27.dev.bean.common.DefaultSearch;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     사용자 검색 객체
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserSearch extends DefaultSearch {

    List<Integer> authLevels = new ArrayList<>();

}
