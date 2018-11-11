package com.fit;

public class POJO {
    String name;
    String type;
    int version;
    public POJO(String name, String type, int version){
        this.name = name;
        this.type = type;
        this.version = version;
    }
    public static boolean isEqual(POJO obj1, POJO obj2){
        if (obj1.name != obj2.name)
            return false;
        return (obj1.type == obj2.type);
    }
    @Override
    public String toString(){
        return name+" "+type+" "+version;
    }
    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()){
            return false;
        }

        POJO object = (POJO) obj;
        if (this.name != object.name)
            return false;
        if (this.type != object.type)
            return false;

        return (this.version == object.version);
    }
    @Override
    public int hashCode() {
        int result = 17;
        result = 31*result + name.hashCode();
        result = 31*result + type.hashCode();
        result = 31*result + version;
        return result;
    }

}
