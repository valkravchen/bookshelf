package com.dobrynya.hellospring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
/**
 * Принимает HTTP-запросы и возвращает ответы
 * Каждый запрос содержит метод - что хотим сделать:
 *      GET - получить данные
 *      POST - создать что-то новое
 *      PUT - обновить существующее
 *      DELETE - удалить
 * Каждый метод контроллера обрабатывает определённый запрос
 * @RestController говорит Spring:
 *      Это контроллер для REST API
 **/
public class HelloController {

    @GetMapping("/api/hello")
    /**
     * Этот метод вызывается при GET-запросе на /api/hello
     *      GET /api/hello
     *          ↓
     *      Spring Boot смотрит: кто обрабатывает GET на /api/hello?
     *          ↓
     *      Находит метод с @GetMapping("/api/hello")
     *          ↓
     *      Вызывает этот метод
     *          ↓
     *      Возвращает результат клиенту
     */
    public String sayHello() {
        return "Привет, мир!";
    }

    @GetMapping("/api/status")
    public String status() {
        return "Сервер работает";
    }

    @GetMapping("/api/greet")
    public String greet(@RequestParam String name) {
        /**
         * @RequestParam String name берёт значение параметра
         * name из URL
         * http://localhost:8080/api/greet?name=имя
         * Всё после ? - это параметры
         * Формат: ключ=значение
         * Несколько параметров разделяются &
         * GET /api/books?status=READING&year=2022
         */
        return "Привет, " + name + "!";
    }

//    @GetMapping("/api/books/{id}")
    public String getBook(@PathVariable Long id) {
        /**
         * {id} в пути — это переменная
         * @PathVariable Long id - Spring извлекает значение из пути
         * GET /api/books/42
         * Здесь 42 — это часть пути, идентификатор конкретной книги
         * {id} в пути — это placeholder (заполнитель)
         * Spring подставляет реальное значение из URL в переменную id
         */
        return "Запрошена книга с id: " + id;
    }
}
