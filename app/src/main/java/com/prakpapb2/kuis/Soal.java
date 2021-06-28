package com.prakpapb2.kuis;

public class Soal {

    //set pertanyaan
    public static String mQuestions [] = {
            "Pahlawan nasional wanita yang berasal dari Jawa Tengah adalah ...",
            "Hari Kesaktian Pancasila diperingati setiap tanggal .............",
            "Raden Soekemi Sosrodihardjo (seorang guru di Surabaya, Jawa Timur) menikah dengan Ida Ayu Nyoman Rai (dari Buleleng, Bali) dan mempunyai seorang anak. Ketika kecil anak mereka tinggal bersama kakeknya di Tulungagung, Jawa Timur. Pada usia 14 tahun, anak mereka diajak  tinggal di Surabaya oleh Oemar Said Tjokroaminoto dan disekolahkan di HBS (Hoogere Burger School). Siapakah anak yang dimaksud?",
            "Tanggal 10 November diperingati sebagai Hari Pahlawan karena pada tanggal 10 November 1945 terjadi pertempuran besar di Surabaya antara tentara Indonesia dan pasukan Inggris. Pahlawan yang berperan mengobarkan semangat juang rakyat Surabaya adalah ...................",
            "Beliau pernah bekerja sebagai guru bahasa Melayu di sebuah sekolah dasar di Ambarawa, kepala sekolah dasar di Semarang, dan pembantu administrasi pada Dewan Kota di Semarang. Beliau juga menjadi pengurus Budi Utomo, membuka praktik dokter di Solo, dan mendirikan Raden Ajeng Kartini Klub. Beliau adalah .................."

    };

    //set jawaban
    private String mChoices [][] = {
            {"Raden Dewi Sartika", "Raden Ajeng Kartini", "Cut Nyak Dhien", "Fatmawati"},
            {"1 Mei", "1 Juni", "1 Oktober", "1 November"},
            {"Ki Hajar Dewantara", "Ir. Soekarno", "Raden Ajeng Kartini", "Dr. Tjiptomangunkusumo"},
            {"Bung Karno", "Bung Hatta", "Jenderal Soedirman", "Bung Tomo"},
            {"Dr. Tjiptomangunkusumo", "dr. Soetomo", "Douwes Dekker", "Ki Hajar Dewantara"},
    };

    //set jawaban yang bener
    private String mCorrectAnswers[] = {
            "Raden Ajeng Kartini",
            "1 Oktober",
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
