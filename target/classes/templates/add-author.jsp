<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Add Author</title>
</head>
<body>
<h2>Add a New Author</h2>
<form action="#" th:action="@{/authors/add}" th:object="${author}" method="post">
    <label>Name: <input type="text" th:field="*{name}" /></label><br>
    <label>Nationality: <input type="text" th:field="*{nationality}" /></label><br>
    <button type="submit">Add Author</button>
</form>
<a href="/authors">Back to List</a>
</body>
</html>
