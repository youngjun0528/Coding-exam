package src.command_pattern.basic_problem1;

public class Client {
    public static void main(String[] args) {
        Alarm alarm = new Alarm();
        Button alarmButton = new Button(alarm);
        alarmButton.pressed();
    }
}

/*-
*/
