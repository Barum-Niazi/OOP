import java.util.Scanner;

class VoteRecorder {

    static String nameCandidateP1, nameCandidateP2, nameCandidateVP1, nameCandidateVP2;

    static int votesCandidateP1, votesCandidateP2, votesCandidateVP1, votesCandidateVP2;

    Scanner input = new Scanner(System.in);

    enum myVoteforPresident {
        CANDIDATE1,
        CANDIDATE2,
        NONE;
    }

    enum myVoteforVicePresident {
        CANDIDATE1,
        CANDIDATE2,
        NONE;
    }

    myVoteforPresident myVoteP = myVoteforPresident.NONE;
    myVoteforVicePresident myVoteVP = myVoteforVicePresident.NONE;

    static void setCandidatesPresident(String name1, String name2) {
        nameCandidateP1 = name1;
        nameCandidateP2 = name2;
    }

    static void setCandidatesVicePresident(String name1, String name2) {
        nameCandidateVP1 = name1;
        nameCandidateVP2 = name2;
    }

    public void getAndConfirmVotes() {
        System.out
                .println("Input 1 to vote for only presidential candidates, 2 for only vice presidents and 3 for both");
        int x = input.nextInt();
        if (x == 1)
            getAVote(nameCandidateP1, nameCandidateP2);
        if (x == 2)
            getAVote(nameCandidateVP1, nameCandidateVP2);
        if (x == 3)
            getVotes();

        confirmVote();
    }

    private void getAVote(String name1, String name2) {
        System.out.printf("Select your candidate\n 1: %s \n 2: %s\n (input 3 for no choice)\n ", name1, name2);
        if (name1.equals(nameCandidateP1)) {
            int x = input.nextInt();
            if (x == 1) {
                myVoteP = myVoteforPresident.CANDIDATE1;
            }
            if (x == 2) {
                myVoteP = myVoteforPresident.CANDIDATE2;
            }
            if (x == 3) {
                myVoteP = myVoteforPresident.NONE;
            }
        }
        if (name1.equals(nameCandidateVP1)) {
            int vp = input.nextInt();
            if (vp == 1) {
                myVoteVP = myVoteforVicePresident.CANDIDATE1;
            }
            if (vp == 2) {
                myVoteVP = myVoteforVicePresident.CANDIDATE2;
            }
            if (vp == 3) {
                myVoteVP = myVoteforVicePresident.NONE;
            }
        }
    }

    private void getVotes() {
        System.out.println("For Presidents: ");
        System.out.println("Input 1 for: " + nameCandidateP1);
        System.out.println("Input 2 for: " + nameCandidateP2);
        System.out.println("Input 3 for no vote");
        int p = input.nextInt();
        if (p == 1)
            myVoteP = myVoteforPresident.CANDIDATE1;
        if (p == 2)
            myVoteP = myVoteforPresident.CANDIDATE2;
        if (p == 3)
            myVoteP = myVoteforPresident.NONE;

        System.out.println("For Vice Presidents: ");
        System.out.println("Input 1 for: " + nameCandidateVP1);
        System.out.println("Input 2 for: " + nameCandidateVP2);
        System.out.println("Input 3 for no vote");
        int vp = input.nextInt();
        if (vp == 1)
            myVoteVP = myVoteforVicePresident.CANDIDATE1;
        if (vp == 2)
            myVoteVP = myVoteforVicePresident.CANDIDATE2;
        if (vp == 3)
            myVoteVP = myVoteforVicePresident.NONE;
    }

    private void recordVotes() {
        if (myVoteP == myVoteP.CANDIDATE1)
            votesCandidateP1++;
        if (myVoteP == myVoteP.CANDIDATE2)
            votesCandidateP2++;
        if (myVoteVP == myVoteVP.CANDIDATE1)
            votesCandidateVP1++;
        if (myVoteVP == myVoteVP.CANDIDATE2)
            votesCandidateVP2++;
    }

    private void confirmVote() {
        if (myVoteP == myVoteP.CANDIDATE1) {
            System.out.println("Your vote for president is: " + nameCandidateP1);
        }
        if (myVoteP == myVoteP.CANDIDATE2) {
            System.out.println("Your vote for president is: " + nameCandidateP2);
        }
        if (myVoteVP == myVoteVP.CANDIDATE1) {
            System.out.println("Your vote for vice president is: " + nameCandidateVP1);
        }
        if (myVoteVP == myVoteVP.CANDIDATE2) {
            System.out.println("Your vote for vice president is: " + nameCandidateVP2);
        }
        if (myVoteP == myVoteP.NONE) {
            System.out.println("You did not vote for any President");
        }
        if (myVoteVP == myVoteVP.NONE) {
            System.out.println("You did not vote for any Vice President");
        }
        System.out.println("If you are happy with your choice input 1 else input any other number");
        int happy = input.nextInt();
        if (happy == 1) {
            recordVotes();
        } else {
            myVoteP = myVoteforPresident.NONE;
            myVoteVP = myVoteforVicePresident.NONE;
            System.out.println("Re-enter your votes");
            getAndConfirmVotes();
        }
    }

    static void displayResults() {
        System.out.println("Votes for " + nameCandidateP1 + " are: " + votesCandidateP1);
        System.out.println("Votes for " + nameCandidateP2 + " are: " + votesCandidateP2);
        System.out.println("Votes for " + nameCandidateVP1 + " are: " + votesCandidateVP1);
        System.out.println("Votes for " + nameCandidateVP2 + " are: " + votesCandidateVP2);

    }

    static void resetVotes() {
        votesCandidateP1 = 0;
        votesCandidateP2 = 0;
        votesCandidateVP1 = 0;
        votesCandidateVP2 = 0;
    }

    static void getCurrentVotePresident() {
        System.out.println("Votes for Presidential Candidates: ");
        System.out.println(nameCandidateP1 + ": " + votesCandidateP1);
        System.out.println(nameCandidateP2 + ": " + votesCandidateP2);
    }

    static void getCurrentVoteVicePresident() {
        System.out.println("Votes for Vice President Candidates: ");
        System.out.println(nameCandidateVP1 + ": " + votesCandidateVP1);
        System.out.println(nameCandidateVP2 + ": " + votesCandidateVP2);
    }
}

public class Votes {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter the name of your candidates for President ");
        VoteRecorder.setCandidatesPresident(input.nextLine(), input.nextLine());

        System.out.println("Enter the name of your candidates for Vice President: ");
        VoteRecorder.setCandidatesVicePresident(input.nextLine(), input.nextLine());

        int choice = 0;
        do {
            System.out.println("To look at current votes for Presidents enter 1: ");
            System.out.println("To look at current votes for Vice Presidents enter 2: ");
            System.out.println("To continue voting enter 3");
            System.out.println("To reset all votes enter 4");
            System.out.println("To stop voting and view results enter -1");
            choice = input.nextInt();
            if (choice == 1)
                VoteRecorder.getCurrentVotePresident();
            if (choice == 2)
                VoteRecorder.getCurrentVoteVicePresident();
            if (choice == 3) {
                VoteRecorder vote = new VoteRecorder();
                vote.getAndConfirmVotes();
            }
            if (choice == 4)
                VoteRecorder.resetVotes();
        } while (choice != -1);

        VoteRecorder.displayResults();
    }
}
