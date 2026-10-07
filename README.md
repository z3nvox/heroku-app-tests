# HerokuApp UI Tests

Практическая работа №12: UI-автотесты для проекта «HerokuApp».

## Стек
- Java 17+
- Maven 3.9+
- Selenium WebDriver 4.x
- TestNG 7.x
- Chrome + Selenium Manager

WebDriverManager не используется: современные версии Selenium умеют автоматически получать подходящий драйвер через Selenium Manager.

## Структура
```text
src/test/java/ru/herokuapp/
├── base/TestBase.java
├── pages/
│   ├── AddRemoveElementsPage.java
│   ├── CheckboxesPage.java
│   ├── DropdownPage.java
│   ├── InputsPage.java
│   ├── TyposPage.java
│   ├── SortableDataTablesPage.java
│   ├── HoversPage.java
│   └── NotificationMessagesPage.java
└── tests/
    ├── AddRemoveElementsTest.java
    ├── CheckboxesTest.java
    ├── DropdownTest.java
    ├── InputsTest.java
    ├── TyposTest.java
    ├── SortableDataTablesTest.java
    ├── HoversTest.java
    └── NotificationMessagesTest.java
```

## Запуск
Обычный запуск:
```bash
mvn clean test
```

Headless:
```bash
mvn clean test -Dheadless=true
```

Другой браузер в этой версии проекта не настраивается: задание допускает Chrome/Firefox, а проект рассчитан на Chrome.

## Surefire
После запуска отчёты находятся в:
```text
target/surefire-reports/
```

## Git
Рекомендуемый поток:
```bash
git init
git add .
git commit -m "chore: initialize Maven Selenium project"
git checkout -b feature/<группа>_<фамилия>_selenium
git add .
git commit -m "test: add HerokuApp UI scenarios"
git push -u origin feature/<группа>_<фамилия>_selenium
```

Затем создайте Pull Request и добавьте ментора в Reviewers.
