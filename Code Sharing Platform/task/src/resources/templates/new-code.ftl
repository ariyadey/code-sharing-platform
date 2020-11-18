<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
<form action="" method="post">
    <label for="code_snippet">Type your code below:</label>
    <br>
    <textarea id="code_snippet"></textarea>
    <br>
    <button id="send_snippet" onclick="send()" type="submit">Submit</button>
</form>
<script>
    function send() {
        let object = {
            //todo should it be "code"?
            "code": document.getElementById("code_snippet").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status === 200) {
            alert("Success!");
        } else {
            alert("Failure")
        }
    }
</script>
</body>
</html>