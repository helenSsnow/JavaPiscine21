1)Перейти в папку  ImagesToChar.
2)Ввести в терминале следующую команду:
        javac -d target src/java/edu/school21/printer/logic/Convert.java && javac -classpath target/  -d target src/java/edu/school21/printer/app/Program.java 
    Эта команда позволит создать файлы с расширением .class в папке Target
3) Введите команду cp -r src/resources target 
    она создаст папку resources с картинкой в папке target
4)Введите команду jar cfm target/images-to-char-printer.jar src/manifest.txt -C target .
    команда позволит вам создать архив .jar
5)Теперь чтобы запустить приложение необходимо ввести следующее: java -jar target/images-to-char-printer.jar --white=. --black=0 --filePath=target/resources/image.bmp