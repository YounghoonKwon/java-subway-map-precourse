package subway;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.*;
import subway.exception.SubwayException;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LineTest {

    @DisplayName("예외 : 노선이름이 2보다 작을 경우")
    @Test
    void When_노선등록잘못된입력_Expect_예외() {
        String testName = "1";
        assertThatThrownBy(() -> new Line(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 노선 이름은 2글자 이상이어야 합니다");
    }

    @DisplayName("예외 : 노선 등록 상행 하행 중")
    @Test
    void When_노선등록상행하행중복_Expect_예외() {
        Station teststation1 = new Station("테스트");
        assertThatThrownBy(() -> new Section(Arrays.asList(teststation1, teststation1)))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 상행과 하행은 같을 수 없습니다");
    }

    @DisplayName("예외 : 노선 삭제")
    @Test
    void When_노선삭제없는경우_Expect_예외() {
        assertThatThrownBy(() -> LineRepository.deleteLineByName("없는노선"))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 삭제할 노선이 존재하지 않습니다");
    }
}
