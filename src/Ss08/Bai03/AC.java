package Ss08.Bai03;

public class AC {

    private int temp = 25;

    public int getTemp(){
        return temp;
    }

    public void setTemp(int temp){
        this.temp = temp;
        System.out.println("Điều hòa: Nhiệt độ = " + temp);
    }
}