Тестовый проект. Состоит из 5ти таблиц:
user_profile - фио, дата рождения пользователя
user_credentials - логин и пароль пользователя
user_education - где учился пользователя
registration_address - адрес прописки
city_info - информация по города проживания
Связи и поля таблиц указаны на рисунки снизу


<img width="786" height="846" alt="image" src="https://github.com/user-attachments/assets/ea057dd6-ecb4-446c-9825-5247849da04b" />

Проект работает на Java 17(образ для контейнера: eclipse-temurin:17-jre-alpine). База данных PostgreSQL15. Spring в качестве фреймворка(доступ к базе, документирование). Также используется JdbcTemplate для прямых запросов к базе.
Swagger, после запуска приложение/контейнера доступен по адресу http://localhost:8080/swagger-ui/index.html.
При запуске через docker-compose, доступен pgAdmin по адресу http://localhost:5050. Данные для входа: логин:test@mail.ru пароль:9876. Первый запуск долгий, так что подождите.
Для соединения к базе данных через pgAdmin, необходимо после запуска и входа в аккаунт pgAdmin, нажать правой кнопкой мыши на иконку "Servers" и выбрать пункты "Register" -> "Server..."
<img width="588" height="345" alt="image" src="https://github.com/user-attachments/assets/d4c51d67-5d42-440e-85b2-d89fee8a3288" />


После вводим название сервера(можно любое)
<img width="709" height="555" alt="image" src="https://github.com/user-attachments/assets/4f355391-c6af-47e7-8e52-f1c779f790d0" />

Далее вводим: 
Host name/address: postgres_container
Port: 5432
Username: user
Password: 1234
<img width="713" height="562" alt="image" src="https://github.com/user-attachments/assets/bd0026c6-17b4-496b-a72d-1b528fb4014f" />



Саму база данных данными не заполнял, если надо, то могу.






