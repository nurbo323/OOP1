package models;
import java.util.ArrayList;
import java.util.List;

public class School {
    private List<Person> members;

    public School() {
        members = new ArrayList<>();
    }

    public void addMember(Person person) {
        members.add(person);
    }

    @Override
    public String toString() {
        members.sort((p1, p2) -> p1.surname.compareTo(p2.surname));
        StringBuilder sb = new StringBuilder();
        for (Person member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}