package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void testEqualsWithSelf() {
        assertEquals(true,team.equals(team));
    }

    @Test 
    public void testEquals_wrongObj () {
        Object obj = new Object();
        assertEquals(false, team.equals(obj));
    }

    @Test 
    public void testEquals_with_sameName_wrong_members() {
        Team different_team = new Team("test-team");
        team.addMember("jack");
        assertEquals(false, team.equals(different_team));
    }

    @Test 
    public void testEquals_with_sameName_same_members() {
        Team different_team = new Team("test-team");
        assertEquals(true, team.equals(different_team));
    }

    @Test 
    public void testEquals_with_wrongName_same_members() {
        Team different_team = new Team("test-team-Alpha");
        assertEquals(false, team.equals(different_team));
    }

    @Test 
    public void testEquals_with_wrongName_wrong_members() {
        Team different_team = new Team("test-team-Alpha");
        different_team.addMember("Jack");
        assertEquals(false, team.equals(different_team));
    }

    @Test
    public void testHashcode_equivalentMutation() {
        // instantiate t as a Team object
        int result = team.hashCode();
        int expectedResult = -1226298695; // told to use this to overcome known mutation testing issue (equivalent mutation). ""
        assertEquals(expectedResult, result);
    }

    @Test
    public void testHashcode() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");
        Team t2 = new Team();
        t2.setName("foo");
        t2.addMember("bar");
        assertEquals(t1.hashCode(), t2.hashCode());     
    }

    


    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
