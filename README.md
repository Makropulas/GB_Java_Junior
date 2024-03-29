## Урок 1. Лямбды и Stream API

### 1. [Напишите программу](src/main/java/dz1/task1/AverageOfEvenNumbers.java), которая использует Stream API для обработки списка чисел. Программа должна вывести на экран среднее значение всех четных чисел в списке.
### 2. [Переработать метод](src/main/java/dz1/task2/Cart.java) балансировки корзины товаров cardBalancing() с использованием Stream API

## Урок 2. Reflection API

### 1. [Задача 1:](src/main/java/dz2/task1)
Создайте абстрактный класс "Animal" с полями "name" и "age".\
Реализуйте два класса-наследника от "Animal" (например, "Dog" и "Cat") с уникальными полями и методами.\
Создайте массив объектов типа "Animal" и с использованием Reflection API выполните следующие действия:\
Выведите на экран информацию о каждом объекте.\
Вызовите метод "makeSound()" у каждого объекта, если такой метод присутствует.
### 2. [Дополнительная задача:](src/main/java/dz2/task2/QueryBuilder.java)
Доработайте метод генерации запроса на удаление объекта из таблицы БД (`DELETE FROM <Table> WHERE ID = '<id>'`) в классе QueryBuilder, который мы разработали на семинаре.

## Урок 3. Сериализация

### 1. [Задача 1:](src/main/java/dz3/task1)
Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).\
Обеспечьте поддержку сериализации для этого класса.\
Создайте объект класса Student и инициализируйте его данными.\
Сериализуйте этот объект в файл.\
Десериализуйте объект обратно в программу из файла.\
Выведите все поля объекта, включая GPA, и ответьте на вопрос,\
почему значение GPA не было сохранено/восстановлено.
### 2. [Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).](src/main/java/dz3/task2/Program.java)

## Урок 4. Базы данных и инструменты взаимодействия с ними

###  Работа с [JDBC](src/main/java/dz4/CreatingTable.java) и [Hibernate](src/main/java/dz4/WorkingWithTable.java)
Создайте базу данных (например, SchoolDB).\
В этой базе данных создайте таблицу Courses с полями id (ключ), title, и duration.\
Настройте Hibernate для работы с вашей базой данных.\
Создайте Java-класс Course, соответствующий таблице Courses, с необходимыми аннотациями Hibernate.\
Используя Hibernate, напишите код для вставки, чтения, обновления и удаления данных в таблице Courses.\
Убедитесь, что каждая операция выполняется в отдельной транзакции.

## Урок 5. Клиент/Сервер своими руками

###  [Разработайте простой чат](src/main/java/dz5) на основе сокетов как это было показано на самом семинаре.
Ваше приложение должно включать в себя сервер, который принимает сообщения от клиентов и пересылает их всем участникам чата.\
Подумайте, как организовать отправку ЛИЧНЫХ сообщений в контексте нашего чата, доработайте поддержку отправки личных сообщений
####  Примечание - Для тестирования работоспособности, запуск осуществлять через конфигурацию [RunChat](.idea/runConfigurations/RunChat.xml).