Тестовый проект. Состоит из 5ти таблиц:
user_profile - фио, дата рождения пользователя
user_credentials - логин и пароль пользователя
user_education - где учился пользователя
registration_address - адрес прописки
city_info - информация по города проживания
Связи и поля таблиц указаны на рисунки снизу


<img width="786" height="846" alt="image" src="https://github.com/user-attachments/assets/ea057dd6-ecb4-446c-9825-5247849da04b" />

Проект работает на Java 17(образ для контейнера: eclipse-temurin:17-jre-alpine). База данных PostgreSQL15. Spring в качестве фреймворка(доступ к базе, документирование). Также используется JdbcTemplate для прямых запросов к базе.
Swagger, после запуска приложение/контейнера доступен по адресу http://localhost:8080/swagger‑ui.html.
При запуске через docker-compose, доступен pgAdmin по адресу http://localhost:5050. Данные для входа: логин:test@mail.ru пароль:9876


