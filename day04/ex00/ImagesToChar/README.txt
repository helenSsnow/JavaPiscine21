1)Перейти в папку  ImagesToChar.
2)Ввести в терминале следующую команду:
        javac -d target src/java/edu/school21/printer/logic/Convert.java && javac -classpath target/  -d target src/java/edu/school21/printer/app/Program.java 
    Эта команда позволит создать файлы с расширением .class в папке Target
3)Введите следующую команду java -cp target edu.school21.printer.app.Program --white=. --black=0 --filePath=/Users/ssnowbir/Desktop/JavaPiscine21/day04/ImagesToChar/src/java/edu/school21/printer/app/image.bmp
    Эта команда запускает метод main с параметрамию Первый параметр отвечает за белый цвет, второй за черный цвет, а третий за путь к картинке, которая будет выводиться