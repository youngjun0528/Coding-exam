package template_method_pattern.basic_problem1;

// 다른 모터를 추가하였을 경우는?
// First Motor와 중복코드 발생
public class SecondMotor {
    private Door door;
    private MotorStatus motorStatus;

    public SecondMotor(Door door) {
        this.door = door;
        motorStatus = MotorStatus.STOPED; // 초기값은 멈춤상태
    }

    private void moveSecondMotor(Direction direction) {
        // Run Motor
        System.out.println("Move second Motor");
    }

    public MotorStatus getMotorStatus() {
        return motorStatus;
    }

    private void setMotorStatus(MotorStatus motorStatus) {
        this.motorStatus = motorStatus;
    }

    public void move(Direction direction) {
        MotorStatus motorStatus = getMotorStatus();
        // 이미 이동중이면 아무일도 하지 않음.
        if (motorStatus == MotorStatus.MOVING) {
            return;
        }

        DoorStatus doorStatus = door.getDoorStatus();
        // 만약 문이 열여있다면 우선 문을 닫음.
        if (doorStatus == DoorStatus.OPENED) {
            door.close();
        }

        // 모터를 주어진 방향으로 이동함.
        moveSecondMotor(direction);
        // 모터 상태를 이동 중으로 변경함.
        setMotorStatus(MotorStatus.MOVING);
    }
}
