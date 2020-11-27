<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create</title>
</head>
<body>
<#--Todo: Consider using Form-->
<#--<form action="/api/code/new" method="post">-->
    <label for="code_snippet">Type your code below:</label>
    <br>
    <textarea id="code_snippet"></textarea>
    <br>
    <label for="time_restriction">Time restriction (In seconds):</label><input id="time_restriction" type="text"/>
    <br>
    <label for="views_restriction">View number restriction:</label><input id="views_restriction" type="text"/>
    <br>
    <button id="send_snippet" onclick="send()" type="submit">Submit</button>
<#--</form>-->
<script>
    <#--Todo: Get the ID of code (optional)-->
    <#--Todo: Should I use value or valueOf?-->
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").valueOf,
            "time": document.getElementById("time_restriction").valueOf,
            "views": document.getElementById("views_restriction").valueOf,
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