<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>
<form action="#" th:action="@{/books/update/{id}(id=${book.id})}" th:object="${book}" method="post">
    <label>Title: <input type="text" th:field="*{title}" /></label><br>
    <label>Genre: <input type="text" th:field="*{genre}" /></label><br>
    <label>Author:
        <select th:field="*{author}">
            <option th:each="author : ${authors}" th:value="${author}" th:text="${author.name}">Author</option>
        </select>
    </label><br>
    <button type="submit">Update Book</button>
</form>
<a href="/books">Back to List</a>
</body>
</html>
