package Ss08.Bai03;

public class Main {

    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();

        Light light = new Light();
        Fan fan = new Fan();
        AC ac = new AC();

        // Gán nút 1 bật đèn
        remote.setCommand(1, new LightOnCommand(light));

        // Nhấn nút 1
        remote.pressButton(1);

        // Gán nút 2 tắt đèn
        remote.setCommand(2, new LightOffCommand(light));

        // Nhấn nút 2
        remote.pressButton(2);

        // Undo
        remote.undo();

        // Gán nút 3 set nhiệt độ
        remote.setCommand(3, new ACSetTemperatureCommand(ac,26));

        // Nhấn nút 3
        remote.pressButton(3);

        // Undo
        remote.undo();
    }
}