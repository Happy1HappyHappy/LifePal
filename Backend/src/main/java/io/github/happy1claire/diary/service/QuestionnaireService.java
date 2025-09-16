package io.github.happy1claire.diary.service;

import io.github.happy1claire.diary.config.Phq9Properties;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class QuestionnaireService {
    /**
     * Holds all the PHQ-9 questionnaire settings loaded from application.yml.
     * Declared as final to ensure it's initialized in the constructor.
     */
    private final Phq9Properties phq9Config;

    /**
     * A lookup map for quick access to an Option based on its integer value.
     * This is built once at service startup to avoid searching the list every time.
     */
    private final Map<Integer, Phq9Properties.Option> optionLookup;

    /**
     * The primary constructor, used for dependency injection.
     * Spring Boot will automatically find the Phq9Properties bean and pass it in.
     */
    public QuestionnaireService(Phq9Properties phq9Config) {
        this.phq9Config = phq9Config;
        // Pre-process the options into a map upon service creation for better performance.
        this.optionLookup = buildOptionLookupMap(phq9Config);
        System.out.println("QuestionnaireService initialized for questionnaire: " + phq9Config.getCode());
    }

    /**
     * Provides the full PHQ-9 questionnaire structure to external components (e.g., a Controller).
     */
    public Phq9Properties getPhq9Questionnaire() {
        return this.phq9Config;
    }

    /**
     * Calculates the total score based on a list of user answers.
     */
    public int calculatePhq9Score(List<AnswerDto> answers) {
        if (answers == null || answers.isEmpty()) {
            return 0;
        }

        return answers.stream()
                .mapToInt(answer -> {
                    Phq9Properties.Option option = optionLookup.get(answer.getSelectedValue());
                    // Use the option's value as the score if found, otherwise the score is 0.
                    return option != null ? option.getValue() : 0;
                })
                .sum();
    }

    /**
     * Provides a clinical interpretation based on the total score.
     */
    public String getScoreInterpretation(int totalScore) {
        if (totalScore >= 0 && totalScore <= 4) {
            return "Minimal or no depression";
        } else if (totalScore >= 5 && totalScore <= 9) {
            return "Mild depression";
        } else if (totalScore >= 10 && totalScore <= 14) {
            return "Moderate depression";
        } else if (totalScore >= 15 && totalScore <= 19) {
            return "Moderately severe depression";
        } else if (totalScore >= 20 && totalScore <= 27) {
            return "Severe depression";
        } else {
            return "Score is out of the normal range";
        }
    }

    /**
     * A private helper method called in the constructor.
     * It efficiently converts the list of options from the config into a Map for fast lookups.
     */
    private Map<Integer, Phq9Properties.Option> buildOptionLookupMap(Phq9Properties config) {
        if (config == null || config.getScale() == null || config.getScale().getOptions() == null) {
            return Map.of(); // Return an empty, immutable map
        }
        // Use the Java Stream API to convert a List<Option> into a Map<Value, Option>
        return config.getScale().getOptions().stream()
                .collect(Collectors.toMap(Phq9Properties.Option::getValue, Function.identity()));
    }
}