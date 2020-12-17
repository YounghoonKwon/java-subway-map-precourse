package subway.controller;

import subway.domain.Line;
import subway.domain.Section;
import subway.domain.SectionRepository;
import subway.exception.SubwayException;
import subway.menu.LineMenu;
import subway.menu.SectionMenu;
import subway.menu.StationMenu;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

import static java.util.stream.Collectors.*;

public class MainController {
    public static void manageStation() {
        try {
            OutputView.showStationMenu();
            StationMenu.findByCommand(InputView.getInput()).run();
        } catch (SubwayException error) {
            System.out.println(error.getMessage());
            manageStation();
        }
    }

    public static void manageLine() {
        try {
            OutputView.showLineMenu();
            LineMenu.findByCommand(InputView.getInput()).run();
        } catch (SubwayException error) {
            System.out.println(error.getMessage());
            manageLine();
        }
    }

    public static void manageSection() {
        try {
            OutputView.showSectionMenu();
            SectionMenu.findByCommand(InputView.getInput()).run();
        } catch (SubwayException error) {
            System.out.println(error.getMessage());
            manageSection();
        }
    }

    public static void showEntireMap() {
        List<Line> lines = SectionRepository
                .getSections()
                .keySet()
                .stream()
                .collect(toList());
        List<Section> sections = SectionRepository
                .getSections()
                .values()
                .stream()
                .collect(toList());

        OutputView.showEntireMap(lines, sections);
    }

    public static void end() {
        System.exit(0);
    }
}

