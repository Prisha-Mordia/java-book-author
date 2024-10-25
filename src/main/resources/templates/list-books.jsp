<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>List of Books</title>
</head>
<body>
<h2>Books</h2>
<table>
    <tr>
        <th>Title</th>
        <th>Genre</th>
        <th>Author</th>
        <th>Actions</th>
    </tr>
    <tr th:each="book : ${books}">
        <td th:text="${book.title}">Title</td>
        <td th:text="${book.genre}">Genre</td>
        <td th:text="${book.author.name}">Author Name</td>
        <td>
            <a th:href="@{/books/edit/{id}(id=${book.id})}">Edit</a>
        </td>
    </tr>
</table>
<a href="/books/add">Add Book</a>
</body>
</html>
