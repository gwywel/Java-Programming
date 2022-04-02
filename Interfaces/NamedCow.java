class NamedCow extends Cow{
    private String name;
    public NamedCow(String myName){
        name = myName;
    }
    public String getName(){
        return name;
    }
}