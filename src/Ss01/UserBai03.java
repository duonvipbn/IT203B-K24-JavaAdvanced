package Ss01;

public class UserBai03 {
    private int age;

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong the am!");
        }else{
            this.age = age;
        }
    }

    public int getAge() {

        return age;
    }
}