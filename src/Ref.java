import java.lang.reflect.Field;

public class Ref {

    public static void main(String[] args) throws IllegalAccessException {
//        People people1 = new People("qqq","aaa");
//        Field[] fields = People.class.getDeclaredFields();
//        for (Field field:fields){
//            String name = field.getName();
//            field.setAccessible(true);
//            String value = (String)field.get(people1);
//            System.out.println(name+":"+value);
//        }

        String a = "64.0f";
        float f = Float.valueOf(a);
        System.out.println(f);
    }

}

class People{
    private String name;
    String z = "z";
    String b = "y";
    String sex;
    String a = "a";

    public People(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}

class Item{
    String key;
    String value;
}