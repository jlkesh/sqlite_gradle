package uz.jl;

import jakarta.persistence.*;
import lombok.*;
import uz.jl.domains.Subject;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String questionBody;

    @Builder.Default
    @Column(nullable = false)
    private Level level = Level.EASY;

    @Builder.Default
    @Column(nullable = false)
    private Language language = Language.EN;

    @ManyToOne
    private Subject subject;

    public enum Level {
        EASY, MEDIUM, HARD
    }

    @Getter
    @AllArgsConstructor
    public enum Language {
        UZ("O'zbek", "Узбек", "Uzbek"),
        RU("Rus", "Русский", "Russian"),
        EN("Ingliz", "Английский", "English");

        private final String uz;
        private final String ru;
        private final String en;
    }

}
