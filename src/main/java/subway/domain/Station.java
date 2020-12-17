package subway.domain;

import subway.exception.SubwayException;

public class Station {
    private String name;

    public Station(String name) {
        validateLength(name);
        validateDuplicate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validateLength(String name){
        if (name.length() < 2){
            throw new SubwayException("이름은 2이상");
        }
    }

    public void validateDuplicate(String name){
        if(StationRepository.isExist(name)){
            throw new SubwayException("이미 등록된 역이 있습니다");
        }
    }
    // 추가 기능 구현
}
