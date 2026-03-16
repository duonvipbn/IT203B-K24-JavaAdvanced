package Ss08.Bai03;

public class FanOnCommand implements Command{

    Fan fan;

    public FanOnCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        fan.off();
    }
}