package com.prakpapb2.kuis;

public class Soal {

    //set pertanyaan
    public static String mQuestions [] = {
            "Reog adalah salah satu kesenian jawa yang berasal dari...",
            "Tokoh pada Reog Ponorogo digambarkan sebagai Prajurit Berkuda dinamakan...",
            "Raja Kelono yang merupakan salah satu tokoh dari Reog Ponorogo adalah seorang raja sakti mandraguna yang memiliki pusaka...",
            "Kesenian Ketoprak adalah seni pertunjukan tradisional rakyat Jawa berasal dari...",
            "Wayang kulit terbuat dari kulit hewan...",

    };

    //set jawaban
    private String mChoices [][] = {
            {"Jawa Tengah", "Jawa Barat", "Jawa Timur"},
            {"Jathil", "Warok", "Barongan"},
            {"Kyai Pecut Semendiman", "Kyai Kecut Samandiman", "Kyai Pecut Samandiman"},
            {"Jawa Barat", "DI Yogyakarta", "Jawa Tengah"},
            {"Kerbau", "Sapi", "Kuda"},
    };

    //set jawaban yang bener
    private String mCorrectAnswers[] = {
            "Jawa Timur",
            "Jathil",
            "Kyai Pecut Samandiman",
            "Jawa Tengah",
            "Kerbau"
    };


    public String getQuestion(int a) {
        String question = mQuestions[a];
        return question;
    }

    public String getChoice1(int a) {
        String choice0 = mChoices[a][0];
        return choice0;
    }


    public String getChoice2(int a) {
        String choice1 = mChoices[a][1];
        return choice1;
    }

    public String getChoice3(int a) {
        String choice2 = mChoices[a][2];
        return choice2;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }
}
