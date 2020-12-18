package subway.domain;

import java.util.*;

public class SectionRepository {
    private static final Map<Line, Section> sections = new HashMap<>();

    public static Map<Line, Section> sections() {
        return Collections.unmodifiableMap(sections);
    }

    public static Map<Line, Section> getSections(){
        return sections();
    }

    public static Section getSection(Line line){
        return sections.get(line);
    }

    public static void addSection(Line line, Section section){
        sections.put(line, section);
    }

    public static void deleteSection(Line lineToDelete) {
        sections.remove(lineToDelete);
    }

    public static void deleteStationByName(String stationName){
        sections()
                .values()
                .stream()
                .forEach(stations -> stations.deleteStationByName(stationName));
    }
}
