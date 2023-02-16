package com.heeron.example.javaatubuntu.dto;

public class Person {

  private String name;
  private int age;
  private byte gender;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public byte getGender() {
    return gender;
  }

  public void setGender(byte gender) {
    this.gender = gender;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + age;
    result = prime * result + gender;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Person other = (Person) obj;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (age != other.age)
      return false;
    if (gender != other.gender)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", age=" + age + ", gender=" + gender + "]";
  }
}
