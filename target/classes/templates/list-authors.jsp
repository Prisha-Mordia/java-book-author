<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>List of Authors</title>
</head>
<body>
<h2>Authors</h2>
<table>
    <tr>
        <th>Name</th>
        <th>Nationality</th>
        <th>Actions</th>
    </tr>
    <tr th:each="author : ${authors}">
        <td th:text="${author.name}">Name</td>
        <td th:text="${author.nationality}">Nationality</td>
        <td>
            <a th:href="@{/authors/edit/{id}(id=${author.id})}">Edit</a>
        </td>
    </tr>
</table>
<a href="/authors/add">Add Author</a>
</body>
</html>
