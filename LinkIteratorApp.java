package ru.geekbrains.algjava.lesson4.links;

class Link{
    public String name;
    public int age;

    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }
}
class LinkedList{
    private Link first;


    public LinkedList(){
        first = null;

    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public LinkInterator getIterator(){
        return new LinkInterator(this);
    }

    public boolean isEmpty(){
        return (first == null);
    }

    public void display(){
        Link current = first;
        while(current != null){
            current.display();
            current = current.next;
        }
    }
}

class LinkInterator{
    private Link current;
    private Link previous;
    private LinkedList list;

    public LinkInterator(LinkedList list){
        this.list = list;
        this.reset();
    }

    public void reset(){
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return (current.next == null);
    }

    public void nextLink(){
        previous = current;
        current = current.next;
    }

    public Link getCurrent(){
        return current;
    }

    public void insertAfter(String name, int age){
        Link newLink = new Link(name, age);
        if (list.isEmpty()){
            list.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            nextLink();
        }
    }

    public void insertBefore(String name, int age){
        Link newLink = new Link(name, age);
        if(previous == null){
            newLink.next = list.getFirst();
            list.setFirst(newLink);
            reset();
        }
        else{
            newLink.next = previous.next;
            previous.next = newLink;
            current = newLink;
        }
    }

    public String deleteCurrent(){
        String name = current.name;
        if (previous == null){
            list.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()){
                reset();
            } else {
                current = current.next;
            }
        }

        return name;
    }

}

public class LinkIteratorApp {


    public static void main(String[] args) {
        //  1. reset() – перемещение в начало списка;
        //  2. ++nextLink() – перемещение итератора к следующему элементу;
        //	3. ++getCurrent() – получение элемента, на который указывает итератор;
        //  4. ++atEnd() – возвращает true, если итератор находится в конце списка;
        //  5. ++insertAfter() – вставка элемента после итератора;
        //  6. ++insertBefore() – втсавка элемента до итератора;
        //  7. ++deleteCurrent() – удаление элемента в текущей позиции итератора.

        LinkedList list = new LinkedList();
        LinkInterator itr = new LinkInterator(list);

        itr.insertAfter("Artem", 20);
        itr.insertBefore("Sergey", 10);
        itr.insertBefore("Ivan", 15);
        list.display();

        itr.reset();
        System.out.println("\nIs iterator at the end of the list? "+itr.atEnd());

        itr.getCurrent();
        System.out.println("\nCurrent element of Iterator is ");
        System.out.println("Name: "+itr.getCurrent().name+", age: "+itr.getCurrent().age);

        itr.nextLink();
        itr.getCurrent();
        System.out.println("\nNext element of Iterator is ");
        System.out.println("Name: "+itr.getCurrent().name+", age: "+itr.getCurrent().age);

        System.out.println("\nDelete current! ");
        itr.deleteCurrent();

        System.out.println("\nDisplay LinkInterator after deletion:");
        list.display();


    }

}

