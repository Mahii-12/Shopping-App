package com.example.demo.controller;

@RestController
public class QuizSubmissionController {
	@Autowired
    private QuizRepository quizRepository;

    @Autowired
    private OptionRepository optionRepository;

    @PostMapping("/{quizId}")
    public ResponseEntity<String> submitQuiz(@PathVariable Long quizId, @RequestBody Map<String, String> submission) {
        Quiz quiz = quizRepository.findById(quizId).orElse(null);

        if (quiz == null) {
            return new ResponseEntity<>("Quiz not found", HttpStatus.NOT_FOUND);
        }

        // Process submission and perform validation or scoring logic here

        return new ResponseEntity<>("Quiz submitted successfully", HttpStatus.OK);
    }
}
