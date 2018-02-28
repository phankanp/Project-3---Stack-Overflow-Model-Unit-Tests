package com.teamtreehouse.techdegree.overboard.model;

import com.teamtreehouse.techdegree.overboard.exc.AnswerAcceptanceException;
import com.teamtreehouse.techdegree.overboard.exc.VotingException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class UserTest {

    private User questionUser;
    private User upVoteUser;
    private Board board;
    private Question question;
    private User answerUser;
    private Answer answer;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        board = new Board("Computer Science Board");
        questionUser = new User(board, "Questioner");
        upVoteUser = new User(board, "Upvoter");
        answerUser = new User(board, "Answerer");
        question = questionUser.askQuestion("Computer Science question?");
        answer = answerUser.answerQuestion(question, "Computer Science is awesome!");

    }

    // Tests if the questioner's reputation goes up by 5 points when the question is upvoted
    @Test
    public void questionersReputationGoesUpIfQuestionIsUvoted() {
        upVoteUser.upVote(question);

        assertEquals(5, questionUser.getReputation());

    }

    // Tests if the answerer's reputation goes up by 10 points if the answer is upvoted
    @Test
    public void answersReputationGoesUpIfQuestionIsUpvoted() {
        upVoteUser.upVote(answer);

        assertEquals(10, answerUser.getReputation());
    }

    // Tests that the answerer's gets a 15 point reputation boost if the answer is accepted
    @Test
    public void acceptedAnswerGivesReputationBoost() {
        questionUser.acceptAnswer(answer);

        assertEquals(15, answerUser.getReputation());
    }

    // Test that an exception is thrown if the question up votes own question
    @Test
    public void questionerUpVoteIsNotAllowed() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot vote for yourself!");

        questionUser.upVote(question);

    }

    // Test that an exception is thrown if the question down votes own question
    @Test
    public void questionerDownVoteIsNotAllowed() throws Exception {
        thrown.expect(VotingException.class);
        thrown.expectMessage("You cannot down vote yourself!");

        questionUser.downVote(question);

    }

    // Tests that exception is thrown if the if anyone but the questioner tries to accept the answer
    @Test
    public void onlyQuestionerCanAcceptAnswer() {
        thrown.expect(AnswerAcceptanceException.class);
        thrown.expectMessage("Only Questioner can accept this answer as it is their question");

        answerUser.acceptAnswer(answer);
    }
}