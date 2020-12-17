package subway.menu;

import subway.controller.StationController;
import subway.exception.SubwayException;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public enum StationMenu {
    REGISTRATION("역 등록", "1", StationController::registerStation),
    DELETION("역 삭제", "2", StationController::deleteStation),
    SHOW("역 조회", "3", StationController::showStation),
    BACK("돌아가기", "B", StationController::back);

    StationMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static StationMenu findByCommand(String command) {
        return Arrays.stream(StationMenu.values())
                .filter(stationMenu -> stationMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new SubwayException("메뉴 잘못 입력");
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(StationMenu.values())
                .map(stationMenu -> stationMenu.title)
                .collect(toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(StationMenu.values())
                .map(stationMenu -> stationMenu.command)
                .collect(toList());
    }

    public void run() {
        this.action.run();
    }
}
