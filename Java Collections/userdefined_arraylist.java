import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Student
{
  int rollno;
  String name;
  int age;
  Student(int rollno,String name,int age)
  {
    this.rollno = rollno;
    this.name = name;
    this.age = age;
  }
}
class solution
{
  public static void main(String[] args) {
    //creating user defined class objects
    Student s1 =  new Student(101,"Sonoo",23);
    Student s2 =  new Student(102,"Ravi",21);
    Student s3 = new Student(103,"Dinesh",20);
  ArrayList<Student> al = new ArrayList<Student>(); //creating ArrayList
  al.add(s1);
  al.add(s2);
  al.add(s3);
  Iterator itr = al.iterator();
  //traversing elements of ArrayList objects
  while (itr.hasNext())
  {
      Student st = (Student) itr.next();
      System.out.println(st.rollno+" "+st.name+" "+st.age);
  }
  

  }
}
