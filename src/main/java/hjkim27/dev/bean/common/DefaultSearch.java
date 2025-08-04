package hjkim27.dev.bean.common;

import lombok.*;

import java.time.LocalDateTime;

/**
 * <pre>
 *     기본 검색 객체
 * </pre>
 *
 * @since 2025.08
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DefaultSearch {

    private Integer currentPage = 1;    // 현재페이지
    private Integer pageSize = 20;      // 한 페이지에 보일 row 수
    private Integer pageInterval = 5;   // 하단 페이징 최대 출력 수
    private Integer totalCount = 0;

    private String searchKey;   // 검색 키
    private String searchValue; // 검색 값
    private String searchType;  // 검색 구분 값

    private Integer columnIdx;  // 정렬 column index
    private Boolean desc;       // 오름/내림차순 확인

    private Boolean usePaging = true;

    private Integer sid;        // sid 검색

    private String dateColumnIdx;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public int getLimit() {
        return pageSize;
    }

    public int getOffset() {
        return pageSize * (currentPage - 1);
    }

    public int getLastPage() {
        if (totalCount == 0) return 1;
        return (int) Math.ceil(totalCount / pageSize);
    }

    public int getMinPage() {
        return ((currentPage - 1) / pageInterval) * pageInterval + 1;
    }

    public int getMaxPage() {
        return Math.min(getMinPage() + pageInterval - 1, getLastPage());
    }

}
