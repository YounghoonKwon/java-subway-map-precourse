package subway.menu;

import subway.controller.LineController;
import subway.exception.SubwayException;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;

public enum LineMenu {
    REGISTRATION("노선 등록", "1",LineController::registerLine),
    DELETION("노선 삭제", "2", LineController::deleteLine),
    SHOW("노선 조회", "3", LineController::showLine),
    BACK("돌아가기", "B", LineController::back);

    LineMenu(String title, String command, Runnable action) {
        this.title = title;
        this.command = command;
        this.action = action;
    }

    private final String title;
    private final String command;
    private final Runnable action;

    public static LineMenu findByCommand(String command) {
        return Arrays.stream(LineMenu.values())
                .filter(mainMenu -> mainMenu.command.equalsIgnoreCase(command))
                .findAny()
                .orElseThrow(() -> {
                    throw new SubwayException("메뉴 잘못 입력");
                });
    }

    public static List<String> getTitles() {
        return Arrays.stream(LineMenu.values())
                .map(mainMenu -> mainMenu.title)
                .collect(toList());
    }

    public static List<String> getCommands() {
        return Arrays.stream(LineMenu.values())
                .map(mainMenu -> mainMenu.command)
                .collect(toList());
    }

    public void run() {
        this.action.run();
    }
}
