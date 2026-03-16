package Ss08.Bai03;

public class FanOffCommand implements Command{

    Fan fan;

    public FanOffCommand(Fan fan){
        this.fan = fan;
    }

    @Override
    public void execute() {
        fan.off();
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        fan.on();
    }
}