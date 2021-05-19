
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author beast
 */

class Candidate {
    String name;
    Integer voteCount;
    
    // Constructor
    public Candidate(String name) {
        this.name = name;
        this.voteCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }
}
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<Candidate> candidates = new ArrayList<>();
        startApp(candidates);
    }
    
    public static void startApp(List<Candidate> candidates) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("What would you like to do?");
        System.out.println("1. Vote");
        System.out.println("2. Add a candidate");
        System.out.println("3. View Results");

        String response = myObj.nextLine();  // Read user input
        if (response.equals("1")){
            vote(candidates);
        } else if (response.equals("2")){
            addCandidate(candidates);
        } else if (response.equals("3")){
            viewResults(candidates);
        }
    }
    
    public static void vote(List<Candidate> candidates){
        System.out.println("Who would you like to vote for?");
        int counter = 0;
        for (Candidate candidate : candidates){
            counter++;
            System.out.println(counter + " " + candidate.name);
        }
        Scanner candidateObj = new Scanner(System.in);
        String candidateNumber = candidateObj.nextLine();
        Integer candidateIndex = Integer.valueOf(candidateNumber) - 1;
        Candidate candidate = candidates.get(candidateIndex);
        Integer candidateCurrentVoteCount = candidate.getVoteCount();
        Integer candidateNewVoteCount = candidateCurrentVoteCount+1;
        candidate.setVoteCount(candidateNewVoteCount);
        System.out.println("*************************************");
        System.out.println("You have voted for " + candidate.name);
        System.out.println("*************************************");
        System.out.println();
        startApp(candidates);
    }
    
    public static void addCandidate(List<Candidate> candidates) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter candidate name");
        
        String name = myObj.nextLine();
        Candidate candidate = new Candidate(name);
        candidates.add(candidate);
        
        
        Scanner newCandidate = new Scanner(System.in);
        System.out.println("Would you like to add another candidate?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        
        String response = newCandidate.nextLine();
        if (response.equals("1")){
            addCandidate(candidates);
        } else {
            startApp(candidates);
        }
    }

    private static void viewResults(List<Candidate> candidates) {
        System.out.println("Candidate \t\t Votes");
        System.out.println("--------- \t\t ----------");
        for (Candidate candidate : candidates){
            System.out.println(candidate.name + " \t\t" + candidate.voteCount);
        }
        System.out.println();
        System.out.println("Press any key to exit");
        Scanner myObj = new Scanner(System.in);
        String key = myObj.nextLine();
        startApp(candidates);
    }
}
