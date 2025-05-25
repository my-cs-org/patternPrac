package com.ohgiraffers.pattern.chap02.structural.section07.proxy;

/**
 * 설명. 프록시 패턴 사용 예제
 *  - 다른 객체에 대한 접근을 제어하는 대리자 제공
 *  - 지연 로딩, 접근 제어, 로깅, 캐싱 등에 활용
 *  
 * 설명. 프록시 패턴의 장점
 *  1. 실제 객체의 생성과 사용을 제어할 수 있음
 *  2. 클라이언트는 실제 객체와 프록시 객체의 차이를 알 필요가 없음
 *  3. 실제 객체에 대한 추가 기능을 제공할 수 있음
 *  4. 보안, 로깅, 캐싱 등의 부가 기능을 쉽게 추가 가능
 *  
 * 설명. 프록시 패턴의 단점
 *  1. 객체 생성 시 한 단계를 더 거치므로 응답이 늦어질 수 있음
 *  2. 코드 복잡도가 증가함
 *  3. 프록시 내부에서 실제 객체 생성 시 오버헤드 발생 가능
 *  
 * 설명. 적절한 사용처
 *  1. 지연 초기화(Lazy Initialization)가 필요한 경우
 *  2. 접근 제어가 필요한 경우
 *  3. 로깅, 캐싱, 성능 측정 등 부가 기능이 필요한 경우
 *  4. 원격 객체에 대한 로컬 인터페이스가 필요한 경우
 */
public class ProxyPatternExample {
    public static void main(String[] args) {
        System.out.println("===== 프록시 패턴 예제 실행 =====");

        /* 여러 이미지 객체 생성 (프록시 사용) */
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");
        Image image3 = new ProxyImage("photo3.jpg");

        /* 이미지 정보 확인 (실제 이미지 로딩 안 함) */
        System.out.println("===== 이미지 정보 확인 =====");
        System.out.println("Image 1: " + image1.getFilename());
        System.out.println("Image 2: " + image2.getFilename());
        System.out.println("Image 3: " + image3.getFilename());

        /* 첫 번째 이미지만 표시 (이 때 실제 이미지 로딩) */
        System.out.println("===== 첫 번째 이미지 표시 =====");
        image1.display();

        /* 첫 번째 이미지 다시 표시 (이미 로딩되어 있음) */
        System.out.println("===== 첫 번째 이미지 다시 표시 =====");
        image1.display();

        /* 두 번째 이미지 표시 (새로 로딩) */
        System.out.println("===== 두 번째 이미지 표시 =====");
        image2.display();

        /* 프록시 없이 직접 RealImage 생성 (즉시 로딩) */
        System.out.println("===== 프록시 없이 직접 이미지 생성 =====");
        Image directImage = new RealImage("direct_photo.jpg");
        directImage.display();
    }
}
