package Ss08.Bai03;

public class ACSetTemperatureCommand implements Command{

    AC ac;
    int newTemp;
    int oldTemp;

    public ACSetTemperatureCommand(AC ac, int newTemp){
        this.ac = ac;
        this.newTemp = newTemp;
    }

    @Override
    public void execute() {
        oldTemp = ac.getTemp();
        ac.setTemp(newTemp);
    }

    @Override
    public void undo() {
        System.out.print("Undo: ");
        ac.setTemp(oldTemp);
    }
}