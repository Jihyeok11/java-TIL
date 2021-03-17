package day5;

// 2가지 기능을 스펙으로 제시 --- 각각으로 상속받는 하위 클래서에서 구현해라는 뜻
public interface Teacher {
	String name = "교수";
	public abstract void teach(); // public과 abstract는 안써도 자동으로 생성
	public abstract void lunch();
}
