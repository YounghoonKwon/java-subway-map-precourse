package subway.menu;

import subway.controller.MainController;
import subway.exception.SubwayException;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public enum MainMenu {
    STATION_MANAGE("역 관리", "1", MainController::manageStation),
    LINE_MANAGE("노선 관리", "2", MainController::manageLine),
    SECTION_MANAGE("구간 관리", "3", MainController::manageSection),
    SHOW_SUBWAY_MAP("지하철 노선도 출력", "4", MainController::showEntireMap),
    QUIT("종료", "Q", MainController::end);

    MainMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static MainMenu findByCommand(String command) {
        return Arrays.stream(MainMenu.values())
                .filter(mainMenu -> mainMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new SubwayException("메뉴 잘못 입력");
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.title)
                .collect(toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(MainMenu.values())
                .map(mainMenu -> mainMenu.command)
                .collect(toList());
    }

    public void run() {
        this.action.run();
    }
}
