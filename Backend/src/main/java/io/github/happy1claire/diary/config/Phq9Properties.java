package io.github.happy1claire.diary.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import java.util.List;

@ConfigurationProperties(prefix = "phq9")
public class Phq9Properties {
    private String code;
    private String version;
    private String locale;
    private Scale scale;
    private List<Question> questions;

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }

    public String getLocale() { return locale; }
    public void setLocale(String locale) { this.locale = locale; }

    public Scale getScale() { return scale; }
    public void setScale(Scale scale) { this.scale = scale; }

    public List<Question> getQuestions() { return questions; }
    public void setQuestions(List<Question> questions) { this.questions = questions; }

    // --- Nested Classes for Structured Properties ---

    public static class Scale {
        private List<Option> options;
        public List<Option> getOptions() { return options; }
        public void setOptions(List<Option> options) { this.options = options; }
    }

    public static class Option {
        private int value;
        private String label;
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
        public String getLabel() { return label; }
        public void setLabel(String label) { this.label = label; }
    }

    public static class Question {
        private int id;
        private String text;
        public int getId() { return id; }
        public void setId(int id) { this.id = id; }
        public String getText() { return text; }
        public void setText(String text) { this.text = text; }
    }

}
