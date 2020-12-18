package subway;

import org.junit.jupiter.api.*;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;

import static org.assertj.core.api.Assertions.*;

/*
메소드명_테스트하려는상태_기대하는동작
메소드명_기대하는동작_테스트하려는상태
Should_기대하는동작_When_테스트대상상태
When_테스트대상상태_Expect_기대하는동작
Given_사전조건_When_테스트대상상태_Then_기대하는동작
 */

public class StationTest {
    static Station station;

    @BeforeAll
    static void init(){
        station = new Station("사당역");
        StationRepository.addStation(station);
    }

    @DisplayName("역을 등록한다")
    @Test
    void When_기본상태_Expect_역등록완료() {
        String testName = "분당역";
        station = new Station(testName);
        StationRepository.addStation(station);
        assertThat(StationRepository.findStationByName(testName)).isEqualTo(station);
    }

    @DisplayName("예외 : 이미 등록된 역 이름을 등록하면 예외를 발생시킨다")
    @Test
    void When_중복등록_Expect_예외발생() {
        String testName = "사당역";
        assertThatThrownBy(() -> new Station(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 이미 등록된 역이 있습니다");
    }

    @DisplayName("예외 : 역 이름이 2글자보다 짧으면 예외를 발생시킨다")
    @Test
    void When_잘못된입력_Expect_예외발생() {
        String testName = "역";
        assertThatThrownBy(() -> new Station(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 역 이름은 2글자 이상이어야 합니다");
    }

    @DisplayName("이름으로 역을 찾는다.")
    @Test
    void When_기본상태역찾기_Expect_찾기완료() {
        String testName = "사당역";
        assertThat(StationRepository.findStationByName(testName).equals(station));
    }

    @DisplayName("예외 : 이름으로 역을 찾는다.")
    @Test
    void When_존재하지않는역찾기_Expect_예외발생() {
        String testName = "강변역";
        assertThatThrownBy(() -> StationRepository.findStationByName(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 해당 역이 존재하지 않습니다");
    }

    @DisplayName("예외 : 없는 역을 삭제한다. ")
    @Test
    void When_존재하지않는역삭제_Expect_예외발생() {
        String testName = "강변역";
        assertThatThrownBy(() -> StationRepository.deleteStationByName(testName))
                .isInstanceOf(SubwayException.class)
                .hasMessage("[ERROR] 해당 역이 존재하지 않습니다");
    }

    @DisplayName("역을 삭제한다. ")
    @Test
    void When_기본상태_Expect_역삭제완료() {
        String testName = "사당역";
        StationRepository.deleteStationByName(testName);
        assertThat(StationRepository.stations().size() == 0);
    }
}
