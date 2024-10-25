<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Edit Author</title>
</head>
<body>
<h2>Edit Author</h2>
<form action="#" th:action="@{/authors/update/{id}(id=${author.id})}" th:object="${author}" method="post">
    <label>Name: <input type="text" th:field="*{name}" /></label><br>
    <label>Nationality: <input type="text" th:field="*{nationality}" /></label><br>
    <button type="submit">Update Author</button>
</form>
<a href="/authors">Back to List</a>
</body>
</html>
