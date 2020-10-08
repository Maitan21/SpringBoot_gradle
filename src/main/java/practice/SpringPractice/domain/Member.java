package practice.SpringPractice.domain;

public class Member {

    //vo(dto)
    //어플리케이션에 저장되는 정보
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
