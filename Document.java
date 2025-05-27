package utcn;

public abstract class Document {
    abstract void print();
}

interface Storable{
    void save();
    void load();
}

class Report extends Document implements Storable{
    public void print(){
    //implementare dupa caz//
    }
    public void save(){

    }

    public void load(){

    }
}