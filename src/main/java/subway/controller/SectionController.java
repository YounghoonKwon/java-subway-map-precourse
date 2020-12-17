package subway.controller;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.constants.Constants.*;

public class SectionController {
    public static void registerSection() {
        OutputView.showSectionPrompt(LINE);
        Line lineToAdd = LineRepository.findLineByName(InputView.getInput());

        OutputView.showSectionPrompt(STATION + NAME);
        Station stationToAdd = StationRepository.findStationByName(InputView.getInput());

        OutputView.showSectionPrompt(ORDER);
        SectionRepository.getSection(lineToAdd).add(Integer.parseInt(InputView.getInput()) - 1, stationToAdd);

        OutputView.showCompletionMessage(SECTION, REGISTER);
    }

    public static void deleteSection() {
        OutputView.showSectionPrompt(SECTION_PROMPT_LINE_TO_DELETE);
        Line lineToDelete = LineRepository.findLineByName(InputView.getInput());

        OutputView.showSectionPrompt(SECTION_PROMPT_STATION_TO_DELETE);
        Station stationToDelete = StationRepository.findStationByName(InputView.getInput());

        SectionRepository.getSection(lineToDelete).deleteStation(stationToDelete);
        OutputView.showCompletionMessage(SECTION, DELETE);
    }

    public static void back() {
        //just go through
    }
}
