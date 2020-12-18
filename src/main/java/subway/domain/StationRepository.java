package subway.domain;

import subway.exception.SubwayException;

import static java.util.stream.Collectors.*;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStationByName(String name) {
        stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new SubwayException("해당 역이 존재하지 않습니다"));

        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<String> getStationNames(){
        return stations.stream()
                .map(station -> station.getName())
                .collect(toList());
    }

    public static Station findStationByName(String name) {
        return stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new SubwayException("해당 역이 존재하지 않습니다"));
    }

    public static boolean isExist(String name) {
        return !stations.stream()
                .filter(station -> station.getName().equals(name))
                .findAny()
                .isEmpty();
    }


}
