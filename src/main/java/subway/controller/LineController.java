package subway.controller;

import static subway.constants.Constants.*;

import subway.domain.*;
import subway.exception.SubwayException;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class LineController {

    public static void registerLine() {
        OutputView.showPrompt(LINE, REGISTER);
        String lineName = InputView.getInput();

        OutputView.showPrompt(UPSTREAM_STATION, REGISTER);
        Station upSteamStation = StationRepository.findStationByName(InputView.getInput());

        OutputView.showPrompt(DOWNSTREAM_STATION, REGISTER);
        Station downStreamStation = StationRepository.findStationByName(InputView.getInput());

        Line newLine = new Line(lineName);
        Section newSection = new Section(Arrays.asList(upSteamStation, downStreamStation));
        LineRepository.addLine(newLine);
        SectionRepository.addSection(newLine, newSection);

        OutputView.showCompletionMessage(LINE, REGISTER);
    }

    public static void deleteLine() {
        OutputView.showPrompt(LINE, DELETE);

        String lineNameToDelete = InputView.getInput();
        Line lineToDelete = LineRepository.findLineByName(lineNameToDelete);

        LineRepository.deleteLine(lineToDelete);
        SectionRepository.deleteSection(lineToDelete);

        OutputView.showCompletionMessage(LINE, DELETE);
    }

    public static void showLine() {
        OutputView.showListTitle(LINE);
        List<String> lineNames = LineRepository.getLineNames();
        if (lineNames.isEmpty()) {
            throw new SubwayException("등록된 역이 없습니다");
        }
        OutputView.showList(lineNames);
    }

    public static void back() {
        //just go through
    }
}
