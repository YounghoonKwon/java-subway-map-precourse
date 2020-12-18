package subway.controller;

import static subway.constants.Constants.*;

import subway.domain.SectionRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class StationController {
    public static void registerStation(){
        OutputView.showPrompt(STATION, REGISTER);
        StationRepository.addStation(new Station(InputView.getInput()));
        OutputView.showCompletionMessage(STATION, REGISTER);
    }

    public static void deleteStation() {
        OutputView.showPrompt(STATION, DELETE);
        String stationToDelete = InputView.getInput();
        SectionRepository.deleteStationByName(stationToDelete);
        StationRepository.deleteStationByName(stationToDelete);
        OutputView.showCompletionMessage(STATION, DELETE);
    }

    public static void showStation() {
        OutputView.showListTitle(STATION);
        List<String> stationNames = StationRepository.getStationNames();
        if(stationNames.isEmpty()){
            throw new SubwayException("등록된 역이 없습니다");
        }
        OutputView.showList(stationNames);
    }

    public static void back() {
        //Just go through
    }
}
