package hello.core.singleton;

public class SingletonService {

    //자기 자신을 가지고 있음. static으로 하나의 객체만 생성해둠
    private static final SingletonService instance = new SingletonService();

    // public 으로 지정해 인스턴스가 필요하면, 이 메소드를 활용해서만 조회 허용
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private으로 선언해서 외부에서 신규 인스턴스로 생성 불가
    private SingletonService() {

    }

    public void logic () {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
