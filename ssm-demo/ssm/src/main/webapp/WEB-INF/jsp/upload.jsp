<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/uploadPic" enctype="multipart/form-data" method="post">
        <input type="file" name="uploadFile">
        <input type="submit" value="commit">
    </form>
</body>
</html>
