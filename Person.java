public class Person {
    String name;
    int age;
    String nationality;

    public Person(String name, String nationality, int age) {
        this.name = name;
        this.age = age;
        this.nationality = nationality;

    }

    public String getName(){
        return name;
    }

    public String getNationality(){
        return nationality;
    }

    public Integer getAge(){
        int age = this.age;
        return age;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", age=" + age +
                '}';
    }
}


