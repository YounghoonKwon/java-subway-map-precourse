package subway.constants;

public class Constants {
    public static final String LINE = "노선";
    public static final String STATION = "역";
    public static final String SECTION = "구간";
    public static final String NAME = "이름";
    public static final String ORDER = "순서";
    public static final String DOT = ". ";
    public static final String REGISTER = "등록";
    public static final String DELETE = "삭제";
    public static final String NEW_LINE = "\n";
    public static final String INFO = "[INFO] ";
    public static final String DASH = "---";
    public static final String ERROR = "[ERROR] ";
    public static final String LIST_TITLE = "## %s 목록";
    public static final String MAIN_SCREEN = "## 메인 화면";
    public static final String STATION_MANAGEMENT_SCREEN = "## 역 관리 화면";
    public static final String LINE_MANAGEMENT_SCREEN = "## 노선 관리 화면";
    public static final String SECTION_MANAGEMENT_SCREEN = "## 구간 관리 화면";
    public static final String TRANSIT_MAP = "## 지하철 노선도";
    public static final String PLEASE_SELECT_CATEGORY = "원하는 기능을 선택하세요.";
    public static final String COMPLETION_MESSAGE = "%s이 %s되었습니다.";
    public static final String PROMPT_MESSAGE = "## %s할 %s 이름을 입력하세요.";
    public static final String SECTION_PROMPT_MESSAGE = "## %s을 입력하세요.";
    public static final String SECTION_PROMPT_LINE_TO_DELETE = String.format("%s할 %s의 %s", DELETE, SECTION, LINE);
    public static final String SECTION_PROMPT_STATION_TO_DELETE = String.format("%s할 %s의 %s", DELETE, SECTION, STATION);
    public static final String DOWNSTREAM_STATION = "노선의 하행 종점역";
    public static final String UPSTREAM_STATION = "노선의 상행 종점역";
}
