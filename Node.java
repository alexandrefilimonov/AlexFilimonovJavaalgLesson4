package ru.geekbrains.algjava.lesson4.links;

public class Node {
    public String name;
    public int age;

    // links
    public Node next;
    public Node prev;

    public Node(String name, int age) {
        this.name = name;
        this.age = age; 
    }

    @Override
    public String toString() {
        return "(" +
                "name='" + name + '\'' +
                ", age=" + age +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Node)) return false;
        Node node = (Node) o;
        if (age != node.age) return false;
        return name != null ? name.equals(node.name) : node.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 58 * result + age;
        return result;
    }
}
