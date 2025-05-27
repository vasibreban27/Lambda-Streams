package utcn;

public interface Transformer <T>{
    public T transform(T input);
}

class TransformDemo{
    public static void main(String[] args){
        Transformer<String> toUpper = String::toUpperCase; //convertesc un string cu litere mici in litere mari
        System.out.println(toUpper.transform("hello"));

        Transformer<String> toLower = String::toLowerCase;
        System.out.println(toLower.transform("IMI PLACE SA MANANC"));

        Transformer<Integer> square = x -> x * x; //calculez patratul unui numar intreg
        System.out.println(square.transform(17));
    }
}
