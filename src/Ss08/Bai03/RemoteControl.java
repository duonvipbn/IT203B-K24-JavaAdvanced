package Ss08.Bai03;

public class RemoteControl {

    Command[] slots = new Command[10];
    Command lastCommand;

    public void setCommand(int slot, Command command){
        slots[slot] = command;
        System.out.println("Đã gán " + command.getClass().getSimpleName() + " cho nút " + slot);
    }

    public void pressButton(int slot){
        if(slots[slot] != null){
            slots[slot].execute();
            lastCommand = slots[slot];
        }else{
            System.out.println("Chưa gán command cho nút này");
        }
    }

    public void undo(){
        if(lastCommand != null){
            lastCommand.undo();
        }else{
            System.out.println("Không có lệnh để undo");
        }
    }
}