package Ss08.Bai03;

public class LightOnCommand implements Command{

    Light light;

    public LightOnCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        light.off();
    }
}