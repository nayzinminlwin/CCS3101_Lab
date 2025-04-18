package Test1_Prac;

public class User{

    protected String name;
    protected int phoneNum;

    User(String name, int phoneNum){
        this.name = name;
        this.phoneNum = phoneNum;
    }

    public String getName()
    {
        return this.name;
    }
    public int getPhoneNum()
    {
        return this.phoneNum;
    }
}