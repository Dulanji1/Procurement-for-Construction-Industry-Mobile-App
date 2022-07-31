package com.example.cssemobileapp.Model;

import com.example.cssemobileapp.utils.QuestionTypes;

import java.util.List;

public class Questions {
    private String timeStamp;
    private String questionName;
    private List<Options> options ;
    private QuestionTypes type;

    public Questions(String _timeStamp, String questionName, List<Options> _options, QuestionTypes _type) {
        timeStamp = _timeStamp;
        this.questionName = questionName;
        this.options = _options;
        this.type = _type;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getQuestionName() {
        return questionName;
    }

    public void setQuestionName(String questionName) {
        this.questionName = questionName;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public QuestionTypes getType() {
        return type;
    }

    public void setType(QuestionTypes type) {
        this.type = type;
    }
}
