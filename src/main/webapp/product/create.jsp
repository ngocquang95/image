<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <form action="product" method="POST" enctype="multipart/form-data">
        <label for="name" class="form-label">Name:</label>
        <input type="text" class="form-control" name="name" id="name">
        <br>
        <label for="image" class="form-label">Image:</label>
        <input type="file" class="form-control" name="image" id="image">
        <br>
        <input type="submit" class="btn btn-primary" value="Upload">
    </form>
</div>
</body>
</html>
