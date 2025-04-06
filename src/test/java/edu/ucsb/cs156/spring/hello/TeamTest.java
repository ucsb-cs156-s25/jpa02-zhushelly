package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        assertEquals(true, team.equals(team));
    }

    @Test
    public void equals_differentClass_returnsFalse() {
        String notATeam = "I am not a team";
        assertEquals(false, team.equals(notATeam));
    }

    @Test
    public void equals_sameNameDifferentMembers_returnsFalse() {
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_differentNameSameMembers_returnsFalse() {
        team.addMember("Alice");
        Team other = new Team("different-team");
        other.addMember("Alice");
        assertEquals(false, team.equals(other));
    }

    @Test
    public void equals_sameNameAndMembers_returnsTrue() {
        team.addMember("Alice");
        Team other = new Team("test-team");
        other.addMember("Alice");
        assertEquals(true, team.equals(other));
    }

    @Test
    public void hashCode_sameContent_sameHashCode() {
        team.setName("foo");
        team.addMember("bar");

        Team other = new Team("foo");
        other.addMember("bar");

        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void hashCode_specificValues_returnsExpectedValue() {
        Team t = new Team("foo");

        ArrayList<String> members = new ArrayList<String>();
        members.add("bar");
        t.setMembers(members);

        int expected = "foo".hashCode() | members.hashCode();

        assertEquals(expected, t.hashCode());
    }
}
