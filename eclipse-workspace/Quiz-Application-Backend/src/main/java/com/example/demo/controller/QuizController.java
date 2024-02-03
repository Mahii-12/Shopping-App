package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Question;
import com.example.demo.model.Quiz;
import com.example.demo.model.User;
import com.example.demo.repository.OptionRepo;
import com.example.demo.repository.QuestionRepo;
import com.example.demo.repository.QuizRepo;
import com.example.demo.repository.UserRepo;

import ch.qos.logback.core.model.Model;

public class QuizController {
	@Autowired
    private UserRepo userRepository;

    @Autowired
    private QuizRepo quizRepository;

    @Autowired
    private QuestionRepo questionRepository;

    @Autowired
    private OptionRepo optionRepository;

    @GetMapping("/create")
    public String showCreateQuizForm(Model model) {
        List<User> users = userRepository.findAll();
        List<Question> questions = questionRepository.findAll();
        
        model.addAttribute("quiz", new Quiz());
        model.addAttribute("users", users);
        model.addAttribute("questions", questions);
        
        return "createQuiz";
    }

    @PostMapping("/create")
    public String createQuiz(@ModelAttribute("quiz") Quiz quiz, @RequestParam("userId") Long userId,
                             @RequestParam("questionIds") List<Long> questionIds) {
        User user = userRepository.findById(userId).orElseThrow();
        quiz.setUser(user);

        List<Question> selectedQuestions = questionRepository.findAllById(questionIds);
        quiz.setQuestions(selectedQuestions);

        quizRepository.save(quiz);
        return "redirect:/quizzes/view/" + quiz.getId();
    }

    @GetMapping("/view/{quizId}")
    public String viewQuiz(@PathVariable Long quizId, Model model) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow();
        model.addAttribute("quiz", quiz);
        return "viewQuiz";
    }
}
