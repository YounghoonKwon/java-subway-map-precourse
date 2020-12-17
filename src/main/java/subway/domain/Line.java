package subway.domain;

import subway.exception.SubwayException;

public class Line {
    private String name;

    public Line(String name) {
        validateDuplicate(name);
        validateLength(name);
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
        if(LineRepository.isExist(name)){
            throw new SubwayException("이미 등록된 노선이 있습니다");
        }
    }
    // 추가 기능 구현
}
