package com.prakpapb2.kuis;

public class SoalEn {

    //set pertanyaan
    public static String mQuestions [] = {
            "The female national hero from Central Java is ...",
            "Pancasila Sanctity Day is commemorated every ...",
            "Raden Soekemi Sosrodihardjo is married to Ida Ayu Nyoman Rai (from Buleleng, Bali) and has a child. When their child was young, their child lived together in Tulungagung, East Java. At the age of 14, their child was invited to live in Surabaya by Oemar Said Tjokroaminoto and sent to school at HBS (Hoogere Burger School). Who are the children in the question?",
            "November 10 is celebrated as Hero's Day because on November 10, 1945 there was a big battle in Surabaya between the Indonesian army and British troops. The hero who played a role in igniting the fighting spirit of the people of Surabaya was ...",
            "He has worked as a teacher of Malay at an elementary school in Ambarawa, principal of an elementary school in Semarang, and administrative assistant at the City Council in Semarang. He also became the caretaker of Budi Utomo, opened a medical practice in Solo, and founded the Raden Ajeng Kartini Club. He is ..."

    };

    //set jawaban
    private String mChoices [][] = {
            {"Raden Dewi Sartika", "Raden Ajeng Kartini", "Cut Nyak Dhien", "Fatmawati"},
            {"May 1", "June 1", "October 1", "November 1"},
            {"Ki Hajar Dewantara", "Ir. Soekarno", "Raden Ajeng Kartini", "Dr. Tjiptomangunkusumo"},
            {"Bung Karno", "Bung Hatta", "Jenderal Soedirman", "Bung Tomo"},
            {"Dr. Tjiptomangunkusumo", "dr. Soetomo", "Douwes Dekker", "Ki Hajar Dewantara"},
    };

    //set jawaban yang bener
    private String mCorrectAnswers[] = {
            "Raden Ajeng Kartini",
            "October 1",
            "Ir. Soekarno",
            "Bung Tomo",
            "Dr. Tjiptomangunkusumo"
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

    public String getChoice4(int a) {
        String choice3 = mChoices[a][3];
        return choice3;
    }

    public String getCorrectAnswer(int a) {
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
