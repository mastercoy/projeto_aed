<?php

if (isset($_POST["submit"])) {
    //form was submitted
    $username = $_POST["username"];
    $password = $_POST["password"];
    $message = "Logging in: $username";

} else {
    $message = "Please log in.";
}
?>

<!DOCTYPE html>
<html lang="en">
<meta charset="UTF-8">
<head>
    <title>Form</title>
</head>
<body>
<?php echo $message; ?><br>

<form action="form_single.php" enctype="multipart/form-data" method="post">
    Username: <input type="text" name="username" value=""/><br/>
    Password: <input type="password" name="password" value=""/><br/>
    <br/>
    <input type="submit" name="submit" value="Submit"/>
</form>

</body>
</html>
