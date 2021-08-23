1)Перейти в папку  ImagesToChar.
2)Для того чтобы на экране вывод приложения имел цвет необходимо использовать следующую команду:
    mkdir lib && curl -o lib/JCommander.jar https://repo1.maven.org/maven2/com/beust/jcommander/1.81/jcommander-1.81.jar \
    && curl -o lib/JColor.jar https://repo1.maven.org/maven2/com/diogonunes/JColor/5.0.1/JColor-5.0.1.jar
3)Команда:mkdir target && cd target && jar xf ../lib/JCommander.jar com && jar xf ../lib/JColor.jar com && cd ..
    позволит извлечь содержимое архива и положить в папку com

4) javac -d target src/java/edu/school21/printer/logic/Convert.java && javac -classpath target/  -d target src/java/edu/school21/printer/app/Program.java 
    Эта команда позволит создать файлы с расширением .class в папке Target
5) Введите команду cp -r src/resources target 
    она создаст папку resources с картинкой в папке target
4)Введите команду jar cfm target/images-to-char-printer.jar src/manifest.txt -C target .
    команда позволит вам создать архив .jar
5)Теперь чтобы запустить приложение необходимо ввести следующее: java -jar target/images-to-char-printer.jar --white=GREEN --black=BLUE