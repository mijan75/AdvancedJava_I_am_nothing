package bd.ac.seu;

import bd.ac.seu.model.Student;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public Main() {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("1","Mijan", 23));
        studentList.add(new Student("2","Rifat", 21));
        studentList.add(new Student("3","Mim", 2));
        studentList.add(new Student("4","Rezwan", 15));
        studentList.add(new Student("5","Rokon", 13));
        studentList.add(new Student("6","Talha", 43));
        studentList.add(new Student("7","Shafayath", 33));
        studentList.add(new Student("9","Rashel", 23));
        studentList.add(new Student("9","Rabbi", 83));
        studentList.add(new Student("9","Rabbi", 83));
        studentList.add(new Student("10","Jibon", 73));

        List<Student> oldListStudent = studentList.stream().filter(student -> student.getAge() >= 22).collect(Collectors.toList());
        studentList.stream().filter(student -> student.getName().startsWith("M")).filter(student -> student.getAge() >= 22).filter(student -> student.getId().equals("1")).forEach(student -> System.out.println(student.getName()));
        Stream.iterate(1,element -> element+1).filter(element-> element %5 == 0).limit(5).forEach(System.out::println);
        double totalAge = studentList.stream().collect(Collectors.summingDouble(product -> product.getAge()));
        double ageSum = studentList.stream().mapToDouble(Student::getAge).sum();
        System.out.println(totalAge);
        double sum = studentList.stream().count();
        System.out.println(sum);
        Student student = studentList.stream().max((student1,student2) -> student1.getAge() > student2.getAge() ? 1 : -1 ).get();
        System.out.println(student.getName());
        Stream.iterate(1, element -> element + 1).filter(element -> element % 5 == 0).limit(5).forEach(System.out::println);
        Collections.sort(studentList, Comparator.comparing(Student::getAge));
        studentList.stream().map(student1 -> student1.getName()).forEach(System.out::println);
        studentList.stream().filter(distinctByKey(p -> p.getId())).forEach(System.out::println);
        List<Double> list = studentList.stream().filter(p -> p.getAge() > 22).map(pm -> pm.getAge()).collect(Collectors.toList());
        list.forEach(System.out::println);

    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static void main(String[] args){
        new Main();
    }
}
