package org.example.lecture3;


public class Cat implements Comparable<CatClass>{
    private String name;
    private int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", age=" + age + '}';
    }
    @Override
    public boolean equals(Object obj){ // consistency with compareTo
        if(obj instanceof CatClass){
            CatClass otherCat = (CatClass)obj;
//            if(name.equals(otherCat.getName()))
                return true;
        }
        return false;
    }
    @Override
    public int compareTo(CatClass otherCat){ // natural sort order is by name
//        return name.compareTo(otherCat.getName());
        return 0;
    }
}
