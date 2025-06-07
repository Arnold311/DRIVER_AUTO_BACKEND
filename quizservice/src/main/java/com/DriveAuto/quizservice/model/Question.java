package com.DriveAuto.quizservice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texte;
    private String options;
    @Column(name = "reponse_correcte")
    private String reponseCorrecte;
    @Column(name = "quiz_id")
    private Long quizId;

    public Question() {
    }

    public Question(Long id, String texte, String options, String reponseCorrecte, Long quizId) {
        this.id = id;
        this.texte = texte;
        this.options = options;
        this.reponseCorrecte = reponseCorrecte;
        this.quizId = quizId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getReponseCorrecte() {
        return reponseCorrecte;
    }

    public void setReponseCorrecte(String reponseCorrecte) {
        this.reponseCorrecte = reponseCorrecte;
    }

    public Long getQuizId() {
        return quizId;
    }

    public void setQuizId(Long quizId) {
        this.quizId = quizId;
    }
}