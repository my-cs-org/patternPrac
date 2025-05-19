package com.ohgiraffers.pattern.chap01.basic.section04.builder;

/**
 * 설명. 빌더 패턴의 제품(Product) 클래스
 *  - 복잡한 객체를 표현
 */
public class Computer {

    /* 설명. 필수 속성 */
    private String cpu;
    private String ram;
    private String storage;

    /* 설명. 선택 속성 */
    private String graphicsCard;
    private String monitor;
    private String keyboard;
    private String mouse;
    private String speaker;
    private boolean hasBluetooth;
    private boolean hasWifi;

    public Computer(Builder builder) {
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.graphicsCard = graphicsCard;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
        this.speaker = speaker;
        this.hasBluetooth = hasBluetooth;
        this.hasWifi = hasWifi;
    }

    /* 설명. Getter 메소드들 */

    public String getCpu() {
        return cpu;
    }

    public String getRam() {
        return ram;
    }

    public String getStorage() {
        return storage;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public String getMonitor() {
        return monitor;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public boolean isHasBluetooth() {
        return hasBluetooth;
    }

    public boolean isHasWifi() {
        return hasWifi;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("===== 컴퓨터 사양 =====");
        sb.append("CPU: ").append(cpu).append("\n");
        sb.append("RAM: ").append(ram).append("\n");
        sb.append("저장장치: ").append(storage).append("\n");

        if (graphicsCard != null) {
            sb.append("그래픽카드: ").append(graphicsCard).append("\n");
        }
        if (monitor != null) {
            sb.append("모니터: ").append(monitor).append("\n");
        }
        if (keyboard != null) {
            sb.append("키보드: ").append(keyboard).append("\n");
        }
        if (mouse != null) {
            sb.append("마우스: ").append(mouse).append("\n");
        }
        if (speaker != null) {
            sb.append("스피커: ").append(speaker).append("\n");
        }

        sb.append("블루투스: ").append(hasBluetooth? "있음": "없음").append("\n");
        sb.append("와이파이: ").append(hasWifi? "있음": "없음").append("\n");

        return sb.toString();
    }

    /**
     * 설명. 빌더 클래스 - Computer 객체를 생성하기 위한 빌더
     */
    public static class Builder {

        /* 설명. 필수 속성 */
        private String cpu;
        private String ram;
        private String storage;

        /* 설명. 선택 속성 - 기본값으로 초기화 */
        private String graphicsCard;
        private String monitor;
        private String keyboard;
        private String mouse;
        private String speaker;
        private boolean hasBluetooth;
        private boolean hasWifi;

        /* 설명. 필수 속성을 받는 생성자 */
        public Builder(String cpu, String ram, String storage) {
            this.cpu = cpu;
            this.ram = ram;
            this.storage = storage;
        }

        /* 설명. 선택 속성을 설정하고 Builder 객체를 반환(메소드 체이닝 지원)하는 메소드들 */
        public Builder graphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder monitor(String monitor) {
            this.monitor = monitor;
            return this;
        }

        public Builder keyboard(String keyboard) {
            this.keyboard = keyboard;
            return this;
        }

        public Builder mouse(String mouse) {
            this.mouse = mouse;
            return this;
        }

        public Builder speaker(String speaker) {
            this.speaker = speaker;
            return this;
        }

        public Builder hasBluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Builder hasWifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }
        
        /* 설명. Computer 객체 생성 */
        public Computer build() {
            return new Computer(this);
        }
    }
}
